package utils.twc.deskcom_importer.data;

/**
 * @author Mark Kuznetsov (mkuznetsov@evelopers.com)
 */
public class CaseLinks {
    private Link labels;
    private Link assigned_group;
    private Link macro_preview;
    private Link case_links;
    private Link attachments;
    private Link history;
    private Link customer;
    private Link replies;
    private Link draft;
    private Link notes;
    private Link self;
    private Link message;

    private String locked_by;
    private String feeadback;
    private String assigned_user;

    public Link getLabels() {
        return labels;
    }

    public void setLabels(Link labels) {
        this.labels = labels;
    }

    public Link getAssigned_group() {
        return assigned_group;
    }

    public void setAssigned_group(Link assigned_group) {
        this.assigned_group = assigned_group;
    }

    public Link getMacro_preview() {
        return macro_preview;
    }

    public void setMacro_preview(Link macro_preview) {
        this.macro_preview = macro_preview;
    }

    public Link getCase_links() {
        return case_links;
    }

    public void setCase_links(Link case_links) {
        this.case_links = case_links;
    }

    public Link getAttachments() {
        return attachments;
    }

    public void setAttachments(Link attachments) {
        this.attachments = attachments;
    }

    public Link getHistory() {
        return history;
    }

    public void setHistory(Link history) {
        this.history = history;
    }

    public Link getCustomer() {
        return customer;
    }

    public void setCustomer(Link customer) {
        this.customer = customer;
    }

    public Link getReplies() {
        return replies;
    }

    public void setReplies(Link replies) {
        this.replies = replies;
    }

    public Link getDraft() {
        return draft;
    }

    public void setDraft(Link draft) {
        this.draft = draft;
    }

    public Link getNotes() {
        return notes;
    }

    public void setNotes(Link notes) {
        this.notes = notes;
    }

    public Link getSelf() {
        return self;
    }

    public void setSelf(Link self) {
        this.self = self;
    }

    public Link getMessage() {
        return message;
    }

    public void setMessage(Link message) {
        this.message = message;
    }

    public String getLocked_by() {
        return locked_by;
    }

    public void setLocked_by(String locked_by) {
        this.locked_by = locked_by;
    }

    public String getFeeadback() {
        return feeadback;
    }

    public void setFeeadback(String feeadback) {
        this.feeadback = feeadback;
    }

//    public String getAssigned_user() {
//        return assigned_user;
//    }
//
//    public void setAssigned_user(String assigned_user) {
//        this.assigned_user = assigned_user;
//    }
}
