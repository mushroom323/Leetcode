package Java;

// 手写大根堆

class Solution {
    public int findKthLargest(int[] nums, int k) {
        int heapSize = nums.length;
        Heapify(nums, heapSize);
        for (int i = 1; i < k; i++) {
            int index = nums.length - i;
            System.out.println(nums[0]);
            swap(nums, 0, index);
            heapSize--;
            maxHeapify(nums, 0, heapSize);
        }
        return nums[0];
    } 

    public void Heapify(int[] nums, int heapSize) {
        int max = heapSize / 2;
        for (int i = max; i >= 0; i--) {
            maxHeapify(nums, i, heapSize);
        }
    }

    public void maxHeapify(int[] nums, int base, int heapSize) {
        int largest = base, left = 2 * base + 1, right = 2 * base + 2;
        if (left < heapSize && nums[left] > nums[largest]) largest = left;
        if (right < heapSize && nums[right] > nums[largest]) largest = right;
        if (largest != base) {
            swap(nums, base, largest);
            maxHeapify(nums, largest, heapSize);
        }
    }

    public void swap(int[] nums, int i, int j) {
        int tmp = nums[i];
        nums[i] = nums[j];
        nums[j] = tmp;
    }
}