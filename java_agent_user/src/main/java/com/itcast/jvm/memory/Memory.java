package com.itcast.jvm.memory;

/**
 * @author
 * @date 2021/3/16 19:13
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
public class Memory {

    private Boolean Heap;

    private Long init;

    private Long used;

    private Long committed;

    private Long max;
}
