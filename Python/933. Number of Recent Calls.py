class RecentCounter(object):

    def __init__(self):
        self.arr = []
        self.base = 0

    def ping(self, t):
        """
        :type t: int
        :rtype: int
        """
        self.arr.append(t)
        if t - self.arr[self.base] <= 3000:
            return len(self.arr) - self.base
        else:
            while self.base < len(self.arr) and t - self.arr[self.base] > 3000:
                self.base += 1
            return len(self.arr) - self.base



# Your RecentCounter object will be instantiated and called as such:
# obj = RecentCounter()
# param_1 = obj.ping(t)