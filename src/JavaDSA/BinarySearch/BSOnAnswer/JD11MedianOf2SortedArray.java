package JavaDSA.BinarySearch.BSOnAnswer;

public class JD11MedianOf2SortedArray {
    public static double findMedianOptimal(int[]a, int[]b){
        int n1 = a.length, n2 = b.length;
        if(n1 > n2) return findMedianOptimal(b, a);
        int low = 0, high = n1;
        int left = (n1+n2+1)/2;
        int n = n1+ n2;
        while(low <= high){
            int mid1 = (low+high)/2;
            int mid2 = left-mid1;
            int l1 = Integer.MIN_VALUE, l2 = Integer.MIN_VALUE;
            int r1 = Integer.MAX_VALUE, r2 = Integer.MAX_VALUE;
            if(mid1 < n1) r1 = a[mid1];
            if(mid2 < n2) r2 = b[mid2];
            if(mid1-1 >= 0) l1 = a[mid1-1];
            if(mid2-1 >= 0) l2 = b[mid2-1];
            if(l1 <= r2 && l2 <= r1){
                if(n%2 == 1) return Math.max(l1,l2);
                else{
                    return ((double)(Math.max(l1,l2)+Math.min(r1,r2)))/2.0;
                }
            }
            else if(l1 > r2) high = mid1 -1;
            else low = mid1 + 1;
        }
        return 0;
    }
    public static int findMedianBetter(int[] a, int[] b){
        int aLen = a.length, bLen = b.length;
        int n = aLen + bLen;
        int i = 0, j = 0;
        int ind2 = n/2;
        int ind1 = ind2 - 1;
        int ind1el = -1, ind2el = -1, cnt = 0;
        while(i<aLen && j < bLen){
            if(a[i] < b[j]){
                if(cnt == ind1) ind1el = a[i];
                if(cnt == ind2) ind2el = a[i];
                cnt++;
                i++;
            }
            else{
                if(cnt == ind1) ind1el = b[j];
                if(cnt == ind2) ind2el = b[j];
                cnt++;
                j++;
            }
        }
        while(i<aLen){
            if(cnt == ind1) ind1el = a[i];
            if(cnt == ind2) ind2el = a[i];
            cnt++;
            i++;
        }
        while(j<bLen){
            if(cnt == ind1) ind1el = b[j];
            if(cnt == ind2) ind2el = b[j];
            cnt++;
            j++;
        }
        if(n%2 != 0) return ind2el;
        return (ind1el+ind2el)/2;
    }
    public static void main(String[] args) {
        int[] a = {1, 4, 7, 10, 12};
        int[] b = {2, 3, 6, 15};
        System.out.println("The median of two sorted arrays is " + findMedianOptimal(a, b));
    }
}
