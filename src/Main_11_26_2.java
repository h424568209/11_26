import java.util.*;

class Student{
    String name;
    int age;
    public  Student(String name,int age){
        this.name = name;
        this.age = age;
    }
    public String toString(){
        return this.name+" "+this.age;
    }
}
public class Main_11_26_2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while(scanner.hasNext()){
            List<Student> list = new ArrayList<>();
            int n = scanner.nextInt();
            int m = scanner.nextInt();
            for(int i = 0 ; i < n ; i++){
                String name = scanner.next();
                int age = scanner.nextInt();
                list.add(new Student(name,age));
            }
            if(m == 1){
                list.sort(new Comparator<Student>() {
                    @Override
                    public int compare(Student o1, Student o2) {
                        return o1.age - o2.age;
                    }
                });
                for(int i = 0 ; i < list.size();i++){
                    System.out.println(list.get(i));
                }
            }
            if(m == 0){
                list.sort(new Comparator<Student>() {
                    @Override
                    public int compare(Student o1, Student o2) {
                        return o2.age - o1.age;
                    }
                });
                for(int i =0 ; i < list.size(); i ++){
                    System.out.println(list.get(i));
                }
            }
        }
    }
}
