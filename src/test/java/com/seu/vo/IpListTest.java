package com.seu.vo;

import com.seu.po.IpSegment;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

/**
 * @author <a href="https://github.com/shellqiqi">shellqiqi</a>
 * @since 2018/3/11 11:30
 */
public class IpListTest {

    @Test
    public void readFromFileTest() {
        IpList ipList = new IpList("assets/ip.list");
        assertEquals(16616,
                ipList.list.get(new IpSegment(67177834, 67177972)).intValue());
    }

    @Test
    public void splitTest() {
        IpList ipList = new IpList();
        ipList.list.put(new IpSegment(0, 100), 0);

        SplitList splitList = new SplitList();
        splitList.list.put(new IpSegment(20, 30), "a");
        splitList.list.put(new IpSegment(31, 50), "b");
        splitList.list.put(new IpSegment(80, 100), "c");

        IpSegment result[] = {
                new IpSegment(0, 19),
                new IpSegment(20, 30),
                new IpSegment(31, 50),
                new IpSegment(51, 79),
                new IpSegment(80, 100)
        };

        int id = 1;
        for (IpSegment splitSegment :
                splitList.list.keySet()) {
            IpSegment floorKey = ipList.list.floorKey(splitSegment);
            if (floorKey.contains(splitSegment)) {
                ipList.split(floorKey, splitSegment, id);
                id++;
            }
        }

        int i = 0;
        for (IpSegment e :
                ipList.list.keySet()) {
            assertTrue(e.equals(result[i]));
            i++;
        }
    }

    @Test
    @Ignore
    public void saveToFileTest() {
        IpList ipList = new IpList();
        ipList.list.put(new IpSegment(12,122), 1);
        ipList.saveToFile("assets/IpListSaveToFileTest.txt");
    }
}