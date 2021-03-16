package com.itcast.jvm.thread;/**
 * @author
 * @date 2021/3/16 19:29
 */

import lombok.Builder;
import lombok.Data;

/**
 * @param
 * @return
 * @throws
 */
@Builder
@Data
public class Thread {

    private int liveCount;

    private int daemonThreadCount;

    private int peakThreadCount;
}
