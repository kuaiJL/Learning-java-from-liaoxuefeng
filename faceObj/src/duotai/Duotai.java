package duotai;
/**
 * 多态:Polymorphic
 *多态是指，针对某个类型的方法调用，其真正执行的方法取决于运行时期实际类型的方法。
 * */
public class Duotai {

    public static void main(String[] args) {
        Person p = new Student();
        p.run(); // 应该打印Person.run还是Student.run?
        //解：Java的实例方法调用是基于运行时的实际类型的动态调用，
        // 而非变量的声明类型。故Student.run
        System.out.println(p);

        System.out.println(p.toString());
        System.out.println(p.getClass().getName() + '@' + Integer.toHexString(p.hashCode())+p.hashCode());

        //----------------------------------------------
        // 给一个有普通收入、工资收入和享受国务院特殊津贴的小伙伴算税:
        /*好像不能Income[] incomes = new Income[];
         * incomes={
         *                 new Income(3000),
         *                 new Salary(7500),
         *                 new StateCouncilSpecialAllowance(15000)
         *         };
        */
        Income[] incomes = new Income[]{
                new Income(3000),
                new Salary(7500),
                new StateCouncilSpecialAllowance(15000)
        };
        System.out.println(totalTax(incomes));

    }
    public static double totalTax(Income... incomes){
        double total = 0;
        for(Income income:incomes) {
            total+=income.getTax();
        }
        return total;
        }

}

class Person {
    public void run() {
        System.out.println("Person.run");
    }
}

class Student extends Person{
    @Override
    public void run(){
        System.out.println("Student.run");
    }

}

//假设我们定义一种收入，需要给它报税，那么先定义一个Income类：
class Income {
    protected double income;

    public Income(double income){
        this.income=income;
    }

    public double getTax() {
        return income * 0.1; // 税率10%
    }
}

class Salary extends Income {

    public Salary(double income){
        super(income);
    }
    @Override
    public double getTax() {
        if (income<=5000){
            return 0;
        }
        return (income-5000)*0.2;
    }
}

class StateCouncilSpecialAllowance extends Income {

    public StateCouncilSpecialAllowance(double income){
        super(income);
    }

    @Override
    public double getTax() {
        return 0;
    }
}