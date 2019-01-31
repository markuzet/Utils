package utils.twc.deskcom_importer;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.http.client.support.BasicAuthorizationInterceptor;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriComponentsBuilder;
import utils.twc.deskcom_importer.data.BaseResponse;
import utils.twc.deskcom_importer.data.BaseResponseCase;
import utils.twc.deskcom_importer.data.BaseResponseReply;
import utils.twc.deskcom_importer.data.Case;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;

/**
 * @author Mark Kuznetsov (mkuznetsov@evelopers.com)
 */
public class DeskFetchService {

    private static final String DESK_USERNAME = "mkuznetsov@evelopers.com";
    private static final String DESK_PASSWORD = "eVe10per8*";
    private static final String DESK_SERVER = "theweatherchannel.desk.com";
    private static final String DESK_URL = "https://" + DESK_SERVER;
    private static final Integer PER_PAGE_SIZE = 100;
    private static final Integer PAGE_LIMIT = 500;

    private RestTemplate restTemplate = new RestTemplate();

    DeskFetchService() {
        javax.net.ssl.HttpsURLConnection.setDefaultHostnameVerifier(
                (hostname, sslSession) -> {
                    if (hostname.equals(DESK_SERVER)) {
                        return true;
                    }
                    return false;
                });
        restTemplate.getInterceptors().add(new BasicAuthorizationInterceptor(DESK_USERNAME, DESK_PASSWORD));
        restTemplate.headForHeaders(DESK_URL).setAccept(Collections.singletonList(MediaType.APPLICATION_JSON));
    }

    void fetchAllCases() {
        boolean fetchedAll = false;
        Long fromId = null;
        Optional<Case> lastrecord = Optional.empty();
        int totalFetched = 0;

        while (!fetchedAll) {
            for (int page = 1; page < PAGE_LIMIT; page++) {
                BaseResponseCase baseResponse = fetchCases(page, fromId);

                // processing goes here
                collectCasesInfo(baseResponse);
                totalFetched += baseResponse.get_embedded().getEntries().size();

                if (baseResponse.get_embedded().getEntries().size() < PER_PAGE_SIZE) {
                    fetchedAll = true;
                    break;
                }

                lastrecord = baseResponse.get_embedded().getEntries().stream().max(Comparator.comparing(Case::getId));
            }

            System.out.println("totalFetched: " + totalFetched);
            if (lastrecord.isPresent()) {
                fromId = lastrecord.get().getId() + 1;
            } else {
                break;
            }
        }
    }

    private void collectCasesInfo(BaseResponseCase baseResponse) {
        List<Case> cases = baseResponse.get_embedded().getEntries();
        if (cases.size() > 0) {
            for (Case c : cases) {
                getReplies(c);
//                getAttachments(c);
            }
        }
    }

    private void getReplies(Case c) {
        if (c.get_links().getReplies() != null && c.get_links().getReplies().getCount() > 0) {
            String href = c.get_links().getReplies().getHref();

            UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(DESK_URL + href)
                    /*.queryParam("per_page", PER_PAGE_SIZE)
                    .queryParam("page", page)
                    .queryParam("sort_field", "id")
                    .queryParam("sort_direction", "asc")*/;

            ResponseEntity<BaseResponseReply> response = restTemplate.getForEntity(uriBuilder.toUriString(), BaseResponseReply.class);

            System.out.println(response.getBody().get_embedded().getEntries().get(0));
        }
    }

    private BaseResponseCase fetchCases(Integer page, Long fromId) {
        String casesURL = DESK_URL + "/api/v2/cases";

        UriComponentsBuilder uriBuilder = UriComponentsBuilder.fromHttpUrl(casesURL)
                .queryParam("per_page", PER_PAGE_SIZE)
                .queryParam("page", page)
                .queryParam("sort_field", "id")
                .queryParam("sort_direction", "asc");

        if (fromId != null) {
            uriBuilder.queryParam("since_id", fromId);
        }

        ResponseEntity<BaseResponseCase> response = restTemplate.getForEntity(uriBuilder.toUriString(), BaseResponseCase.class);

        return response.getBody();
    }

    private void fetchData() {

    }

}
