package JavaDSA.BasicRecursion;

public class JD5checkStringPalindrome {

    static boolean checkPalindrome(int i, int n, String str){
        if(i >= n/2){
            return true;
        }
        if(str.charAt(i) != str.charAt(n-1-i)){
            return false;
        }
        i++;
        return checkPalindrome(i,n, str);
    }
    public static void main(String[] args) {
        String str = "123 Eye #$, 321";
        str = str.replaceAll("[^a-zA-Z0-9]", "");
        str =  str.toLowerCase();
        System.out.println(str);
        System.out.println(checkPalindrome(0,str.length(), str));
    }
}
