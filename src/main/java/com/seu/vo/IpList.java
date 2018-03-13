package com.seu.vo;

import com.seu.po.IpSegment;

import java.io.*;
import java.util.TreeMap;

import static com.seu.FormatCheckUtil.*;

/**
 * @author <a href="https://github.com/shellqiqi">shellqiqi</a>
 * @since 2018/3/9 19:45
 */
public class IpList {

    public TreeMap<IpSegment, Integer> list = new TreeMap<>();

    /**
     * Constructor for IP list.
     * @param filePath Filepath.
     */
    public IpList(String filePath) {
        readFromFile(filePath);
    }

    public IpList() {}

    /**
     * Read IP list from file.
     * @param filePath Filepath.
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

    /**
     * Save IP list to file.
     * @param filePath Filepath.
     */
    public void saveToFile(String filePath) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(filePath);
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(fileOutputStream));

            for (IpSegment k :
                    list.keySet()) {
                writer.write(k.getNetBegin() + "," + k.getNetEnd() + "," + list.get(k) + "\n");
            }

            writer.close();
            fileOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Split IP list by IP segment.
     * @param key Target IP segment.
     * @param split Split IP segment.
     * @param id ID of split IP segment.
     */
    public void split(IpSegment key, IpSegment split, int id) {
        int oldId = list.get(key);
        list.remove(key);
        if (key.getNetBegin() != split.getNetBegin())
            list.put(new IpSegment(key.getNetBegin(), split.getNetBegin() - 1), oldId);
        list.put(split, id);
        if (split.getNetEnd() != key.getNetEnd())
            list.put(new IpSegment(split.getNetEnd() + 1, key.getNetEnd()), oldId);
    }
}
