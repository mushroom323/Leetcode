class Solution(object):
    def longestCommonSubsequence(self, text1, text2):
        """
        :type text1: str
        :type text2: str
        :rtype: int
        """
        arr = [[0] * (len(text2) + 1) for _ in range(len(text1) + 1)]
        for i in range(1, len(text1) + 1):
            for j in range(1, len(text2) + 1):
                if text1[i - 1] == text2[j - 1]:
                    arr[i][j] = arr[i - 1][j - 1] + 1
                else:
                    if arr[i - 1][j] < arr[i][j - 1]:
                        arr[i][j] = arr[i][j - 1]
                    else:
                        arr[i][j] = arr[i - 1][j]
                # print(i,j,arr[i][j])
        return arr[len(text1)][len(text2)]