import com.sun.deploy.util.StringUtils;

import java.util.Arrays;

public class Practice {
    public void reverseString(char []str,int from ,int to){
        while(from<to){
            char t = str[from];
            str[from++] = str[to];
            str[to--] = t;
        }
    }
    public void reverse(char[]s,int n , int m){

         reverseString(s,0,n-1);
         reverseString(s,0,m-1);
        reverseString(s,m,n-1);

    }
    public static void main(String[] args) {
        String s = "abcdef";
        Practice p = new Practice();
        char[] res = s.toCharArray();
        p.reverse(res,s.length(),3);
        StringBuilder b= new StringBuilder();
        for(int i = 0; i < res.length ; i++){
            b.append(res[i]);
        }
        System.out.println(b);
    }
}
