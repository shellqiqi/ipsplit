package com.seu.po;

import java.math.BigInteger;

import static com.seu.FormatCheckUtil.*;

/**
 * @author <a href="https://github.com/shellqiqi">shellqiqi</a>
 * @since 2018/3/9 13:24
 */
public class IpSegment {
    private BigInteger netBegin;
    private BigInteger netEnd;

    public IpSegment(BigInteger netBegin, BigInteger netEnd) throws Exception {
        ipFormatCheck(netBegin);
        ipFormatCheck(netEnd);
        this.netBegin = netBegin;
        this.netEnd = netEnd;
        ipSegmentCheck();
    }

    public IpSegment(String netBegin, String netEnd) throws Exception {
        this(new BigInteger(netBegin), new BigInteger(netEnd));
    }

    public BigInteger getNetBegin() {
        return netBegin;
    }

    public void setNetBegin(BigInteger netBegin) throws Exception {
        ipFormatCheck(netBegin);
        this.netBegin = netBegin;
        ipSegmentCheck();
    }

    public void setNetBegin(String netBegin) throws Exception {
        setNetBegin(new BigInteger(netBegin));
    }

    public BigInteger getNetEnd() {
        return netEnd;
    }

    public void setNetEnd(BigInteger netEnd) throws Exception {
        ipFormatCheck(netEnd);
        this.netEnd = netEnd;
        ipSegmentCheck();
    }

    public void setNetEnd(String netEnd) throws Exception {
        setNetEnd(new BigInteger(netEnd));
    }

    /**
     * Check the begin IP is small or equal than end IP.
     * @throws Exception When begin IP is larger than end IP.
     */
    private void ipSegmentCheck() throws Exception {
        if (netBegin.compareTo(netEnd) > 0)
            throw new Exception("IP Segment Error - Begin IP must small or equal than end IP.");
    }
}
