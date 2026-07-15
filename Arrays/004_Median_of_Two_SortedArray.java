 class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {
        int n = nums1.length;
        int m = nums2.length;
        int[] merge = new int[n + m];
        int k = 0;

        for (int i=0; i<n; i++)
        {
            merge[k++] = nums1[i];
        }
        for (int i=0; i<m; i++)
        {
            merge[k++] = nums2[i];
        }

        Arrays.sort(merge);

        int totalLength = merge.length;

        if (totalLength % 2 == 1)
        {
            return (double) merge[totalLength / 2];
        }
        else
        {
            int mid1 = merge[totalLength / 2 - 1];
            int mid2 = merge[totalLength / 2];

            return ((double) mid1 + (double) mid2) / 2.0;
        }
        
    }
}