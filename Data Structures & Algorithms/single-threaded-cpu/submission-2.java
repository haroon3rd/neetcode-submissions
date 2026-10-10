
class Solution {
    public int[] getOrder(int[][] tasks) {
        PriorityQueue<Task> minStart = new PriorityQueue<>(
            (a, b) -> Integer.compare(a.enq, b.enq)
        );

        PriorityQueue<Task> shortestProc = new PriorityQueue<>(
            (a, b) -> a.proc != b.proc
                ? Integer.compare(a.proc, b.proc)
                : Integer.compare(a.index, b.index)
        );

        for (int i = 0; i < tasks.length; i++) {
            minStart.offer(new Task(i, tasks[i][0], tasks[i][1]));
        }

        int[] result = new int[tasks.length];
        int i = 0;
        long clock = 0;

        while (i < tasks.length) {
            // Jump forward if no task is available
            if (shortestProc.isEmpty()) {
                clock = Math.max(clock, minStart.peek().enq);
            }

            // Add all tasks that have arrived
            while (!minStart.isEmpty() && minStart.peek().enq <= clock) {
                shortestProc.offer(minStart.poll());
            }

            // Execute the task with the shortest processing time
            Task t = shortestProc.poll();
            result[i++] = t.index;
            clock += t.proc;
        }

        return result;
    }
}

class Task {
    int index, enq, proc;

    Task(int index, int enq, int proc) {
        this.index = index;
        this.enq = enq;
        this.proc = proc;
    }
}
