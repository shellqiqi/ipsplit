package com.seu.vo;

import com.seu.po.IpSegment;
import org.junit.Test;

import java.util.Set;

import static org.junit.Assert.*;

/**
 * @author <a href="https://github.com/shellqiqi">shellqiqi</a>
 * @since 2018/3/11 11:30
 */
public class IpListTest {

    @Test
    public void readFromFileTest() throws Exception {
        IpList ipList = new IpList("assets/ip.list");
        assertEquals(16616, ipList.list.get(new IpSegment(67177834, 67177972)).intValue());
        Set<IpSegment> ipSegmentSet = ipList.list.keySet();
        for (IpSegment segment : ipSegmentSet) {
            System.out.println(segment);
        }
    }
}