package com.tian.config;

import com.sun.management.OperatingSystemMXBean;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.thymeleaf.expression.Maps;

import java.io.File;
import java.lang.management.*;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.text.DecimalFormat;
import java.text.SimpleDateFormat;
import java.util.*;
/**
 * @author tianwc  公众号：java后端技术全栈、面试专栏
 * @version 1.0.0
 * @date 2022年11月03日 20:54
 *
 * 参考  https://cloud.tencent.com/developer/article/1919814
 */
/*@Component
@Slf4j*/
public class SystemInfo {
   /* public void env() throws UnknownHostException {
        Map result = new HashMap();
        Runtime r = Runtime.getRuntime();
        Properties props = System.getProperties();
        InetAddress addr;
        addr = InetAddress.getLocalHost();
        String ip = addr.getHostAddress();
        Map<String, String> map = System.getenv();
        String userName = map.get("USERNAME").toString();// 获取用户名
        String computerName = map.get("COMPUTERNAME");// 获取计算机名
        String userDomain = map.get("USERDOMAIN");// 获取计算机域名

        log.info("用户名", userName);
        log.info("计算机名", computerName);
        log.info("计算机域名", userDomain);
        log.info("本地ip地址", ip);
        log.info("本地主机名", addr.getHostName());
        log.info("JVM可以使用的总内存", r.totalMemory());
        log.info("JVM可以使用的剩余内存", r.freeMemory());
        log.info("JVM可以使用的处理器个数", r.availableProcessors());
        log.info("Java的运行环境版本 ", props.getProperty("java.version"));
        log.info("Java的运行环境供应商 ", props.getProperty("java.vendor"));
        log.info("Java供应商的URL ", props.getProperty("java.vendor.url"));
        log.info("Java的安装路径 ", props.getProperty("java.home"));
        log.info("Java的虚拟机规范版本 ", props.getProperty("java.vm.specification.version"));
        log.info("Java的虚拟机规范供应商 ", props.getProperty("java.vm.specification.vendor"));
        log.info("Java的虚拟机规范名称 ", props.getProperty("java.vm.specification.name"));
        log.info("Java的虚拟机实现版本 ", props.getProperty("java.vm.version"));
        log.info("Java的虚拟机实现供应商 ", props.getProperty("java.vm.vendor"));
        log.info("Java的虚拟机实现名称 ", props.getProperty("java.vm.name"));
        log.info("Java运行时环境规范版本 ", props.getProperty("java.specification.version"));
        log.info("Java运行时环境规范供应商 ", props.getProperty("java.specification.vender"));
        log.info("Java运行时环境规范名称 ", props.getProperty("java.specification.name"));
        log.info("Java的类格式版本号 ", props.getProperty("java.class.version"));
        log.info("Java的类路径 ", props.getProperty("java.class.path"));
        log.info("加载库时搜索的路径列表 ", props.getProperty("java.library.path"));
        log.info("默认的临时文件路径 ", props.getProperty("java.io.tmpdir"));
        log.info("一个或多个扩展目录的路径 ", props.getProperty("java.ext.dirs"));
        log.info("操作系统的名称 ", props.getProperty("os.name"));
        log.info("操作系统的构架 ", props.getProperty("os.arch"));
        log.info("操作系统的版本 ", props.getProperty("os.version"));
        log.info("文件分隔符 ", props.getProperty("file.separator"));
        log.info("路径分隔符 ", props.getProperty("path.separator"));
        log.info("行分隔符 ", props.getProperty("line.separator"));
        log.info("用户的账户名称 ", props.getProperty("user.name"));
        log.info("用户的主目录 ", props.getProperty("user.home"));
        log.info("用户的当前工作目录 ", props.getProperty("user.dir"));
    }

    public void disk() {
        // 磁盘使用情况
        File[] files = File.listRoots();
        for (File file : files) {
            String total = new DecimalFormat("#.#").format(file.getTotalSpace() * 1.0 / 1024 / 1024 / 1024) + "G";
            String free = new DecimalFormat("#.#").format(file.getFreeSpace() * 1.0 / 1024 / 1024 / 1024) + "G";
            String un = new DecimalFormat("#.#").format(file.getUsableSpace() * 1.0 / 1024 / 1024 / 1024) + "G";
            String path = file.getPath();
            log.info("总空间", total);
            log.info("可用空间", un);
            log.info("空闲空间", free);
        }
    }

    public void mem() {
        OperatingSystemMXBean osmxb = (OperatingSystemMXBean) ManagementFactory.getOperatingSystemMXBean();
        // 堆内存使用情况
        MemoryUsage memoryUsage = memoryMXBean.getHeapMemoryUsage();
        // 初始的总内存
        long initTotalMemorySize = memoryUsage.getInit();
        // 最大可用内存
        long maxMemorySize = memoryUsage.getMax();
        // 已使用的内存
        long usedMemorySize = memoryUsage.getUsed();
        log.info("初始的总内存", initTotalMemorySize);
        log.info("最大可用内存", maxMemorySize);
        log.info("已使用的内存", usedMemorySize);
        // 总的物理内存
        String totalMemorySize = new DecimalFormat("#.##").format(osmxb.getTotalPhysicalMemorySize() / 1024.0 / 1024 / 1024) + "G";
        // 剩余的物理内存
        String freePhysicalMemorySize = new DecimalFormat("#.##").format(osmxb.getFreePhysicalMemorySize() / 1024.0 / 1024 / 1024) + "G";
        // 已使用的物理内存
        String usedMemory = new DecimalFormat("#.##").format((osmxb.getTotalPhysicalMemorySize() - osmxb.getFreePhysicalMemorySize()) / 1024.0 / 1024 / 1024) + "G";
        log.info("总的物理内存", totalMemorySize);
        log.info("剩余的物理内存", freePhysicalMemorySize);
        log.info("已使用的物理内存", usedMemory);
        String jvmInitMem = new DecimalFormat("#.#").format(initTotalMemorySize * 1.0 / 1024 / 1024) + "M";
        String jvmMaxMem = new DecimalFormat("#.#").format(maxMemorySize * 1.0 / 1024 / 1024) + "M";
        String jvmUsedMem = new DecimalFormat("#.#").format(usedMemorySize * 1.0 / 1024 / 1024) + "M";
        log.info("JVM初始总内存", jvmInitMem);
        log.info("JVM最大可用内存", jvmMaxMem);
        log.info("JVM已使用的内存", jvmUsedMem);
    }

   *//* public void  cpu() {
        SystemInfo systemInfo = new SystemInfo();
        log.info("程序启动时间", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(ManagementFactory.getRuntimeMXBean().getStartTime())));
        log.info("程序更新时间", new SimpleDateFormat("yyyy-MM-dd HH:mm:ss").format(new Date(ManagementFactory.getRuntimeMXBean().getUptime())));
        result.put("cpu核数", processor.getLogicalProcessorCount());
        result.put("cpu系统使用率", new DecimalFormat("#.##%").format(cSys * 1.0 / totalCpu));
        result.put("cpu用户使用率", new DecimalFormat("#.##%").format(user * 1.0 / totalCpu));
        result.put("cpu当前等待率", new DecimalFormat("#.##%").format(iowait * 1.0 / totalCpu));
        result.put("cpu当前空闲率", new DecimalFormat("#.##%").format(idle * 1.0 / totalCpu));
        return result;
    }*//*

    public void jvm() {
        // 获得线程总数
        ThreadGroup parentThread;
        for (parentThread = Thread.currentThread().getThreadGroup();
             parentThread.getParent() != null;
             parentThread = parentThread.getParent()) {
        }
        int totalThread = parentThread.activeCount();
        log.info("总线程数", totalThread);
        log.info("PID", System.getProperty("PID"));
        log.info("LibraryPath", ManagementFactory.getRuntimeMXBean().getLibraryPath());
        log.info("BootClassPath", ManagementFactory.getRuntimeMXBean().getBootClassPath());
        log.info("ClassPath", ManagementFactory.getRuntimeMXBean().getClassPath());
        log.info("ObjectPendingFinalizationCount", ManagementFactory.getMemoryMXBean().getObjectPendingFinalizationCount());
        log.info("HeapMemoryUsage", ManagementFactory.getMemoryMXBean().getHeapMemoryUsage());
        log.info("NonHeapMemoryUsage", ManagementFactory.getMemoryMXBean().getNonHeapMemoryUsage());
        log.info("ObjectName", ManagementFactory.getMemoryMXBean().getObjectName());
        log.info("LoadedClassCount", ManagementFactory.getClassLoadingMXBean().getLoadedClassCount());
        log.info("TotalLoadedClassCount", ManagementFactory.getClassLoadingMXBean().getTotalLoadedClassCount());
        log.info("TotalCompilationTime", ManagementFactory.getCompilationMXBean().getTotalCompilationTime());
        log.info("Compilation", ManagementFactory.getCompilationMXBean().getName());
        log.info("OperatingSystemMXBean", ManagementFactory.getOperatingSystemMXBean().getName());
        log.info("OperatingSystemMXArch", ManagementFactory.getOperatingSystemMXBean().getArch());
        log.info("AvailableProcessors", ManagementFactory.getOperatingSystemMXBean().getAvailableProcessors());
        log.info("SystemLoadAverage", ManagementFactory.getOperatingSystemMXBean().getSystemLoadAverage());
        //内存池对象

        // gc
        List<GarbageCollectorMXBean> gcs = ManagementFactory.getGarbageCollectorMXBeans();
        // ParallelOld("ParallelOld"),
        //    SerialOld("SerialOld"),
        //    PSMarkSweep("PSMarkSweep"),
        //    ParallelScavenge("ParallelScavenge"),
        //    DefNew("DefNew"),
        //    ParNew("ParNew"),
        //    G1New("G1New"),
        //    ConcurrentMarkSweep("ConcurrentMarkSweep"),
        //    G1Old("G1Old"),
        //    GCNameEndSentinel("GCNameEndSentinel");
        for (GarbageCollectorMXBean gc : gcs) {
            log.info("GarbageCollector", gc.getName());
        }

    }*/
}

