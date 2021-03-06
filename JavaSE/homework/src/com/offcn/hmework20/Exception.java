package com.offcn.hmework20;
/*
* 1、简述什么是异常、异常的继承体系？
异常：
①在java程序运行过程中，出现的不正常情况，出现的错误，称为异常
②异常就是一个对象，描述那些不符合生活正常情况的异常情况，包含了这些情况的原因、类型、描述以及位置，这些内容都封装到异常对象中。
③异常也是一种处理异常情况的机制，可以进行跳转、捕获以及结束程序。
* throwable：可抛出的，是异常体系的顶层父类，其他异常或错误都是throwable的子类类型
* 只有thowable的体系类型，才可以使用异常的处理机制。
* error：错误，是throwable的子类，用于描述那些无法捕捉和处理的错误情况，属于非
* 常严重的错误，stackoverflow
* exception:异常，是throwable的子类，用于描述那些可以捕获和处理的情况，属于不太严重的错误
* ，arrayindexoutofboundsexception
* runtimeexceptiuon:运行时异常，是exception的特殊子类，在编译阶段不做检查的一个异常
*
2、什么是编译时异常，什么是运行时异常？
*①无论是编译时异常还是运行时异常，都是只有在运行阶段才可能发生的异常
* ②区别:
* (1)继承体系的区别：编译时异常是Exception以及exception的子类类型
* （runtimeexception除外），运行时异常是runtimeexception以及runtimeexception
* 的子类。
* （2）编译时异常，在编译阶段要对此异常进行检测的异常，一旦有这种
* 编译时异常，编译编译阶段是不可能通过的，只能通过异常处理的两种手段
* 解决（异常声明、异常的捕获和处理）编译失败问题；运行时异常在编译
* 阶段不做检查的异常，可以通过异常处理的手段处理，也可以使用异常避免的
* 方式，来避免一场的发生。
*
* 3.总结：
* ①编译时异常：出现就必须手动处理，否则程序无法通过，程序也无法运行
* ②运行时异常：出现手动处理与否均可，无论是否处理程序编译都可以通过
3、简述异常的处理方式？
* jvm默认处理的方式：【一层一层向上抛，jvm接收到之后结束自己】
* 手动处理异常的方式：
* ①异常的声明：某方法有编译时异常，编译就会无法通过，需要在异常所在的方法
* 声明上，声明该方法可能出现的编译时异常
* ②异常的捕获：出现异常之后，可以通过某些格式来捕获和处理异常，可以让程序
* 异常后，继续运行。可以定义自己处理异常的逻辑
*
4、final、finally、finalize分别是什么？有什么作用？
*final：final修饰变量表示这个变量就是常量，final修饰类表示这个类不能
* 被继承，final修饰方法表示这个方法不能被覆盖。
* finally：finally语句块实在try-catch时使用或在try后使用，在捕获异常
* 处理完成之后都会执行finally语句块，不管有没有异常。
* finalize是一个方法，在垃圾收集器执行的时候会调用被回收对象的的此方法
* ，供垃圾收集时的其他资源回收。
*
5、简述throw和throws关键字的作用以及区别
* throw：抛出，用于抛出一个异常对象，异常是一个对象，当程序运行到某种情况时，
* 程序员认为这种情况和现实生活不符合， 就把当前的对于情况的描述，
* 封装到一个异常对象中，通过throw关键字将异常对象进行抛 出。
*、作用： 创建一个异常对象，使用throw关键字抛出，实现了程序的结束或者跳转
* 如果抛出的是编译时异常，那么这个异常必须使用异常处理的方式处理，
* 才能编译成功 如果抛出的是运行时异常，在编译阶段就相当于没有异常，
* 可以不处理这个异常
* throws：意义：抛出，作用：用于声明一个异常类型 2、在某个方法中，有一些编译时异常，没有给出处理的方案，
* 没有捕获这个异常，没有处 理这个异常，就说明这个方法是一个有问题的方法。为了让调用者在调用时，可以考虑
* 到处 理这个异常，所必须在当前方法的声明上，声明这个异常。
* （1）如果抛出的是一个运行时异常，那么就相当于没有抛出异常，这种异常也不需要在 方法上声明；声明了一个运行时异常，也相当于没有做任何声明
* （2）如果抛出的是一个编译时异常，那么就必须进行声明或者捕获；如果声明了一个编 译时异常，将来调用这个方法时，也相当于有一个声明的异常。
* （3）在声明异常的时候，尽量声明小的异常、尽量声明少的异常
* 区别：
* 1、throw是对异常对象的抛出，throws是对异常类型的声明
* 2、throw是对异常对象实实在在的抛出，一旦使用了throw关键字，就一定有一个异常对象 出现；
* throws是对可能出现的异常类型的声明，即使声明了一些异常类型，在这个方法中， 也可以不出现任何异常。
* 3、throw后面只能跟一个异常对象；throws可以跟很多个异常类型
* 4、throws关键字声明异常的时候，声明尽量少、尽量小的异常
6、全面的回答方法的重写是什么，以及注意事项
* 重写：方法的重写：Override，覆盖、覆写
* 在子类中，定义和父类同名的方法，使用新的方法体，覆盖父类中旧的方法体
* 【在继承关系中，方法名称相同，参数列表相同，与返回值类型有关】
*  注解：@Override 可以对方法按照重写语法进行严格的语法检测
* 注意事项： 1、与返回值类型有关：父类方法返回值类型如果是A类，则重写方法返回值类型只能是A 类或者A的子类
*  2、私有方法不能被重写，因为不能被继承
*  3、重写的方法权限可以不变，可以越来越大，但是不能越来越小
* 4.重写中，如果父类方法声明的是A类型的异常，子类方法要声明也只能声明A类型异常或A 类型的子类类型异常，或者子类重写方法直接tryCatch
* 5.重写中，如果父类方法没有声明异常，子类方法中存在编译时异常，那么只能 tryCatch，不允许throws声明
7、自定义一个学生类，属性有 name 和 age，将该类写成标准的JavaBean
   在测试类中创建对象，调用其有参构造或者使用setAge方法为age属性赋值时，
   如果年龄不合法，抛出一个自定异常IllegalAgeException打断程序运行
   要求：自定义异常分别定义成编译时异常和运行时异常进行测试*/
public class Exception {
    public static void main(String[] args) throws IllegalAgeException {
        Student student = new Student();
        student.setAge(1000);

    }
    public static class Student{
        private int age ;
        private String name ;

        public Student() {
        }

        public Student(int age, String name) {
            this.age = age;
            this.name = name;
        }

        public int getAge() {

            return age;
        }

        public void setAge(int age) throws IllegalAgeException{
            if(age >0 && age < 100){
                this.age = age;

            }else {
                throw  new IllegalAgeException();
            }

        }

        public String getName() {
            return name;
        }

        public void setName(String name) {
            this.name = name;
//            如果年龄不合法，抛出一个自定异常IllegalAgeException打断程序运行

        }
    }


}
