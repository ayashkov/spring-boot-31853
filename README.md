# Spring Boot issue 31853

An attempt to reproduce Spring Boot issue
[31853](https://github.com/spring-projects/spring-boot/issues/31853).

```sh
$ mvn clean install
$ docker build -f Dockerfile -t sbe:latest app/target
$ docker run -it --rm sbe:latest
app@d7d8c9382436:~$ java -jar /app/lib/starter-angular-app-1.0.0-SNAPSHOT-exec.jar &
[1] 42
  .   ____          _            __ _ _
 /\\ / ___'_ __ _ _(_)_ __  __ _ \ \ \ \
( ( )\___ | '_ | '_| | '_ \/ _` | \ \ \ \
 \\/  ___)| |_)| | | | | || (_| |  ) ) ) )
  '  |____| .__|_| |_|_| |_\__, | / / / /
 =========|_|==============|___/=/_/_/_/
 :: Spring Boot ::                (v2.7.2)

2022-07-27 17:47:26.130  INFO 42 --- [           main] org.yashkov.starter.angular.web.WebApp   : Starting WebApp using Java 11.0.15 on d7d8c9382436 with PID 42 (/app/lib/starter-angular-app-1.0.0-SNAPSHOT-exec.jar started by app in /home/app)
2022-07-27 17:47:26.134  INFO 42 --- [           main] org.yashkov.starter.angular.web.WebApp   : No active profile set, falling back to 1 default profile: "default"
2022-07-27 17:47:27.474  INFO 42 --- [           main] o.s.b.web.embedded.netty.NettyWebServer  : Netty started on port 8080
2022-07-27 17:47:27.483  INFO 42 --- [           main] org.yashkov.starter.angular.web.WebApp   : Started WebApp in 1.714 seconds (JVM running for 2.065)

app@d7d8c9382436:~$ curl -v http://localhost:8080/app/status
*   Trying 127.0.0.1:8080...
* Connected to localhost (127.0.0.1) port 8080 (#0)
> GET /app/status HTTP/1.1
> Host: localhost:8080
> User-Agent: curl/7.74.0
> Accept: */*
>
Exception in thread "reactor-http-epoll-2" java.lang.NoClassDefFoundError: io/netty/buffer/PoolArena$1
        at io.netty.buffer.PoolArena.freeChunk(PoolArena.java:248)
        at io.netty.buffer.PoolThreadCache$MemoryRegionCache.freeEntry(PoolThreadCache.java:432)
        at io.netty.buffer.PoolThreadCache$MemoryRegionCache.free(PoolThreadCache.java:396)
        at io.netty.buffer.PoolThreadCache$MemoryRegionCache.free(PoolThreadCache.java:388)
        at io.netty.buffer.PoolThreadCache.free(PoolThreadCache.java:254)
        at io.netty.buffer.PoolThreadCache.free(PoolThreadCache.java:245)
        at io.netty.buffer.PoolThreadCache.free(PoolThreadCache.java:218)
        at io.netty.buffer.PooledByteBufAllocator$PoolThreadLocalCache.onRemoval(PooledByteBufAllocator.java:542)
        at io.netty.buffer.PooledByteBufAllocator$PoolThreadLocalCache.onRemoval(PooledByteBufAllocator.java:503)
        at io.netty.util.concurrent.FastThreadLocal.remove(FastThreadLocal.java:257)
        at io.netty.util.concurrent.FastThreadLocal.removeAll(FastThreadLocal.java:67)
        at io.netty.util.concurrent.SingleThreadEventExecutor$4.run(SingleThreadEventExecutor.java:1050)
        at io.netty.util.internal.ThreadExecutorMap$2.run(ThreadExecutorMap.java:74)
        at io.netty.util.concurrent.FastThreadLocalRunnable.run(FastThreadLocalRunnable.java:30)
        at java.base/java.lang.Thread.run(Thread.java:829)
Caused by: java.lang.ClassNotFoundException: io.netty.buffer.PoolArena$1
        at java.base/java.net.URLClassLoader.findClass(URLClassLoader.java:476)
        at java.base/java.lang.ClassLoader.loadClass(ClassLoader.java:589)
        at org.springframework.boot.loader.LaunchedURLClassLoader.loadClass(LaunchedURLClassLoader.java:151)
        at java.base/java.lang.ClassLoader.loadClass(ClassLoader.java:522)
        ... 15 more
^C
app@d7d8c9382436:~$ kill %1
app@d7d8c9382436:~$ Exception in thread "SpringApplicationShutdownHook" java.lang.NoClassDefFoundError: ch/qos/logback/classic/spi/ThrowableProxy
        at ch.qos.logback.classic.spi.LoggingEvent.<init>(LoggingEvent.java:119)
        at ch.qos.logback.classic.Logger.buildLoggingEventAndAppend(Logger.java:419)
        at ch.qos.logback.classic.Logger.filterAndLog_0_Or3Plus(Logger.java:383)
        at ch.qos.logback.classic.Logger.log(Logger.java:765)
        at org.apache.commons.logging.LogAdapter$Slf4jLocationAwareLog.warn(LogAdapter.java:447)
        at org.springframework.context.support.AbstractApplicationContext.doClose(AbstractApplicationContext.java:1070)
        at org.springframework.boot.web.reactive.context.ReactiveWebServerApplicationContext.doClose(ReactiveWebServerApplicationContext.java:149)
        at org.springframework.context.support.AbstractApplicationContext.close(AbstractApplicationContext.java:1021)
        at org.springframework.boot.SpringApplicationShutdownHook.closeAndWait(SpringApplicationShutdownHook.java:145)
        at java.base/java.lang.Iterable.forEach(Iterable.java:75)
        at org.springframework.boot.SpringApplicationShutdownHook.run(SpringApplicationShutdownHook.java:114)
        at java.base/java.lang.Thread.run(Thread.java:829)

[1]+  Exit 143                java -jar /app/lib/starter-angular-app-1.0.0-SNAPSHOT-exec.jar
app@d7d8c9382436:~$ exit
exit
```
