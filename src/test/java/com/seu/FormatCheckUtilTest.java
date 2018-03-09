package com.seu;

import org.junit.Test;

import java.math.BigInteger;

import static org.junit.Assert.*;

import static com.seu.FormatCheckUtil.*;

public class FormatCheckUtilTest {

    @Test
    public void idFormatCheckPassTest() throws Exception {
        idFormatCheck(0);
        idFormatCheck(65535);
    }

    @Test(expected = Exception.class)
    public void idFormatCheckFailTestForNegative() throws Exception {
        idFormatCheck(-1);
    }

    @Test(expected = Exception.class)
    public void idFormatCheckFailTestForPositive() throws Exception {
        idFormatCheck(65536);
    }

    @Test
    public void nameFormatCheckPassTest() throws Exception {
        nameFormatCheck("hello world");
        nameFormatCheck("你好世界");
    }

    @Test(expected = Exception.class)
    public void nameFormatCheckFailTest() throws Exception {
        final int LENGTH = 257;
        char[] chars = new char[LENGTH];
        for (int i = 0; i < LENGTH; i++) {
            chars[i] = '你';
        }
        nameFormatCheck(new String(chars));
    }

    @Test
    public void ipFormatCheckPassTest() throws Exception {
        ipFormatCheck(new BigInteger("0"));
    }

    @Test(expected = Exception.class)
    public void ipFormatCheckFailTestForNegative() throws Exception {
        ipFormatCheck(new BigInteger("-1"));
    }

    @Test(expected = Exception.class)
    public void ipFormatCheckFailTestForPositive() throws Exception {
        ipFormatCheck(new BigInteger("4294967296"));
    }
}