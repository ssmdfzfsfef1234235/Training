package com.offcn.test;

public class Test1 {
    public static void main(String[] args) {
        BasicEmployee basicEmployee = new BasicEmployee("张三", "前台", 5000);
        GoodEmployee goodEmployee = new GoodEmployee("李四", "开发", 6000, 4000);
        basicEmployee.showSalary();
        basicEmployee.showBonus();
        goodEmployee.showSalary();
        goodEmployee.showBonus();

    }
}
/*使用接口或者抽象类编写程序实现显示员工基本信息。具体要求如下：
 (1)使用接口或者抽象类实现基类Employer(体会接口和抽象类的不同)，包含姓名、部门和工资三个属
性，显示工资的方法showSalary()和显示奖金的抽象方法showBonus()；提示：因每位职工奖金不同，
showBonus()方法定义为抽象方法，只抽象定义，不具体实现；
 (2)定义BasicEmployee和GoodEmployee类，重写Employer类中的方法，不同员工有不同的工资和奖
金；
 (3)定义主类进行测试，要求输入两个不同的员工信息，并输出其个人信息。
输入输出说明:
输入： 张三 前台 5000 李四 开发 6000 4000
输出： 我叫张三,在前台部门，我的工资是5000.0 我是普通员工，没有奖金，加油升级！ 我叫李四,在开
发部门，我的工资是6000.0 我是优秀员工，我的奖金是4000.0*/

abstract class  Employer {
    private String name;
    private  String department;
    private  int salary;

    public Employer() {
    }

    public Employer(String name, String department, int salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

//显示工资的方法showSalary()和显示奖金的抽象方法showBonus()；提示：因每位职工奖金不同，
//showBonus()方法定义为抽象方法，只抽象定义，不具体实现；
    abstract void showBonus();
//    我叫张三,在前台部门，我的工资是5000.0 我是普通员工，没有奖金，加油升级！ 我叫李四,在开
//发部门，我的工资是6000.0 我是优秀员工，我的奖金是4000.0
    public void showSalary(){
        System.out.println("我叫"+getName()+",在"+getDepartment()+",我的工资是"+getSalary());
    }
}
//定义BasicEmployee和GoodEmployee类，重写Employer类中的方法，不同员工有不同的工资和奖金；
class BasicEmployee extends Employer{
    public BasicEmployee() {
    }

    public BasicEmployee(String name, String department, int salary) {
        super(name, department, salary);
    }

    @Override
    void showBonus() {
        System.out.println("我是普通员工，没有奖金，加油升级！");
    }
}
class GoodEmployee extends Employer{

    private int Bonus;

    public GoodEmployee() {
    }

    public GoodEmployee(String name, String department, int salary, int bonus) {
        super(name, department, salary);
        Bonus = bonus;
    }

    public int getBonus() {
        return Bonus;
    }

    public void setBonus(int bonus) {
        Bonus = bonus;
    }

    @Override
    void showBonus() {
        System.out.println("我是优秀员工，我的奖金是"+getBonus());
    }
}
/*(3)定义主类进行测试，要求输入两个不同的员工信息，并输出其个人信息。
输入输出说明:
输入： 张三 前台 5000 李四 开发 6000 4000
输出： 我叫张三,在前台部门，我的工资是5000.0 我是普通员工，没有奖金，加油升级！ 我叫李四,在开
发部门，我的工资是6000.0 我是优秀员工，我的奖金是4000.0*/