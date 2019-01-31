package utils.twc.deskcom_importer.data;

import java.util.List;

/**
 * @author Mark Kuznetsov (mkuznetsov@evelopers.com)
 */
public class Embedded<T> {
    private List<T> entries;

    public List<T> getEntries() {
        return entries;
    }

    public void setEntries(List<T> entries) {
        this.entries = entries;
    }
}
