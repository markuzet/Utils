package utils.twc.deskcom_importer.data;

/**
 * @author Mark Kuznetsov (mkuznetsov@evelopers.com)
 */
public class Link {
    private String _class;
    private String href;
    private Integer count;

    public String get_Class() {
        return _class;
    }

    public void setClass(String _class) {
        this._class = _class;
    }

    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
