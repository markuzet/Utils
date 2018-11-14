package utils;

import org.apache.commons.io.FileUtils;
import org.apache.commons.lang3.StringUtils;

import javax.naming.NamingEnumeration;
import javax.naming.NamingException;
import javax.naming.directory.Attribute;
import javax.naming.directory.Attributes;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Hello world!
 *
 */
public class App {

    private static final List<String> EXTEND_ERRORS_LIST = new ArrayList<>();
    private static final List<String> SKIP_ERRORS_LIST = new ArrayList<>();

    static {
        EXTEND_ERRORS_LIST.add("Error while processing:");
        EXTEND_ERRORS_LIST.add("Sf_idm_contact_response_ErrorHandler");
        EXTEND_ERRORS_LIST.add("Sf_idm_contact_request_ErrorHandler");
        EXTEND_ERRORS_LIST.add("SF Update request failed");
        EXTEND_ERRORS_LIST.add("SFIDs list formation failed");
    }

    static {
        SKIP_ERRORS_LIST.add("Bulk Update result contains failed records");
        SKIP_ERRORS_LIST.add("MalformedURLException: no protocol");
        SKIP_ERRORS_LIST.add("Invalid service/environment paths properties ");
        SKIP_ERRORS_LIST.add("[WH] SFIDs list formation failed");
        SKIP_ERRORS_LIST.add("Failed while processing IDMMaintainPersonOrgHelper. ");
        SKIP_ERRORS_LIST.add("IIB Admin can not update editorial d");
        SKIP_ERRORS_LIST.add("If this is a duplicate contact, please submit a GSD ticke");
        SKIP_ERRORS_LIST.add("Description: Person primary country type is required..");
        SKIP_ERRORS_LIST.add("Description: Org primary country type is required..");
    }

    public static void main(String[] args) throws Exception {
        String fileRoot = "D:\\stock\\IIB_APPS\\prod_logs\\2018-0913";
        Collection<File> files = FileUtils.listFiles(new File(fileRoot), new String[]{"log"}, false);
        String errorsFile = fileRoot + "\\errors_filtered.txt";

//        File f = new File("D:\\stock\\IIB_APPS\\prod_logs\\2018-0913\\mc.log");
        int c = 0;
        boolean includeNext = false;

        List<String> toWrite = new ArrayList<>();

        for (File f : files) {
            List<String> lines = FileUtils.readLines(f, "UTF-8");

            for (String     l : lines) {
                if (SKIP_ERRORS_LIST.stream().anyMatch(l::contains)) {
                    includeNext = false;
                    continue;
                }
                if (l.contains("] ERROR")) {
                    toWrite.add(l);
//                    System.out.println(l);
                    c++;
                    if (EXTEND_ERRORS_LIST.stream().anyMatch(l::contains)) {
                        includeNext = true;
                    }
                } else if (includeNext) {
                    if (!l.startsWith("2018")) {
                        toWrite.add("\t"+ l);
                    } else {
                        includeNext = false;
                    }
                }
                if (c == 100) {
//                    return;
                }
            }

            System.out.println("Processed " + f.getName());
        }

//        toWrite.sort(Comparator.naturalOrder());
        FileUtils.writeLines(new File(errorsFile), toWrite, "\n", true);
        System.out.println("total:" + c);
    }

    private static boolean containsExtendPart(String l) {
        return EXTEND_ERRORS_LIST.stream().anyMatch(l::contains);
    }

    private static String transform(String value) {
        List<String> res = new ArrayList<>();
        if (StringUtils.isNotBlank(value)) {
            for (String v : value.split("/")) {
                if (v.startsWith("CN=")) {
                    res.add(v.substring(v.indexOf("CN=") + 3));
                }
                if (v.startsWith("OU")) {
                    res.add(v.substring(v.indexOf("OU=") + 3));
                }
                if (v.startsWith("O=")) {
                    if (v.contains("@")) {
                        res.add(v.substring(v.indexOf("O=") + 2, v.indexOf("@")));
                    } else {
                        res.add(v.substring(v.indexOf("O=") + 2));
                    }
                }
            }
        }

        return StringUtils.join(res, "/");
    }


}
