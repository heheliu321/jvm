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

package com.itcast.jvm.gc;

import java.util.ArrayList;
import java.util.List;

public class UnknowGC implements GCMetricAccessor {
    @Override
    public List<GC> getGCList() {
        List<GC> gcList = new ArrayList<>();
        gcList.add(GC.builder().phrase(GCPhrase.NEW).build());
        gcList.add(GC.builder().phrase(GCPhrase.OLD).build());
        return gcList;
    }

    enum GCPhrase {
        NEW(0),
        OLD(1);

        private Integer value;

        public Integer getValue() {
            return value;
        }

        GCPhrase(int i) {
            this.value = i;
        }
    }
}
