package com.seu.po;

import static com.seu.FormatCheckUtil.*;

/**
 * @author <a href="https://github.com/shellqiqi">shellqiqi</a>
 * @since 2018/3/9 13:24
 */
public class IpSegment implements Comparable<IpSegment> {

    private long netBegin;
    private long netEnd;

    public IpSegment(long netBegin, long netEnd) throws Exception {
        ipFormatCheck(netBegin);
        ipFormatCheck(netEnd);
        this.netBegin = netBegin;
        this.netEnd = netEnd;
        ipSegmentCheck();
    }

    public long getNetBegin() {
        return netBegin;
    }

    public void setNetBegin(long netBegin) throws Exception {
        ipFormatCheck(netBegin);
        this.netBegin = netBegin;
        ipSegmentCheck();
    }

    public long getNetEnd() {
        return netEnd;
    }

    public void setNetEnd(long netEnd) throws Exception {
        ipFormatCheck(netEnd);
        this.netEnd = netEnd;
        ipSegmentCheck();
    }

    /**
     * Check the begin IP is small or equal than end IP.
     * @throws Exception When begin IP is larger than end IP.
     */
    private void ipSegmentCheck() throws Exception {
        if (netBegin > netEnd)
            throw new Exception("IP Segment Error - Begin IP must small or equal than end IP.");
    }

    /**
     * Implement of Comparable.
     * @param o Another IP segment.
     * @return Positive if bigger. Negative if smaller. Zero if equal or cover each other.
     */
    public int compareTo(IpSegment o) {
        if (covers(o)) return 0;
        else if (netBegin > o.netBegin) return 1;
        else if (netBegin < o.netBegin) return -1;
        return 0;
    }

    public boolean covers(IpSegment o) {
        return contains(o) ||
                !(o.netEnd < netBegin || o.netBegin > netEnd);
    }

    public boolean contains(IpSegment o) {
        return netBegin <= o.netBegin && o.netEnd <= netEnd;
    }

    public boolean equals(IpSegment o) {
        return netBegin == o.netBegin && o.netEnd == netEnd;
    }

    @Override
    public String toString() {
        return "IpSegment{" +
                "netBegin=" + netBegin +
                ", netEnd=" + netEnd +
                '}';
    }
}
