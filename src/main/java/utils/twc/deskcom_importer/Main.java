package utils.twc.deskcom_importer;

/**
 * @author Mark Kuznetsov (mkuznetsov@evelopers.com)
 */
public class Main {

    public static void main(String[] args) {
        DeskFetchService deskService = new DeskFetchService();
        deskService.fetchAllCases();

        SfLoader sfLoader = new SfLoader();
        sfLoader.testCreds();
    }
}
