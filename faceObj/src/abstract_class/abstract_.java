package abstract_class;

public class abstract_ {
    public static void main(String[] args) {
        Person s = new Student();
        Person t = new Teacher();
        s.run();
        t.run();

        // TODO: 用抽象类给一个有工资收入和稿费收入的小伙伴算税:
        Income[] incomes = new Income[] { new SalaryIncome(7500), new RoyaltyIncome(12000) };
        System.out.println(totalTax(incomes));
    }
    public static double totalTax(Income... incomes){
        double total=0;
        for (Income income:incomes) {
            total+=income.getTax();

        }
        return total;
    }
}

abstract class Person {
    public abstract void run();
}

class Student extends Person {
    @Override
    public void run() {
        System.out.println("Student.run");
    }
}

class Teacher extends Person {
    @Override
    public void run() {
        System.out.println("Teacher.run");
    }
}

/**
 * 定义抽象类Income
 */
abstract class Income {
    protected double income;
    public Income(double income){
        this.income=income;
    }

    public abstract double getTax();
}


class SalaryIncome extends Income {
    public SalaryIncome(double income) {
        super(income);
    }

    @Override
    public double getTax(){
        if (this.income <= 5000) {
            return 0;
        }
        return (this.income - 5000) * 0.2;
    }
    }

/**
 * 稿费收入税率是20%
 */
class RoyaltyIncome extends Income {
    public RoyaltyIncome(double income){
        super(income);
    }
    @Override
    public double getTax() {
        return this.income*0.2;
    }

}
