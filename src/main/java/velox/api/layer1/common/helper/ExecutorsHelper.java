package velox.api.layer1.common.helper;

/**
 * Helper class for executor services and prioritized task execution.
 */
public class ExecutorsHelper {
    
    /**
     * Runnable with an integer priority. Lower number means faster execution.
     * This class implements both Runnable and Comparable interfaces to allow
     * prioritized execution in executor services.
     */
    public static class PrioritizedRunnable implements Runnable, Comparable<PrioritizedRunnable> {
        
        private final Runnable runnable;
        private final int priority;
        
        /**
         * Creates a new PrioritizedRunnable with the specified runnable and priority.
         * 
         * @param runnable the runnable task to execute
         * @param priority the priority of this task (lower number = higher priority)
         */
        public PrioritizedRunnable(Runnable runnable, int priority) {
            this.runnable = runnable;
            this.priority = priority;
        }
        
        /**
         * Executes the wrapped runnable task.
         */
        @Override
        public void run() {
            if (runnable != null) {
                runnable.run();
            }
        }
        
        /**
         * Compares this PrioritizedRunnable with another based on priority.
         * Lower priority numbers are considered "less than" higher priority numbers,
         * meaning they will be executed first in a priority queue.
         * 
         * @param o the other PrioritizedRunnable to compare to
         * @return negative integer if this has higher priority (lower number),
         *         positive integer if this has lower priority (higher number),
         *         zero if priorities are equal
         */
        @Override
        public int compareTo(PrioritizedRunnable o) {
            return Integer.compare(this.priority, o.priority);
        }
        
        /**
         * Gets the priority of this runnable.
         * 
         * @return the priority value
         */
        public int getPriority() {
            return priority;
        }
        
        /**
         * Gets the wrapped runnable.
         * 
         * @return the runnable task
         */
        public Runnable getRunnable() {
            return runnable;
        }
        
        @Override
        public boolean equals(Object obj) {
            if (this == obj) return true;
            if (obj == null || getClass() != obj.getClass()) return false;
            
            PrioritizedRunnable that = (PrioritizedRunnable) obj;
            return priority == that.priority && 
                   (runnable != null ? runnable.equals(that.runnable) : that.runnable == null);
        }
        
        @Override
        public int hashCode() {
            int result = runnable != null ? runnable.hashCode() : 0;
            result = 31 * result + priority;
            return result;
        }
        
        @Override
        public String toString() {
            return "PrioritizedRunnable{" +
                   "priority=" + priority +
                   ", runnable=" + runnable +
                   '}';
        }
    }
}