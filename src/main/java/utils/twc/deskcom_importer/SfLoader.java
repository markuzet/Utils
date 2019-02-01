package utils.twc.deskcom_importer;

import com.force.api.ApiConfig;
import com.force.api.ForceApi;
import com.force.api.QueryResult;
import com.force.api.bulk.JobInfo;
import utils.twc.deskcom_importer.data.BulkData;
import utils.twc.deskcom_importer.data.Case;
import utils.twc.deskcom_importer.data.sf.Converter;
import utils.twc.deskcom_importer.data.sf.SfCase;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author Mark Kuznetsov (mkuznetsov@evelopers.com)
 */
public class SfLoader {

    static final String USERNAME     = "mkuznetsov@evelopers.com.b2c.fc1";
    static final String PASSWORD     = "eVe10per8*PoThsojiVQl6xULUGWbf2rhJ1";
    static final String LOGINURL     = "https://test.salesforce.com";

    private ForceApi api = new ForceApi(
            new ApiConfig()
                    .setUsername(USERNAME)
                    .setPassword(PASSWORD)
                    .setLoginEndpoint(LOGINURL));

    public void testCreds() {
        QueryResult<Map> query = api.query("SELECT Id, Name FROM Account limit 1");
        System.out.println(query.getRecords());
    }

    /*public void insertCases(List<Case> cases) {
        BulkData data = new BulkData();
        for (Case c : cases) {
//            BulkData.Record record = new BulkData.Record();
//            record.addValue("Subject", c.getBlurb().replaceAll("\r", ""));
//            data.addRecord(record);
            Map<String, Object> rec = new HashMap<>();
            rec.put("Subject", c.getBlurb());
            String aCase = api.createSObject("case", rec);
            System.out.println(aCase);
        }

//        JobInfo jobInfo = api.bulkInsert(data.getCSV(), "case");
//        System.out.println("failed: " + jobInfo.getFailedRecordsCSV());
//        System.out.println("ok: " + jobInfo.getSuccessfulRecordsCSV());
    }*/

    public void insertCases(List<Case> cases) {
        BulkData data = new BulkData();
        for (Case c : cases) {
//            BulkData.Record record = new BulkData.Record();
//            record.addValue("Subject", c.getBlurb().replaceAll("\r", ""));
//            data.addRecord(record);
            String aCase = api.createSObject("case", Converter.convertToSf(c));
            System.out.println(aCase);
        }

//        JobInfo jobInfo = api.bulkInsert(data.getCSV(), "case");
//        System.out.println("failed: " + jobInfo.getFailedRecordsCSV());
//        System.out.println("ok: " + jobInfo.getSuccessfulRecordsCSV());
    }
}
