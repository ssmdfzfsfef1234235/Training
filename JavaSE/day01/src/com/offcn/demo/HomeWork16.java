package com.offcn.demo;

public class HomeWork16 {
}
/*1、什么是多态？
多态：事物的多种表现形态，就是多态，polymorphic
对象的多态性：同一个对象，可能具有不同的名称，同一个对象，有不同的类型的引用 指向它。
本质：同一个物体有不同的名称和描述。
类型的多态性：同一个类型，可能具有不同的子类实现。
同一个类型引用，有不同的对 象实现。
本质：同一个名字和描述，可以在不同场景下有不同的真实实现。

2、多态的前提？特点？格式？
前提：（1）要有子父类的继承（实现）关系 （2）有方法的重写 （3）父类的引用指向子类的对象
（二）多态中成员变量的访问特点 1、编译看左边，运行看左边 2、编译的时候，要看【=】左边的引用的类型中，是否有该变量的定义，如果有，就编译成 功，如果没有，就编译失败。 3、运行的时候，要看【=】左边的引用所属类型中，真正如何给变量赋值的。获取到的是引 用父类的赋值结果。
（三）多态中成员方法的访问特点 1、编译看左边，运行看右边 3、运行的时候，要看【=】右边的对象所属的类型中，是如何实现这个方法的。最终运行的 是子类重写过的方法实现。
（四）多态中静态方法的访问特点 1、编译看左边，运行看左边 2、编译的时候，要看【=】左边的引用所属的类型中，是否有该方法的定义，如果有，就编 译成功，如果没有，就编译失败
3、运行的时候，要看【=】左边的引用所属的类型中，如何实现该方法的。最终运行的是引 用所属类型中该方法的实现。（静态方法属于类，和父类的方法不属于重写关系） 4、静态最终解释： 静态变量：存储在类的字节码中的变量，被所有对象所共享，不随着对象的变化而变 化，都有相同的值，所以称为静态变量 静态方法：只会根据引用所属的父类，来决定运行的内容，运行内容，不会随着子类的 变化而变化，都是引用所属的父类的方法实现，所以称为静态方法。

3、多态状态下资源的访问原则？
（二）多态中成员变量的访问特点 1、编译看左边，运行看左边 2、编译的时候，要看【=】左边的引用的类型中，是否有该变量的定义，如果有，就编译成 功，如果没有，就编译失败。 3、运行的时候，要看【=】左边的引用所属类型中，真正如何给变量赋值的。获取到的是引 用父类的赋值结果。
（三）多态中成员方法的访问特点 1、编译看左边，运行看右边 3、运行的时候，要看【=】右边的对象所属的类型中，是如何实现这个方法的。最终运行的 是子类重写过的方法实现。
（四）多态中静态方法的访问特点 1、编译看左边，运行看左边 2、编译的时候，要看【=】左边的引用所属的类型中，是否有该方法的定义，如果有，就编 译成功，如果没有，就编译失败
3、运行的时候，要看【=】左边的引用所属的类型中，如何实现该方法的。最终运行的是引 用所属类型中该方法的实现。（静态方法属于类，和父类的方法不属于重写关系） 4、静态最终解释： 静态变量：存储在类的字节码中的变量，被所有对象所共享
，不随着对象的变化而变 化，都有相同的值，所以称为静态变量 静态方法：只会根据引用所属的父类，来决定运行的内容，运行内容，不会随着子类的 变化而变化，都是引用所属的父类的方法实现，所以称为静态方法。

4、多态的好处是什么？
1、提高了代码的可扩展性 2、在方法的参数列表中，可以定义父类类型的引用，将来调用的时候，所有的子类类型的 对象，都可以作为方法的实际参数。
3、不在方法的参数列表中，就在普通的方法体中，使用父类的类型指向子类的对象，也能 提高代码的可扩展性。对象的来源非常广泛，不仅仅是new出来的
，（还可能是通过反射获 取的，通过文件读取的，还可能是网络传递的，在写代码的编译阶段，无法知道对象具体的 子类类型的）需要使用父类类型的引用，操作不知道的子类类型的对象。

5、设计一个台灯类Lamp其中台灯有灯泡这个属性，还有开灯(on)这个方法，
设计一个灯泡类 其中有红灯泡(RedBuble)  和绿灯泡(GreenBuble) 他们都有一个发亮的方法，
请设计出一段代码可以使台灯开启灯泡发亮，并且保证替换不同种类的灯泡台灯类代码不被修改


6、设计一个形状类Shape,方法:求周长和求面积
形状类(
形状类也可以写成接口)的子类(实现类):Rect(矩形),Circle(圆形)

Rect类的子类:Square(正方形)
不同的子类会有不同的计算周长和面积的方法
创建三个不同的形状对象，
放在Shape类型的数组里,分别打印出每个对象的周长和面积


7、（这是昨天的作业，在底下添加了新的要求）某公司的雇员分为以下若干类：

Employee：这是所有员工总的父类，属性：员工的姓名,员工的生日月份。
方法：getSalary(int month) 根据参数月份来确定工资，如果该月员工过生日，则公司会额外奖励100元。

SalariedEmployee：Employee的子类，拿固定工资的员工。
属性：月薪HourlyEmployee：Employee的子类，按小时拿工资的员工，每月工作超出160小时的部分按照1.5倍工资发放。
属性：每小时的工资、每月工作的小时数

SalesEmployee：Employee的子类，销售人员，工资由月销售额和提成率决定。
属性：月销售额、提成率

BasePlusSalesEmployee：SalesEmployee的子类，有固定底薪的销售人员，工资由底薪加上销售提成部分。
属性：底薪。


要求：
1、写一个程序，把若干各种类型的员工放在一个数组里
2、结合方法的重写，在上述类结构中合适的位置添加show方法，使show方法能展示任何一个类型对象的属性
3、在测试类中写一个方法，能够遍历要求1中的数组，展示数组中对象的属性和工资
注意：把每个类都做成完全封装，不允许非私有化属性，如果能写成标准的JavaBean更好。*/
/*
* 5、设计一个台灯类Lamp其中台灯有灯泡这个属性，还有开灯(on)这个方法，
设计一个灯泡类 其中有红灯泡(RedBuble)  和绿灯泡(GreenBuble) 他们都有一个发亮的方法，
请设计出一段代码可以使台灯开启灯泡发亮，并且保证替换不同种类的灯泡台灯类代码不被修改
*/
 class Lamp {
    public static  String LightBulb ;

    public void on(lightBulb a){
        System.out.println("开灯");
        a.light();

    }
}
abstract class lightBulb {
     abstract void light();
}
class RedBuble extends lightBulb{
    public void light(){
        System.out.println("发红光");
    }
}
class GreenBuble extends lightBulb{
    public void light(){
        System.out.println("发绿光");
    }
}