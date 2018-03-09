package com.seu.vo;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;

import static com.seu.FormatCheckUtil.*;

/**
 * @author <a href="https://github.com/shellqiqi">shellqiqi</a>
 * @since 2018/3/8 22:35
 */
public class IdList {

    public HashMap<Integer, String> list = new HashMap<Integer, String>();

    /**
     * Constructor for ID list.
     * @param filePath file path.
     */
    public IdList(String filePath) {
        readFromFile(filePath);
    }

    /**
     * Read ID list from file path.
     * @param filePath filepath.
     */
    private void readFromFile(String filePath) {
        try {
            FileInputStream fileInputStream = new FileInputStream(filePath);
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(fileInputStream));

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
            System.out.println("Read file from \"" + filePath + '\"');
        }
    }
}
