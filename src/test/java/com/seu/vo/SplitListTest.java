package com.seu.vo;

import com.seu.po.IpSegment;
import org.junit.Ignore;
import org.junit.Test;

import static org.junit.Assert.*;

public class SplitListTest {

    @Test
    @Ignore
    public void readFromFileTest() {
        SplitList splitList = new SplitList("assets/seu.list");
        assertEquals("四牌楼",
                splitList.list.get(new IpSegment(986204416,986204927)));
    }
}