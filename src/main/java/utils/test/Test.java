package utils.test;

import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Calendar;

/**
 * @author Mark Kuznetsov (mkuznetsov@evelopers.com)
 */
public class Test {
    public static void main(String[] args) {
        pingMC();
    }

    private static String getPercentForOrg(int orgCount, int totalCount) {
        return String.format("(%.2f%%)", (double) orgCount / (double) totalCount * 100);
    }

    public static void pingMC() {
        try {
            URL server = new URL("https://google.com");

            //      Authenticator.setDefault((new MyAuthenticator("snowedes", "MgWTY0HQNq")));
            HttpURLConnection urlConnection = (HttpURLConnection) server.openConnection();
            urlConnection.setRequestMethod("GET");

            Object content = urlConnection.getContent();
            System.out.println("qwe");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
