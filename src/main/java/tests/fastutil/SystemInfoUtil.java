package tests.fastutil;

/**
 * Created by zhudebin on 16/6/3.
 */
public class SystemInfoUtil {

    public static void printlnJVMInfo() {
        Runtime run = Runtime.getRuntime();

        long max = run.maxMemory();

        long total = run.totalMemory();

        long free = run.freeMemory();

        long usable = max - total + free;

        System.out.println("最大内存 = " + max);
        System.out.println("已分配内存 = " + total);
        System.out.println("已分配内存中的剩余空间 = " + free);
        System.out.println("最大可用内存 = " + usable);
        System.out.println("== 已经使用的内存 = " + (total - free));

    }

    public static long getUsedMemory() {
        Runtime run = Runtime.getRuntime();

        long total = run.totalMemory();

        long free = run.freeMemory();

        return total - free;
    }

}
