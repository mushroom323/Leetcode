package Java;

class Solution {
    public int compareVersion(String version1, String version2) {
        String[] arr1 = version1.split("\\.");
        String[] arr2 = version2.split("\\.");
        int i = 0;
        for (; i < Math.min(arr1.length, arr2.length); i++) {
            if (Integer.parseInt(arr1[i]) > Integer.parseInt(arr2[i])) {
                return 1;
            } else if (Integer.parseInt(arr1[i]) < Integer.parseInt(arr2[i])) {
                return -1;
            }
        }
        if (arr1.length == arr2.length) return 0;
        else if (i == arr1.length) {
            for (; i < arr2.length; i++) {
                if (Integer.parseInt(arr2[i]) > 0) return -1;
            }
        } else {
            for (; i < arr1.length; i++) {
                if (Integer.parseInt(arr1[i]) > 0) return 1;
            }
        }
        return 0;
    }
}