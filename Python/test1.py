import copy

def check(str):
    ans = []
    topStr= str
    tmpans = []

    def partition(str, curArr):
        if str == None:
            return
        for i in range(1, len(str) + 1):
            curStr = str[:i]
            if curStr == ''.join(reversed(curStr)):
                tmp = copy.deepcopy(curArr)
                tmp.append(curStr)
                if ''.join(tmp) == topStr:
                    ans.append(tmp)
                partition(str=str[i::], curArr=tmp)
    partition(str, [])
    return ans

#diego@nmesh.io

print(check("aab"))
print(check("aabb"))
print(check('a'))
print(check('aabbaa'))