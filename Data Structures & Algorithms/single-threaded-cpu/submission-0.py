class Solution:
    def getOrder(self, tasks: List[List[int]]) -> List[int]:
        tasks = sorted((start, duration, i)
                       for i, (start, duration) in enumerate(tasks))

        result = []
        heap = []
        time = 0
        i = 0
        n = len(tasks)

        while len(result) < n:
            while i < n and tasks[i][0] <= time:
                start, duration, index = tasks[i]
                heapq.heappush(heap, (duration, index, start))
                i += 1

            if not heap:
                time = tasks[i][0]
            else:
                duration, index, _ = heapq.heappop(heap)
                result.append(index)
                time += duration

        return result

        