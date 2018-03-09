package com.seu.PO;

/**
 * @author <a href="https://github.com/shellqiqi">shellqiqi</a>
 * @since 2018/3/9 13:24
 */
public class IpListItem {
    private Integer netBegin;
    private Integer netEnd;
    private Integer id;

    public Integer getNetBegin() {
        return netBegin;
    }

    //TODO: check parameter
    public void setNetBegin(Integer netBegin) {
        this.netBegin = netBegin;
    }

    public Integer getNetEnd() {
        return netEnd;
    }

    public void setNetEnd(Integer netEnd) {
        this.netEnd = netEnd;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
}
