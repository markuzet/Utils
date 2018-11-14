package utils.test;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.List;

/**
 * @author Mark Kuznetsov (mkuznetsov@evelopers.com)
 */
public class TestExecuteCommand {
    public static void main(String[] args) throws IOException {
        testProcessBuilderExec();
    }

    private static void testProcessBuilderExec() throws IOException {
        ProcessBuilder builder = new ProcessBuilder(
                "C:\\Program Files (x86)\\apache-maven-3.1.0\\bin\\mvn.bat", "--version");
        builder.redirectErrorStream(true);
        Process p = builder.start();
        BufferedReader r = new BufferedReader(new InputStreamReader(p.getInputStream()));
        String line;
        while (true) {
            line = r.readLine();
            if (line == null) { break; }
            System.out.println(line);
        }
    }

    private String executeCommand(String command) {

        StringBuffer output = new StringBuffer();

        Process p;
        try {
            p = Runtime.getRuntime().exec(command);
            p.waitFor();
            BufferedReader reader =
                    new BufferedReader(new InputStreamReader(p.getInputStream()));

            String line = "";
            while ((line = reader.readLine())!= null) {
                output.append(line + "\n");
            }

        } catch (Exception e) {
            e.printStackTrace();
        }

        return output.toString();

    }



}
