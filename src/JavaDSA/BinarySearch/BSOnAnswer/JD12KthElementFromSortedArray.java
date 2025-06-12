package JavaDSA.BinarySearch.BSOnAnswer;

public class JD12KthElementFromSortedArray {
    public static int findK(int[] a, int[] b, int k ){
        int n1 = a.length, n2 = b.length;
        if(n1 > n2) return findK(b,a,k);
        int low = Math.max(0, k-n2), high = Math.min(k,n1);
        int left = k;
        int n = n1+ n2;
        while(low <= high){
            int mid1 = (low + high)/2;
            int mid2 = left -mid1;
            int l1 = Integer.MIN_VALUE, l2 = Integer.MIN_VALUE;
            int r1 = Integer.MAX_VALUE, r2 = Integer.MAX_VALUE;
            if(mid1 < n1) r1 = a[mid1];
            if(mid2 < n2) r2 = b[mid2];
            if(mid1 - 1 >= 0) l1 = a[mid1-1];
            if(mid2 - 1 >= 0) l2 = b[mid2-1];
            if(l1 <= r2 && l2 <= r1){
                return Math.max(l1,l2);
            }
            else if(l1 > r2) high = mid1 - 1;
            else low = mid1 + 1;
        }
        return -1;
    }
    public static void main(String[] args) {
        int[] a = {1, 4, 7, 10, 12};
        int[] b = {2, 3, 6, 15};
        System.out.println("The Kth element of two sorted arrays is " + findK(a, b,7));
    }
}
