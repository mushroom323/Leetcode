def merge(arrs):
    arrs = sorted(arrs, key=lambda x: x[0])
    arr = []
    arr.append(arrs[0])
    
    for i in range(1, len(arrs)):
        if arrs[i][0] > arr[len(arr) - 1][1]:
            arr.append(arrs[i])
        elif arrs[i][1] > arr[len(arr) - 1][1]:
            arr[len(arr) - 1][1] = arrs[i][1]
    return arr


def isin(arr, input):
    for i in range(len(arr)):
        if input[0] >= arr[i][0] and input[1] < arr[i][1]:
            return True
    return False

def check(arrs, input):
    arr = merge(arrs)
    return isin(arr, input)

# test
arrs = [[3,4],[1,2],[4,8]]
input = [3,7]
print(check(arrs, input))
print(check(arrs,[2,3]))