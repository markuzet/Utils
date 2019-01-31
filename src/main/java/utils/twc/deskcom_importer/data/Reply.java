package utils.twc.deskcom_importer.data;

import java.util.Calendar;

/**
 * @author Mark Kuznetsov (mkuznetsov@evelopers.com)
 */
public class Reply {
    private Calendar created_at;
    private String bcc;
    private String body;
    private String cc;
    private String from;
    private Long id;
    private Calendar sent_at;
    private String status;
    private String to;
    private Calendar updated_at;

    public Calendar getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Calendar created_at) {
        this.created_at = created_at;
    }

    public String getBcc() {
        return bcc;
    }

    public void setBcc(String bcc) {
        this.bcc = bcc;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }

    public String getCc() {
        return cc;
    }

    public void setCc(String cc) {
        this.cc = cc;
    }

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Calendar getSent_at() {
        return sent_at;
    }

    public void setSent_at(Calendar sent_at) {
        this.sent_at = sent_at;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getTo() {
        return to;
    }

    public void setTo(String to) {
        this.to = to;
    }

    public Calendar getUpdated_at() {
        return updated_at;
    }

    public void setUpdated_at(Calendar updated_at) {
        this.updated_at = updated_at;
    }
}
