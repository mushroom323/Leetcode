class Solution(object):
    def compareVersion(self, version1, version2):
        """
        :type version1: str
        :type version2: str
        :rtype: int
        """
        arr1 = version1.split(".")
        arr2 = version2.split(".")
        i = 0
        while i < min(len(arr1), len(arr2)):
            if int(arr1[i]) > int(arr2[i]):
                return 1
            elif int(arr1[i]) < int(arr2[i]):
                return -1
            i += 1
        if len(arr1) == len(arr2):
            return 0
        elif i == len(arr1):
            while i < len(arr2):
                if int(arr2[i]) > 0:
                    return -1
                i += 1
        elif i == len(arr2):
            while i < len(arr1):
                if int(arr1[i]) > 0:
                    return 1
                i += 1
        return 0