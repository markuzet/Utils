package utils.twc.deskcom_importer.data;

import java.util.List;

/**
 * @author Mark Kuznetsov (mkuznetsov@evelopers.com)
 */
public class Change {
    private String field;
    private Object from;
    private Object to;

    public String getField() {
        return field;
    }

    public void setField(String field) {
        this.field = field;
    }

    public Object getFrom() {
        return from;
    }

    public void setFrom(Object from) {
        this.from = from;
    }

    public Object getTo() {
        return to;
    }

    public void setTo(Object to) {
        this.to = to;
    }
}
