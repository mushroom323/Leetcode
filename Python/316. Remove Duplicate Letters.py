class Solution(object):
    def removeDuplicateLetters(self, s):
        """
        :type s: str
        :rtype: str
        """
        occurCount = {}
        for i in  range(len(s)):
            if occurCount.get(s[i]) != None:
                occurCount[s[i]] += 1
            else:
                occurCount[s[i]] = 1
        vis = {}
        deque = []
        for i in range(len(s)):
            if vis.get(s[i]) == None or vis[s[i]] == False:
                #print(len(deque) > 0 and occurCount[deque[len(deque) - 1]])
                while len(deque) > 0 and deque[len(deque) - 1] > s[i] and occurCount[deque[len(deque) - 1]] > 0:
                    vis[deque.pop()] = False
                deque.append(s[i])
                vis[s[i]] = True
            occurCount[s[i]] -= 1
        return "".join(deque)
    