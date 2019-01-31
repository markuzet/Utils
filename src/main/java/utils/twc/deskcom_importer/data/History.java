package utils.twc.deskcom_importer.data;

import java.util.Calendar;
import java.util.List;

/**
 * @author Mark Kuznetsov (mkuznetsov@evelopers.com)
 */
public class History {
    private Long id;
    private String type;
    private String context;
    private Calendar created_at;
    private List<Change> changes;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getContext() {
        return context;
    }

    public void setContext(String context) {
        this.context = context;
    }

    public Calendar getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Calendar created_at) {
        this.created_at = created_at;
    }

    public List<Change> getChanges() {
        return changes;
    }

    public void setChanges(List<Change> changes) {
        this.changes = changes;
    }
}
