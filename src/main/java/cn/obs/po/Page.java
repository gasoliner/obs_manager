package cn.obs.po;

/**
 * Created by wanzhenghang on 2017/5/13.
 */
public class Page {

    int page;

    int size;

    int start;

    String user;

    @Override
    public String toString() {
        return "PageInfo{" +
                "page=" + page +
                ", size=" + size +
                ", start=" + start +
                ", user='" + user + '\'' +
                '}';
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public int getStart() {
        return start;
    }

    public void setStart(int start) {
        this.start = start;
    }
}
