-javaagent:D:\xxx\java_agent\target\java-agent-demo-1.0-SNAPSHOT.jar -Xms256m -Xmx256m -Xss256k -XX:MaxDirectMemorySize=256m -XX:+PrintGCDetails -verbose:gc -XX:+PrintGCTimeStamps -XX:+PrintGCDateStamps -Xloggc:gc.log


log日志

[Memory(Heap=true, init=268435456, used=76011272, committed=255852544, max=255852544), Memory(Heap=false, init=2555904, used=63169456, committed=67698688, max=-1)]
Thread(liveCount=22, daemonThreadCount=17, peakThreadCount=22)
[GC(phrase=NEW, count=0, time=0), GC(phrase=OLD, count=0, time=0)]
CPU(usagePercent=0.0)


MyInterceptor start...
class java.lang.Object---hashCode:0ms
MyInterceptor end...
MyInterceptor start...
class org.springframework.kafka.core.DefaultKafkaProducerFactory---destroy:0ms
MyInterceptor end...
