class Solution(object):
    def findRepeatedDnaSequences(self, s):
        """
        :type s: str
        :rtype: List[str]
        """
        if len(s) <= 10:
            return []
        mymap = {}
        ans = []
        for i in range(len(s) - 10 + 1):
            subString = s[i: i + 10]
            if mymap.get(subString) == None:
                mymap[subString] = 1
            elif mymap[subString] == 1:
                ans.append(subString)
                mymap[subString] += 1
        return ans