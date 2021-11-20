package g_Collection_.MAP_;

import java.util.HashMap;
import java.util.Map;

public class UseMap {
    public static void main(String[] args) {
        Student s = new Student("Xiao Ming", 99);
        Map<String, Student> map = new HashMap<>();
        map.put("Xiao Ming",s);
        Student target = map.get("Xiao Ming");
        System.out.println(target == s);
        System.out.println(target.score);
        Student another = map.get("Bob");
        System.out.println(another);

    }
}
class Student {
    public String name;
    public int score;
    public Student(String name, int score) {
        this.name = name;
        this.score = score;
    }
}