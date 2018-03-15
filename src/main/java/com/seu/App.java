package com.seu;

import com.seu.po.IpSegment;
import com.seu.vo.IdList;
import com.seu.vo.IpList;
import com.seu.vo.SplitList;

import static com.seu.FormatCheckUtil.*;

/**
 * @author <a href="https://github.com/shellqiqi">shellqiqi</a>
 * @since 2018/3/8 22:34
 */
public class App {
    public static void main(String[] args) throws Exception {
        IpList ipList = new IpList(args[0]);
        IdList idList = new IdList(args[1]);
        SplitList splitList = new SplitList(args[2]);

        for (IpSegment splitSegment :
                splitList.list.keySet()) {
            IpSegment floorKey = ipList.list.floorKey(splitSegment);
            String name = splitList.list.get(splitSegment);

            if (floorKey.contains(splitSegment)) {
                int id;
                if (idList.list.containsValue(name)) {
                    id = idList.getKey(name);
                } else {
                    id = 32768;
                    while (idList.list.containsKey(id)) id++;
                    idFormatCheck(id);
                    idList.list.put(id, splitList.list.get(splitSegment));
                }

                ipList.split(floorKey, splitSegment, id);
            } else {
                throw new Exception("Split segment step over two IP segments.");
            }
        }

        ipList.saveToFile(args[0] + "new");
        idList.saveToFile(args[1] + "new");
    }
}
