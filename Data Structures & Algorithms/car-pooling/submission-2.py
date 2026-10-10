
class Solution:
    def carPooling(self, trips: List[List[int]], capacity: int) -> bool:
        passengers = [0] * 1001

        for num, start, end in trips:
            passengers[start] += num
            passengers[end] -= num

        count = 0
        for p in passengers:
            count += p
            if count > capacity:
                return False

        return True
