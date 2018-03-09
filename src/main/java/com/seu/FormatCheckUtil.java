package com.seu;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * @author <a href="https://github.com/shellqiqi">shellqiqi</a>
 * @since 2018/3/9 13:27
 */
public class FormatCheckUtil {

    /**
     * Check the ID format is correct.
     * @param id Unsigned 16 bits integer.
     * @throws Exception When ID is not a unsigned 16 bits integer.
     */
    public static void idFormatCheck(Integer id) throws Exception {
        if (id < 0 || id > 65535)
            throw new Exception("ID Format Error - ID must be a 16 bits unsigned integer");
    }


    /**
     * Check the name format is correct.
     * @param name String less or equal than 256 characters.
     * @throws Exception When name is over 256 characters.
     */
    public static void nameFormatCheck(String name) throws Exception {
        if (name.length() > 256)
            throw new Exception("Name Format Error - Name must be a string less than 255 characters.");
    }

    //TODO: Test
    public static void ipFormatCheck(BigInteger ip) throws Exception {
        if (ip.compareTo(new BigInteger("0")) < 0 || ip.compareTo(new BigInteger("4294967295")) > 0)
            throw new Exception("IP Format Error - IP must be a 32 bits unsigned integer.");
    }

}
