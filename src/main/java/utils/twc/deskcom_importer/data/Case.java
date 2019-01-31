package utils.twc.deskcom_importer.data;

import java.util.Calendar;
import java.util.List;

/**
 * @author Mark Kuznetsov (mkuznetsov@evelopers.com)
 */
public class Case {
    private Long id;
    private String blurb;
    private Calendar changed_at;
    private Calendar created_at;
    private List<String> labels;
    private List<String> label_ids;
    private CaseLinks _links;

    // post populated
    private List<Reply> replies;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getBlurb() {
        return blurb;
    }

    public void setBlurb(String blurb) {
        this.blurb = blurb;
    }

    public Calendar getChanged_at() {
        return changed_at;
    }

    public void setChanged_at(Calendar changed_at) {
        this.changed_at = changed_at;
    }

    public Calendar getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Calendar created_at) {
        this.created_at = created_at;
    }

    public List<String> getLabels() {
        return labels;
    }

    public void setLabels(List<String> labels) {
        this.labels = labels;
    }

    public List<String> getLabel_ids() {
        return label_ids;
    }

    public void setLabel_ids(List<String> label_ids) {
        this.label_ids = label_ids;
    }

    public CaseLinks get_links() {
        return _links;
    }

    public void set_links(CaseLinks _links) {
        this._links = _links;
    }

    public List<Reply> getReplies() {
        return replies;
    }

    public void setReplies(List<Reply> replies) {
        this.replies = replies;
    }
}
