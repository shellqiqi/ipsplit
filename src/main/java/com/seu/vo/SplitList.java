package com.seu.vo;

import com.seu.po.IpSegment;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.TreeMap;

public class SplitList {

    public TreeMap<IpSegment, String> list = new TreeMap<>();

    /**
     * Constructor for split list.
     * @param filePath Filepath.
     */
    public SplitList(String filePath) {
        readFromFile(filePath);
    }

    public SplitList() {}

    /**
     * Read split list from filepath.
     * @param filePath Filepath.
     */
    private void readFromFile(String filePath) {
        try {
            FileInputStream fileInputStream = new FileInputStream(filePath);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream, "utf-8"));

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] splitLine = line.split(",");

                long netBegin = Long.parseLong(splitLine[0]);
                long netEnd = Long.parseLong(splitLine[1]);

                IpSegment ipSegment = new IpSegment(netBegin, netEnd);

                list.put(ipSegment, splitLine[2]);
            }

            fileInputStream.close();
            bufferedReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("Read split file from \"" + filePath + '\"');
        }
    }
}
