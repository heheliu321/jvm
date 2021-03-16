package com.itcast.jvm;

import com.itcast.jvm.cpu.CPU;
import com.itcast.jvm.cpu.CPUProvider;
import com.itcast.jvm.gc.GC;
import com.itcast.jvm.gc.GCProvider;
import com.itcast.jvm.memory.Memory;
import com.itcast.jvm.memory.MemoryProvider;
import com.itcast.jvm.thread.Thread;
import com.itcast.jvm.thread.ThreadProvider;
import com.itcast.redis_monitor.SpringUtil;

import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

import java.util.List;

import lombok.Setter;
import lombok.extern.slf4j.Slf4j;

//import org.springframework.data.redis.connection.lettuce.LettucePoolingConnectionProvider;

/**
 * Created by s00366043 on 2018/3/19. 不允许多线程调用此类的获取cpu的接口showProcessCpu
 */

@Slf4j
@Component
@Setter
public class JVMMonitorUtil {

    @Scheduled(fixedDelayString = "${jvm.monitor.timeWait:3000}")
    private void scheduledMonitor() {
        try {
            SpringUtil.getApplicationContext();
            recordRedisInfo();
        } catch (Throwable t) {
            log.error("JvmInfoMonitor failed", t);
        }
    }

    private void recordRedisInfo() {
        List<Memory> memoryMetricList = MemoryProvider.INSTANCE.getMemoryMetricList();
        System.out.println(memoryMetricList.toString());

        Thread threadMetrics = ThreadProvider.INSTANCE.getThreadMetrics();
        System.out.println(threadMetrics);

        List<GC> gcList = GCProvider.INSTANCE.getGCList();
        System.out.println(gcList);

        CPU cpuMetric = CPUProvider.INSTANCE.getCpuMetric();
        System.out.println(cpuMetric);
    }

}
