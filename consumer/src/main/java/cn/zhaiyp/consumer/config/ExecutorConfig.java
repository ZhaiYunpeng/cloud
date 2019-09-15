package cn.zhaiyp.consumer.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.scheduling.annotation.EnableAsync;
import org.springframework.scheduling.concurrent.ThreadPoolTaskExecutor;

import java.util.concurrent.Executor;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * @author : Administrator
 * @date : 2019/9/15
 * 线程池配置bean,可以让程序，多线程异步处理
 */
@Configurable
@EnableAsync
public class ExecutorConfig {
    private static Logger logger = LoggerFactory.getLogger(ExecutorConfig.class);

    @Autowired
    private PropertiesConfig propertiesConfig;

    @Bean(name = "threadPoolA")
    public Executor asyncExecutorService(){
        logger.info("start asyncServiceExecutor");
        ThreadPoolTaskExecutor executor = new ThreadPoolTaskExecutor();
        //配置核心线程数
        executor.setCorePoolSize(propertiesConfig.getCorePoolSize());
        //配置最大线程数
        executor.setMaxPoolSize(propertiesConfig.getMaxPoolSize());
        //配置队列大小
        executor.setQueueCapacity(propertiesConfig.getQueueCapacity());
        //线程空闲存活时间
        executor.setKeepAliveSeconds(60);
        //配置线程池中的线程的名称前缀
        executor.setThreadNamePrefix("PoolA-");

        // rejection-policy：当pool已经达到max size的时候，如何处理新任务
        // CALLER_RUNS：不在新线程中执行任务，而是有调用者所在的线程来执行
        executor.setRejectedExecutionHandler(new ThreadPoolExecutor.CallerRunsPolicy());
        //执行初始化
        executor.initialize();
        return executor;
    }
}
