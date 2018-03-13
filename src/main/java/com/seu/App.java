package com.seu;

import com.seu.po.IpSegment;
import com.seu.vo.IdList;
import com.seu.vo.IpList;
import com.seu.vo.SplitList;

/**
 * @author <a href="https://github.com/shellqiqi">shellqiqi</a>
 * @since 2018/3/8 22:34
 */
public class App {
    public static void main(String[] args) {
        IpList ipList = new IpList(args[0]);
        IdList idList = new IdList(args[1]);
        SplitList splitList = new SplitList(args[2]);

        int id = 32768; // new ID start from 32768

        for (IpSegment splitSegment :
                splitList.list.keySet()) {
            IpSegment floorKey = ipList.list.floorKey(splitSegment);
            if (floorKey.contains(splitSegment)) {
                while (idList.list.containsKey(id) && id < 65535) {
                    id++;
                }
                ipList.split(floorKey, splitSegment, id);
                idList.list.put(id, splitList.list.get(splitSegment));
                id++;
            }
        }

        ipList.saveToFile(args[0] + "new");
        idList.saveToFile(args[1] + "new");
    }
}
