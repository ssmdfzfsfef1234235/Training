package com.offcn.demo;

public class HelloWorld {
    public static void main(String[] args) {
        SalesEmployee se = new SalesEmployee();

    }

}

/*5、某公司的雇员分为以下若干类：


Employee：这是所有员工总的父类，属性：员工的姓名,员工的生日月份。
方法：getSalary(int month) 根据参数月份来确定工资，如果该月员工过生日，则公司会额外奖励100元。

SalariedEmployee：Employee的子类，拿固定工资的员工。
属性：月薪

HourlyEmployee：Employee的子类，按小时拿工资的员工，每月工作超出160小时的部分按照1.5倍工资发放。
属性：每小时的工资、每月工作的小时数

SalesEmployee：Employee的子类，销售人员，工资由月销售额和提成率决定。
属性：月销售额、提成率

BasePlusSalesEmployee：SalesEmployee的子类，有固定底薪的销售人员，工资由底薪加上销售提成部分。

按照以上描述创建类并且设计类的关系，之后创建对象测试*/
/*Employee：这是所有员工总的父类，属性：员工的姓名,员工的生日月份。
方法：getSalary(int month) 根据参数月份来确定工资，如果该月员工过生日，则公司会额外奖励100元。
*/
class Employee {
    private String name;
    private int birthMonth;

    public Employee() {
    }

    public Employee(String name, int birthMonth) {
        this.name = name;
        this.birthMonth = birthMonth;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getBirthMonth() {
        return birthMonth;
    }

    public void setBirthMonth(int birthMonth) {
        this.birthMonth = birthMonth;
    }
//    方法：getSalary(int month) 根据参数月份来确定工资，如果该月员工过生日，则公司会额外奖励100元。

    public double getSalary(int month) {
        return month == birthMonth ? 100 : 0;
    }


}

/*SalariedEmployee：Employee的子类，拿固定工资的员工。
属性：月薪*/
class SalariedEmployee extends Employee {
    private double monthSalary;

    public SalariedEmployee() {
    }

    public SalariedEmployee(double monthSalary) {
        this.monthSalary = monthSalary;
    }

    public SalariedEmployee(String name, int birthMonth, double monthSalary) {
        super(name, birthMonth);
        this.monthSalary = monthSalary;
    }

    public double getMonthSalary() {
        return monthSalary;
    }

    public void setMonthSalary(double monthSalary) {
        this.monthSalary = monthSalary;
    }

    /*HourlyEmployee：Employee的子类，按小时拿工资的员工，每月工作超出160小时的部分按照1.5倍工资发放。
属性：每小时的工资、每月工作的小时数*/
    class HourlyEmployee extends Employee {
        private int hourlySalary;
        private int hour;

        public HourlyEmployee() {
        }

        public HourlyEmployee(String name, int birthMonth, int hourlySalary, int hour) {
            super(name, birthMonth);
            this.hourlySalary = hourlySalary;
            this.hour = hour;
        }

        public int getHourlySalary() {
            return hourlySalary;
        }

        public void setHourlySalary(int hourlySalary) {
            this.hourlySalary = hourlySalary;
        }

        public int getHour() {
            return hour;
        }

        public void setHour(int hour) {
            this.hour = hour;
        }

        @Override
        public double getSalary(int month) {
            double salary;
//            每月工作超出160小时的部分按照1.5倍工资发放。
            if (hour <= 160) {
                salary = hour * hourlySalary;
            } else {
                salary = 160 * hourlySalary + (hour - 160) * hourlySalary * 1.5;

            }
            return salary + super.getSalary(month);
        }
    }
}

/*SalesEmployee：Employee的子类，销售人员，工资由月销售额和提成率决定。
属性：月销售额、提成率*/
class SalesEmployee extends Employee {
    private int salesMoney;
    private double rate;

    public SalesEmployee() {
    }

    public SalesEmployee(String name, int birthMonth, int salesMoney, double rate) {
        super(name, birthMonth);
        this.salesMoney = salesMoney;
        this.rate = rate;
    }

    public int getSalesMoney() {
        return salesMoney;
    }

    public void setSalesMoney(int salesMoney) {
        this.salesMoney = salesMoney;
    }

    public double getRate() {
        return rate;
    }

    public void setRate(double rate) {
        this.rate = rate;
    }
//    工资由月销售额和提成率决定。

    @Override
    public double getSalary(int month) {

        return salesMoney * rate + super.getSalary(month);
    }
}

/*BasePlusSalesEmployee：SalesEmployee的子类，有固定底薪的销售人员，工资由底薪加上销售提成部分。*/
class BasePlusSalesEmployee extends SalesEmployee {
    private int baseSalary;

    public BasePlusSalesEmployee() {
    }

    public BasePlusSalesEmployee(String name, int birthMonth, int salesMoney, double rate, int baseSalary) {
        super(name, birthMonth, salesMoney, rate);
        this.baseSalary = baseSalary;
    }

    public int getBaseSalary() {
        return baseSalary;
    }

    public void setBaseSalary(int baseSalary) {
        this.baseSalary = baseSalary;
    }

    @Override
    public double getSalary(int month) {
        return baseSalary + super.getSalary(month);
    }
}