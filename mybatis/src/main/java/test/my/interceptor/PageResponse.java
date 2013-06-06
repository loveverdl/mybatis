package test.my.interceptor;

import java.io.Serializable;
import java.util.List;

public class PageResponse<T> implements Serializable {
    /**
     * 
     */
    private static final long serialVersionUID = 7139574756965109944L;
    private List<T> data;
    private int totalCount;

    public PageResponse(int totalCount, List<T> data) {
        this.setTotalCount(totalCount);
        this.setData(data);
    }

    public PageResponse() {
        this.setData(null);
        this.setTotalCount(0);
    }

    public int getTotalCount() {
        return totalCount;
    }

    public void setTotalCount(int totalCount) {
        this.totalCount = totalCount;
    }

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }
}
