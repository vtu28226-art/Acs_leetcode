import java.util.LinkedList;
import java.util.Queue;

class RecentCounter {
    private Queue<Integer> queue;

    public RecentCounter() {
        queue = new LinkedList<>();
    }
    
    public int ping(int t) {
        // Add the new request
        queue.add(t);
        
        // Remove requests older than t - 3000
        while (queue.peek() < t - 3000) {
            queue.poll();
        }
        
        // The size of the queue is the number of valid requests
        return queue.size();
    }
}
