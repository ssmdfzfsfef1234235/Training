import java.util.LinkedList;

/*定义一个带泛型的集合，只能在集合的头部进行增删
* */
public class ClassWork22 {
    public static void main(String[] args) {
        MyStack<String> stringMyStack = new MyStack<>();
        stringMyStack.push("a");
        stringMyStack.push("ab");
        stringMyStack.push("ac");

        stringMyStack.print();
        while (stringMyStack.length()>0){

            System.out.println(stringMyStack.pop());

        }

        stringMyStack.print();
//        System.out.println(stringMyStack);

    }
}

class MyStack<E> {
    private LinkedList<E> list = new LinkedList<E>();

    //头部增
    public void push(E a) {
        list.addFirst(a);
    }

    //头部删
    public E pop() {
        return list.removeFirst();
    }

    public int length() {
        return list.size();
    }
   public  void print(){
       for (E e1 : list) {
           System.out.println(list.toString());
       }
   }
}

