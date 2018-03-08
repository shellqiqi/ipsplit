package com.seu;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 * @author <a href="https://github.com/shellqiqi">shellqiqi</a>
 * @since 2018/3/8 23:14
 */
public class IdListTest {

    @Test
    public void idFormatCheckPassTest() throws Exception  {
        IdList.idFormatCheck(0);
        IdList.idFormatCheck(65535);
    }

    @Test(expected = Exception.class)
    public void idFormatCheckFailTest() throws Exception {
        IdList.idFormatCheck(65536);
    }

    @Test
    public void nameFormatCheckPassTest() throws Exception {
        IdList.nameFormatCheck("hello world");
        IdList.nameFormatCheck("你好世界");
    }

    @Test(expected = Exception.class)
    public void nameFormatCheckFailTest() throws Exception {
        final int LENGTH = 257;
        char[] chars = new char[LENGTH];
        for (int i = 0; i < LENGTH; i++) {
            chars[i] = '你';
        }
        IdList.nameFormatCheck(new String(chars));
    }

    @Test
    public void readFromFileTest() {
        IdList idList = new IdList("./assets/id.list");
        assertEquals("中国电信", idList.list.get(1));
        assertEquals("北美洲-安圭拉(英属)", idList.list.get(16390));
        assertEquals("组播地址", idList.list.get(65535));
    }
}