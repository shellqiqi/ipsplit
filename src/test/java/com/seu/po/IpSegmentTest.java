package com.seu.po;

import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

/**
 * @author <a href="https://github.com/shellqiqi">shellqiqi</a>
 * @since 2018/3/9 17:55
 */
public class IpSegmentTest {

    @Rule
    public ExpectedException expectedException= ExpectedException.none();

    @Test
    public void constructorPassTest() throws Exception {
        new IpSegment("2732536832", "2732549119");
    }

    @Test
    public void constructorFailTest() throws Exception {
        expectedException.expectMessage("IP Segment Error");
        new IpSegment( "2732549119", "2732536832");
    }

    @Test
    public void setNetBeginFailTest() throws Exception {
        expectedException.expectMessage("IP Segment Error");
        IpSegment ipSegment = new IpSegment("2732536832", "2732549119");
        ipSegment.setNetBegin("4294967295");
    }

    @Test
    public void setNetEndFailTest() throws Exception {
        expectedException.expectMessage("IP Segment Error");
        IpSegment ipSegment = new IpSegment("2732536832", "2732549119");
        ipSegment.setNetEnd("2732536831");
    }
}