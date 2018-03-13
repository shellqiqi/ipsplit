package com.seu.vo;

import com.seu.po.IpSegment;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.TreeMap;

import static com.seu.FormatCheckUtil.*;

/**
 * @author <a href="https://github.com/shellqiqi">shellqiqi</a>
 * @since 2018/3/9 19:45
 */
public class IpList {

    public TreeMap<IpSegment, Integer> list = new TreeMap<IpSegment, Integer>();

    public IpList(String filePath) {
        readFromFile(filePath);
    }

    /**
     * Read IP list from file path.
     * @param filePath File path.
     */
    private void readFromFile(String filePath) {
        try {
            FileInputStream fileInputStream = new FileInputStream(filePath);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] splitLine = line.split(",");

                long netBegin = Long.parseLong(splitLine[0]);
                long netEnd = Long.parseLong(splitLine[1]);

                IpSegment ipSegment = new IpSegment(netBegin, netEnd);
                Integer id = Integer.parseInt(splitLine[2]);

                idFormatCheck(id);

                list.put(ipSegment, id);
            }

            fileInputStream.close();
            bufferedReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("Read IP file from \"" + filePath + '\"');
        }
    }
}
