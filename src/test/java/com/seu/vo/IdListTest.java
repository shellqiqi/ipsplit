package com.seu.vo;

import com.seu.vo.IdList;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author <a href="https://github.com/shellqiqi">shellqiqi</a>
 * @since 2018/3/8 23:14
 */
public class IdListTest {

    @Test
    public void readFromFileTest() {
        IdList idList = new IdList("./assets/id.list");
        assertEquals("中国电信", idList.list.get(1));
        assertEquals("北美洲-安圭拉(英属)", idList.list.get(16390));
        assertEquals("组播地址", idList.list.get(65535));
    }
}