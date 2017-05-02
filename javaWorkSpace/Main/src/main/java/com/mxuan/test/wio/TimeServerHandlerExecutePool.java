package com.mxuan.test.wio;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/**
 * Created by wangwenxuan on 2017/4/11.
 */
public class TimeServerHandlerExecutePool{
    private ExecutorService executor;

    public TimeServerHandlerExecutePool(int maxPoolSize, int queueSize){
        executor = new ThreadPoolExecutor(
                        Runtime.getRuntime().availableProcessors(),
                        maxPoolSize,
                       120L,
                        TimeUnit.SECONDS,
                        new ArrayBlockingQueue<>(queueSize)
                    );
    }

    public void execute(Runnable task){
        executor.execute(task);
    }
}
