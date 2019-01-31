package utils.twc.deskcom_importer.data;

/**
 * @author Mark Kuznetsov (mkuznetsov@evelopers.com)
 */
public class BaseResponse<T> {
    private String page;
    private Integer total_entries;
    private ResponseLinks _links;

    private Embedded<T> _embedded;

    public String getPage() {
        return page;
    }

    public void setPage(String page) {
        this.page = page;
    }

    public Integer getTotal_entries() {
        return total_entries;
    }

    public void setTotal_entries(Integer total_entries) {
        this.total_entries = total_entries;
    }

    public ResponseLinks get_links() {
        return _links;
    }

    public void set_links(ResponseLinks _links) {
        this._links = _links;
    }

    public Embedded<T> get_embedded() {
        return _embedded;
    }

    public void set_embedded(Embedded<T> _embedded) {
        this._embedded = _embedded;
    }
}
