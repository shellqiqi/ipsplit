package com.seu.po;

import java.math.BigInteger;

import static com.seu.FormatCheckUtil.*;

/**
 * @author <a href="https://github.com/shellqiqi">shellqiqi</a>
 * @since 2018/3/9 13:24
 */
public class IpListItem {
    private BigInteger netBegin;
    private BigInteger netEnd;
    private Integer id;

    public BigInteger getNetBegin() {
        return netBegin;
    }

    public void setNetBegin(BigInteger netBegin) throws Exception {
        ipFormatCheck(netBegin);
        this.netBegin = netBegin;
    }

    public BigInteger getNetEnd() {
        return netEnd;
    }

    public void setNetEnd(BigInteger netEnd) throws Exception {
        ipFormatCheck(netEnd);
        this.netEnd = netEnd;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) throws Exception {
        idFormatCheck(id);
        this.id = id;
    }
}
