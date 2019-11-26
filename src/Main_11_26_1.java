import java.util.Arrays;

public class Main_11_26_1 {
    public boolean[] chkSubStr(String[] p, int n, String s) {
           // write code here
        boolean [] res = new    boolean[p.length];
        for(int i =0  ; i < n ; i++){
            if(s.contains(p[i])){
                res[i]=true;
            }else{
                res[i] = false;
            }
        }
        return  res;
    }

    public static void main(String[] args) {
        String []p = {"a","b","c","d"};
        Main_11_26_1 m = new Main_11_26_1();
        System.out.println(Arrays.toString(m.chkSubStr(p, p.length, "abcd")));
    }
}
