import java.util.ArrayList;
import java.util.List;

public class LeeCode {
    /**
     *  Z字型变换 -- 将给定的字符串变换成Z 的逆时针90度方向后返回按行访问的字符串
     *  通过从左到右迭代字符串，可以确定字符串位于Z图案的哪一行
     * @param s 字符串
     * @param numRows 行数
     * @return 按行输出变换后的字符串
     */
    public String convert(String s, int numRows) {
        List<StringBuilder> list = new ArrayList<>();
        for(int i = 0 ; i < Math.min(s.length(),numRows);i++){
            list.add(new StringBuilder());
        }
        boolean goingDown = false;
        int curRows = 0;
        for(char c : s.toCharArray()){
            list.get(curRows).append(c);
            if(curRows == 0 || curRows == numRows-1){
                goingDown = !goingDown;
            }
                curRows += goingDown?1:-1;
        }
        StringBuffer res = new StringBuffer();
        for(StringBuilder c : list){
            res.append(c);
        }
        return res.toString();
    }

    public static void main(String[] args) {
        String s = "LEETCODEISHIRING";
        LeeCode l = new LeeCode();
        System.out.println(l.convert(s,3));
    }
}
