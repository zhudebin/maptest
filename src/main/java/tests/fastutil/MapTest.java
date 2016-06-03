package tests.fastutil;

import it.unimi.dsi.fastutil.ints.Int2ObjectOpenHashMap;
import it.unimi.dsi.fastutil.ints.Int2ObjectRBTreeMap;
import it.unimi.dsi.fastutil.objects.ObjectArrayList;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by zhudebin on 16/6/3.
 */
public class MapTest {


    // 对比一下内存占用情况
    // 1. jdk
    // 2. fastutil

    public void test1() throws Exception {
        System.gc();
        Thread.sleep(1000);
        long usedMemory1 = SystemInfoUtil.getUsedMemory();
        List<Map<Integer, DataCell>> list = new ArrayList<>();
//        List<Map<Integer, DataCell>> list = new ObjectArrayList<>();
        for(int i=0; i<1000; i++) {
//            Map<Integer, DataCell> map = new Int2ObjectRBTreeMap<>();
            Map<Integer, DataCell> map = new Int2ObjectOpenHashMap<>();
            map.put(1, new DataCell(1, "heh"));
            list.add(map);
        }
        long usedMemory2 = SystemInfoUtil.getUsedMemory();
        System.out.println("------------fastutil 占用内存 ---------\t " + (usedMemory2 - usedMemory1));
        System.gc();
        // 203264
        // 4168984
    }

    public void test2() throws Exception {
        System.gc();
        Thread.sleep(1000);
        long usedMemory1 = SystemInfoUtil.getUsedMemory();
        List<Map<Integer, DataCell>> list = new ArrayList<>();
        for(int i=0; i<1000; i++) {
            Map<Integer, DataCell> map = new HashMap<>();
            map.put(1, new DataCell(1, "heh"));
            list.add(map);
        }
        long usedMemory2 = SystemInfoUtil.getUsedMemory();
        System.out.println("------------hashmap 占用内存 ---------\t " + (usedMemory2 - usedMemory1));
        System.gc();
        // 242840
        // 1672920
    }

    public static void main(String[] args) throws Exception {
        new MapTest().test1();
        new MapTest().test2();
    }
}
