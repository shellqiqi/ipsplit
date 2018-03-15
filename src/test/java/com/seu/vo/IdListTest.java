package com.seu.vo;

import org.junit.Ignore;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;

import static org.junit.Assert.*;

/**
 * @author <a href="https://github.com/shellqiqi">shellqiqi</a>
 * @since 2018/3/8 23:14
 */
public class IdListTest {

    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Test
    @Ignore
    public void readFromFileTest() {
        IdList idList = new IdList("./assets/id.list");
        assertEquals("中国电信", idList.list.get(1));
        assertEquals("北美洲-安圭拉(英属)", idList.list.get(16390));
        assertEquals("组播地址", idList.list.get(65535));
    }

    @Test
    @Ignore
    public void saveToFileTest() {
        IdList idList = new IdList();
        idList.list.put(1, "hello");
        idList.saveToFile("assets/IdListSaveToFileTest.txt");
    }

    @Test
    public void getKeyTest() {
        IdList idList = new IdList();
        idList.list.put(1, "hello");
        idList.list.put(2, "world");
        idList.list.put(3, "你好");
        assertEquals(3, idList.getKey("你好").intValue());
        expectedException.expect(NullPointerException.class);
        assertNotEquals(2, idList.getKey("or").intValue());
    }
}