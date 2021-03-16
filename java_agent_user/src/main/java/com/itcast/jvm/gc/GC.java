package com.itcast.jvm.gc;/**
 * @author
 * @date 2021/3/16 19:42
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
public class GC {
    private UnknowGC.GCPhrase phrase;
    private Long count;
    private Long time;
}
