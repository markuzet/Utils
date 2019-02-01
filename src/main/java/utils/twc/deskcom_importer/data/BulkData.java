package utils.twc.deskcom_importer.data;

import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

/**
 * @author Mark Kuznetsov (mkuznetsov@evelopers.com)
 */
public class BulkData {
    public static class Record {
        private Map<String, String> fieldValues = new HashMap<>();

        public Record addValue(String fieldName, String fieldValue) {
            fieldValues.put(fieldName, fieldValue);
            return this;
        }

        public Map<String, String> getFieldValues() {
            return fieldValues;
        }
    }

    private List<Record> records = new ArrayList<>();

    public BulkData addRecord(Record rec) {
        this.records.add(rec);
        return this;
    }

    public String getCSV() {
        StringBuilder sb = new StringBuilder();
        if (records.size() > 0) {
            Set<String> fNames = records.get(0).getFieldValues().keySet();
            sb
                    .append(StringUtils.join(fNames, ','))
                    .append('\n');

            for (Record rec : records) {
                List<String> values = new ArrayList<>();
                for (String fName : fNames) {
                    values.add(rec.getFieldValues().get(fName));
                }
                sb
                        .append(StringUtils.join(values, ','))
                        .append('\n');
            }
        }

        return sb.toString();
    }
}
