package com.seu.vo;

import java.io.*;
import java.util.TreeMap;

import static com.seu.FormatCheckUtil.*;

/**
 * @author <a href="https://github.com/shellqiqi">shellqiqi</a>
 * @since 2018/3/8 22:35
 */
public class IdList {

    public TreeMap<Integer, String> list = new TreeMap<>();

    /**
     * Constructor for ID list.
     * @param filePath Filepath.
     */
    public IdList(String filePath) {
        readFromFile(filePath);
    }

    public IdList() {}

    public Integer getKey(String value) {
        for (Integer k :
                list.keySet()) {
            if (list.get(k).equals(value)) return k;
        }
        return null;
    }

    /**
     * Read ID list from filepath.
     * @param filePath Filepath.
     */
    private void readFromFile(String filePath) {
        try {
            FileInputStream fileInputStream = new FileInputStream(filePath);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream, "utf-8"));

            String line;
            while ((line = bufferedReader.readLine()) != null) {
                String[] splitLine = line.split(",");

                Integer id = Integer.parseInt(splitLine[0]);
                String name = splitLine[1];

                idFormatCheck(id);
                nameFormatCheck(name);

                list.put(id, name);
            }

            fileInputStream.close();
            bufferedReader.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("Read ID file from \"" + filePath + '\"');
        }
    }

    /**
     * Save ID list to file.
     * @param filePath Filepath.
     */
    public void saveToFile(String filePath) {
        try {
            FileOutputStream fileOutputStream = new FileOutputStream(filePath);
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(fileOutputStream, "utf-8"));
            StringBuilder builder = new StringBuilder();
            for (Integer k : list.keySet()) {
                builder.append(k).append(',').append(list.get(k)).append('\n');
            }
            writer.write(builder.toString());
            writer.close();
            fileOutputStream.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            System.out.println("Save ID file to \"" + filePath + '\"');
        }
    }
}
