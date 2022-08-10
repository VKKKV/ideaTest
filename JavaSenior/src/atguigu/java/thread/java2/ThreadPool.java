package atguigu.java.thread.java2;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadPoolExecutor;

/**
 * Created on 2022/3/18星期五13:02
 *
 * @author abc
 *
 * 创建线程的方式4
 * 线程池ThreadPool
 *
 *
 */
public class ThreadPool {
    public static void main(String[] args) {
        ExecutorService exe = Executors.newFixedThreadPool(10);
        ThreadPoolExecutor executor= (ThreadPoolExecutor) exe;

        executor.setCorePoolSize(10);
        executor.execute(new abc());
        executor.shutdown();

    }
}


