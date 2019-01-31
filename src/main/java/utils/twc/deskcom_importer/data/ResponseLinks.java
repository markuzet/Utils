package utils.twc.deskcom_importer.data;

/**
 * @author Mark Kuznetsov (mkuznetsov@evelopers.com)
 */
public class ResponseLinks {
    private Link self;
    private Link first;
    private Link last;
    private Link next;
    private Link previous;

    public Link getSelf() {
        return self;
    }

    public void setSelf(Link self) {
        this.self = self;
    }

    public Link getFirst() {
        return first;
    }

    public void setFirst(Link first) {
        this.first = first;
    }

    public Link getLast() {
        return last;
    }

    public void setLast(Link last) {
        this.last = last;
    }

    public Link getNext() {
        return next;
    }

    public void setNext(Link next) {
        this.next = next;
    }

    public Link getPrevious() {
        return previous;
    }

    public void setPrevious(Link previous) {
        this.previous = previous;
    }
}
