/*
 * Licensed to the Apache Software Foundation (ASF) under one or more
 * contributor license agreements.  See the NOTICE file distributed with
 * this work for additional information regarding copyright ownership.
 * The ASF licenses this file to You under the Apache License, Version 2.0
 * (the "License"); you may not use this file except in compliance with
 * the License.  You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 *
 */

package com.itcast.jvm.memory;

import java.lang.management.ManagementFactory;
import java.lang.management.MemoryMXBean;
import java.lang.management.MemoryUsage;
import java.util.ArrayList;
import java.util.List;

public enum MemoryProvider {
    INSTANCE;

    private final MemoryMXBean memoryMXBean;

    MemoryProvider() {
        this.memoryMXBean = ManagementFactory.getMemoryMXBean();
    }

    public List<Memory> getMemoryMetricList() {
        List<Memory> memoryList = new ArrayList<>();

        MemoryUsage heapMemoryUsage = memoryMXBean.getHeapMemoryUsage();
        Memory.MemoryBuilder heapMemoryBuilder = Memory.builder();
        heapMemoryBuilder.Heap(true)
            .init(heapMemoryUsage.getInit())
            .used(heapMemoryUsage.getUsed())
            .committed(heapMemoryUsage.getCommitted())
            .max(heapMemoryUsage.getMax());
        memoryList.add(heapMemoryBuilder.build());

        MemoryUsage nonHeapMemoryUsage = memoryMXBean.getNonHeapMemoryUsage();
        Memory.MemoryBuilder nonHeapMemoryBuilder = Memory.builder();
        nonHeapMemoryBuilder.Heap(false)
            .init(nonHeapMemoryUsage.getInit())
            .used(nonHeapMemoryUsage.getUsed())
            .committed(nonHeapMemoryUsage.getCommitted())
            .max(nonHeapMemoryUsage.getMax()).build();
        memoryList.add(nonHeapMemoryBuilder.build());

        return memoryList;
    }

}
