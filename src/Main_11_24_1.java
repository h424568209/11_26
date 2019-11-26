import java.util.*;

public class Main_11_24_1 {
    // 火车进站==== 栈的出栈顺序
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            //火车数量
            int n = scanner.nextInt();
            //火车编号
            int []A = new int[n];
            for(int i = 0; i < n ;i++){
                A[i] = scanner.nextInt();
            }
            int start =0 ;
            //计算n个火车的出栈编号的排列组合
            ArrayList<int[]> result = new ArrayList<>();
            permutatuin(A,start,n,result);
            //出栈的结果--一个元素一个记录 比如1 2 3
            Set<String> sortResult = new TreeSet<>();
            //循环排列组合
            for(int []out : result){
                //判断是否满足出栈要求（后进先出）
                if(isLegal(A,out,n)){
                    //满足的组合，出入结果，每一个编号用空格分割
                    StringBuffer sb = new StringBuffer();
                    for(int i = 0 ; i < n-1 ; i++){
                        sb.append(out[i]+" ");
                    }
                    sb.append(out[n-1]);
                    sortResult.add(sb.toString());
                }
            }
            //最后输出所有的符合出栈要求的组合
            for(String list : sortResult){
                System.out.println(list);
            }
        }
        scanner.close();
    }

    /**
     *
     * @param in 火车编号数组
     * @param out 火车出栈顺序
     * @param n 火车数量
     */
    private static boolean isLegal(int[] in, int[] out, int n) {
        //栈 存储进栈的火车编号
        LinkedList<Integer> stack = new LinkedList<>();
        int i =0 ;
        int j = 0;
        //in还有元素的时候都需要判断
        while (i < n ) {
            //相等时不用出栈 直接后移
            if(in[i] == out[j]){
                i++;
                j++;
            }else{
                //空的话直接入栈
                if(stack.isEmpty()){
                    stack.push(in[i]);
                    i++;
                }else{
                    //栈顶元素相等，进行出栈
                    int top = stack.peek();
                    if(top == out[j]){
                        j++;
                        stack.pop();
                        //不相等的时候入栈，说明还有待进栈的车
                    }else if(i<n){
                        stack.push(in[i]);
                        i++;
                    }
                }
            }
        }
        //in的结束后 ，栈中元素进程出栈顺序应该和out剩余的元素相同
        while(!stack.isEmpty() && j<n){
            int top = stack.pop();
            if(top == out[j]){
                j++;
            }else{
                return false;
            }
        }
        return true;
    }

    //出栈的所有排列
    private static void permutatuin(int[] a, int start, int n, ArrayList<int[]> result) {
        if(start == n)
            return;
        if(start == n-1){
            int []B = a.clone();
            result.add(B);
            return;
        }
        for(int i = start ;i < n ;i++){
            swap(a,start,i);
            permutatuin(a,start+1,n,result);
            swap(a,start,i);
        }
    }

    private static void swap(int[] a, int start, int i) {
        int t = a[i];
        a[i] =a [start];
        a[start] = t;
    }
}
