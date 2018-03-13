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
        new IpSegment(2732536832L, 2732549119L);
    }

    @Test
    public void constructorFailTest() throws Exception {
        expectedException.expectMessage("IP Segment Error");
        new IpSegment( 2732549119L, 2732536832L);
    }

    @Test
    public void setNetBeginFailTest() throws Exception {
        expectedException.expectMessage("IP Segment Error");
        IpSegment ipSegment = new IpSegment(2732536832L, 2732549119L);
        ipSegment.setNetBegin(4294967295L);
    }

    @Test
    public void setNetEndFailTest() throws Exception {
        expectedException.expectMessage("IP Segment Error");
        IpSegment ipSegment = new IpSegment(2732536832L, 2732549119L);
        ipSegment.setNetEnd(2732536831L);
    }

    @Test
    public void coversTest() throws Exception {
        assertTrue(new IpSegment(10, 20)
                .covers(new IpSegment(9, 11)));
        assertTrue(new IpSegment(10, 20)
                .covers(new IpSegment(19, 22)));
        assertTrue(new IpSegment(10, 20)
                .covers(new IpSegment(12, 18)));
        assertTrue(new IpSegment(10, 20)
                .covers(new IpSegment(9, 21)));
        assertFalse(new IpSegment(10, 20)
                .covers(new IpSegment(2, 9)));
    }

    @Test
    public void containsTest() throws Exception {
        assertTrue(new IpSegment(10, 20)
                .contains(new IpSegment(12, 18)));
    }

    @Test
    public void equalsTest() throws Exception {
        assertTrue(new IpSegment(2732536832L, 2732549119L)
                .equals(new IpSegment(2732536832L, 2732549119L)));
    }

    @Test
    public void compareTest() throws Exception {
        assertTrue(new IpSegment(1,2).compareTo(new IpSegment(3,4)) < 0);
        assertTrue(new IpSegment(3,4).compareTo(new IpSegment(1,2)) > 0);

        assertTrue(new IpSegment(3,4).compareTo(new IpSegment(1,5)) == 0);
        assertTrue(new IpSegment(1,5).compareTo(new IpSegment(3,4)) == 0);
        assertTrue(new IpSegment(1,4).compareTo(new IpSegment(3,5)) == 0);
        assertTrue(new IpSegment(3,5).compareTo(new IpSegment(1,4)) == 0);
    }
}