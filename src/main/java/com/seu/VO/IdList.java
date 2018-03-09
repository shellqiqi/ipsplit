package com.seu.VO;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStreamReader;
import java.util.HashMap;

/**
 * @author <a href="https://github.com/shellqiqi">shellqiqi</a>
 * @since 2018/3/8 22:35
 */
public class IdList { //TODO: Remove check functions and map component

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
    public  void readFromFile(String filePath) {
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
            System.out.println("Complete the file read from " + filePath);
        }
    }

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
}
