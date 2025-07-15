package velox.api.layer1.common.helper;

import java.util.List;
import java.util.Collection;
import java.util.concurrent.*;
import java.util.function.Consumer;

public class ExecutorsHelper {

    public ExecutorsHelper() {
    }

    public static boolean executeIfNotShutdown(ExecutorService executor, Runnable command) {
        if (!executor.isShutdown()) {
            executor.execute(command);
            return true;
        }
        return false;
    }

    public static <T> List<Future<T>> invokeAllIfNotShutdown(ExecutorService executor, Collection<? extends Callable<T>> tasks) {
        if (!executor.isShutdown()) {
            try {
                return executor.invokeAll(tasks);
            } catch (InterruptedException e) {
                Thread.currentThread().interrupt();
            }
        }
        return List.of(); // empty list if shutdown
    }

    public static <T> Future<T> submitIfNotShutdown(ExecutorService executor, Callable<T> task) {
        if (!executor.isShutdown()) {
            return executor.submit(task);
        }
        return null;
    }

    public static ScheduledFuture<?> scheduleIfNotShutDown(ScheduledExecutorService executor, Runnable command, long delay, TimeUnit unit) {
        if (!executor.isShutdown()) {
            return executor.schedule(command, delay, unit);
        }
        return null;
    }

    public static ThreadPoolExecutor newFixedThreadPoolExecutor(int poolSize, String name) {
        return new ThreadPoolExecutor(poolSize, poolSize,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>(),
                new NamedThreadFactory(name));
    }

    public static ThreadPoolExecutor newSingleThreadExecutor(String name) {
        return new ThreadPoolExecutor(1, 1,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>(),
                new NamedThreadFactory(name));
    }

    public static ThreadPoolExecutor newSingleThreadExecutor(String name, Consumer<Boolean> queueEmptyCallback) {
        return new CallbackThreadPoolExecutor(1, 1,
                0L, TimeUnit.MILLISECONDS,
                new LinkedBlockingQueue<>(),
                new NamedThreadFactory(name),
                queueEmptyCallback);
    }

    public static ThreadPoolExecutor newOnDemandSingleThreadExecutor(String name) {
        return new ThreadPoolExecutor(0, 1,
                60L, TimeUnit.SECONDS,
                new SynchronousQueue<>(),
                new NamedThreadFactory(name));
    }

    public static ThreadPoolExecutor newOnDemandSingleThreadPriorityExecutor(String name) {
        return new PriorityThreadPoolExecutor(0, 1,
                60L, TimeUnit.SECONDS,
                new PriorityBlockingQueue<>(),
                new NamedThreadFactory(name));
    }

    public static ThreadPoolExecutor newThreadPoolExecutor(int corePoolSize, int maximumPoolSize, String name) {
        return new ThreadPoolExecutor(corePoolSize, maximumPoolSize,
                60L, TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(),
                new NamedThreadFactory(name));
    }

    public static ThreadPoolExecutor newThreadPoolExecutor(int corePoolSize, int maximumPoolSize, String name, BlockingQueue<Runnable> queue) {
        return new ThreadPoolExecutor(corePoolSize, maximumPoolSize,
                60L, TimeUnit.SECONDS,
                queue,
                new NamedThreadFactory(name));
    }

    public static ThreadPoolExecutor newThreadPoolExecutor(int corePoolSize, int maximumPoolSize, String name,
                                                           BlockingQueue<Runnable> queue, RejectedExecutionHandler handler) {
        return new ThreadPoolExecutor(corePoolSize, maximumPoolSize,
                60L, TimeUnit.SECONDS,
                queue,
                new NamedThreadFactory(name),
                handler);
    }

    public static ThreadPoolExecutor newThreadPoolExecutor(int corePoolSize, int maximumPoolSize, String name,
                                                           Consumer<Boolean> queueEmptyCallback) {
        return new CallbackThreadPoolExecutor(corePoolSize, maximumPoolSize,
                60L, TimeUnit.SECONDS,
                new LinkedBlockingQueue<>(),
                new NamedThreadFactory(name),
                queueEmptyCallback);
    }

    public static ThreadPoolExecutor newThreadPoolPriorityExecutor(int corePoolSize, int maximumPoolSize, String name) {
        return new PriorityThreadPoolExecutor(corePoolSize, maximumPoolSize,
                60L, TimeUnit.SECONDS,
                new PriorityBlockingQueue<>(),
                new NamedThreadFactory(name));
    }

    public static ScheduledExecutorService newScheduledThreadPool(int corePoolSize, String name) {
        return Executors.newScheduledThreadPool(corePoolSize, new NamedThreadFactory(name));
    }

    public static PriorityThreadPoolExecutor newOnDemandPriorityThreadPoolExecutor(String name) {
        return new PriorityThreadPoolExecutor(0, Integer.MAX_VALUE,
                60L, TimeUnit.SECONDS,
                new PriorityBlockingQueue<>(),
                new NamedThreadFactory(name));
    }

    public static class PrioritizedRunnable implements Runnable, Comparable<PrioritizedRunnable> {
        private final Runnable task;
        private final int priority;

        public PrioritizedRunnable(Runnable task, int priority) {
            this.task = task;
            this.priority = priority;
        }

        @Override
        public void run() {
            task.run();
        }

        @Override
        public int compareTo(PrioritizedRunnable o) {
            return Integer.compare(o.priority, this.priority); // higher priority first
        }
    }
}
