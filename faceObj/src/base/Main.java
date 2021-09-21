package base;

import java.util.Arrays;

public class Main {
    public static void main(String[] args) {
        City bj =new City();
        bj.name="beijing";
        bj.latitude=33.903;
        bj.longitude=116.401;
        //String kjl;
        bj.getInfo();
        //System.out.println(kjl);

        //get set
        Person ming = new Person();
        ming.setName("纳达尔");
        ming.setAge(34);
        System.out.println(ming.getName()+","+ming.getAge());

        //private方法
        PersonHasPrivateMethod hong = new PersonHasPrivateMethod();
        hong.setBirth(1997);
        System.out.println(hong.getAge());

        //方法可变参数
        Group g = new Group();
        Group h = new Group();
        Group i = new Group();
        g.setNames("Xiao Ming", "Xiao Hong", "Xiao Jun"); // 传入3个String
        h.setNames("Xiao Ming", "Xiao Wu"); // 传入2个String
        i.setNames();

        System.out.println(Arrays.toString(g.names));
        System.out.println(Arrays.toString(h.names));
        System.out.println(Arrays.toString(i.names));

    }

}

class City{
    public String name;
    public double latitude;
    public double longitude;
    public void getInfo (){
        System.out.println("城市："+this.name+",北纬:"+this.latitude+",东经:"+this.longitude);
        //return this.name+this.latitude+this.longitude;
    }
}

class Person{
    private String name;
    private int age;
    public String getName(){
        return this.name;
    }

    public void setName(String name){
        this.name = name;
    }

    public int getAge() {
        //没有传参，可以不用this.age
        return age;
    }

    public void setAge(int age) {
        if(age<0 || age>100){
            throw new IllegalArgumentException("invalid age value");
        }
        this.age = age;
    }
}

class PersonHasPrivateMethod{
    private String name;
    private int birth;

    public void setBirth(int birth) {
        this.birth = birth;
    }

    public int getAge() {
        //没有传参，可以不用this.age
        return calcAge(2021);// 调用private方法
    }
    // private方法:
    private int calcAge(int currentYear){
        return currentYear-this.birth;
    }



}
//方法可变参数
class Group {
    public String[] names;

    public void setNames(String... names) {
        this.names = names;
    }
}