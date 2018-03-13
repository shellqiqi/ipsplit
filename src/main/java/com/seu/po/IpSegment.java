package com.seu.po;

import static com.seu.FormatCheckUtil.*;

/**
 * @author <a href="https://github.com/shellqiqi">shellqiqi</a>
 * @since 2018/3/9 13:24
 */
public class IpSegment implements Comparable<IpSegment> {

    private long netBegin;
    private long netEnd;

    public IpSegment(long netBegin, long netEnd) {
        try {
            ipFormatCheck(netBegin);
            ipFormatCheck(netEnd);
            this.netBegin = netBegin;
            this.netEnd = netEnd;
            ipSegmentCheck();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public long getNetBegin() {
        return netBegin;
    }

    public void setNetBegin(long netBegin) {
        try {
            ipFormatCheck(netBegin);
            this.netBegin = netBegin;
            ipSegmentCheck();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public long getNetEnd() {
        return netEnd;
    }

    public void setNetEnd(long netEnd) {
        try {
            ipFormatCheck(netEnd);
            this.netEnd = netEnd;
            ipSegmentCheck();
        } catch (Exception e) {
            e.printStackTrace();
        }
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
     * @return Only compare beginning.
     */
    public int compareTo(IpSegment o) {
        return Long.compare(netBegin, o.netBegin);
    }

    /**
     * Whether IP segment covers each other.
     * @param o Segment as an operand.
     * @return True if covered.
     */
    public boolean covers(IpSegment o) {
        return contains(o) ||
                !(o.netEnd < netBegin || o.netBegin > netEnd);
    }

    /**
     * Whether IP segment contains another.
     * @param o Segment as an operand.
     * @return True if contains operand.
     */
    public boolean contains(IpSegment o) {
        return netBegin <= o.netBegin && o.netEnd <= netEnd;
    }

    /**
     * Whether two segments equal to each other digitally.
     * @param o Segment as an operand.
     * @return True if they are equal.
     */
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
