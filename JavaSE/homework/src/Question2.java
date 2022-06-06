public class Question2 {
    public static void main(String[] args) {
        OldPhone oldPhone = new OldPhone();
        NewPhone newPhone = new NewPhone();
        oldPhone.call();
        oldPhone.sendMessage();
        newPhone.call();
        newPhone.playGame();
        newPhone.sendMessage();
    }
}
/*
* 现有两种  OldPhone NewPhone; 两个类都有call()  sendMessage() 方法(考虑向上抽取一个父类);
	    已知接口IPlay中有一个方法 playGame()，NewPhone添加玩游戏的功能;
	要求: 分别测试OldPhone和NewPhone的两个方法,再测试新手机palyGame()的方法.
	* */
class Phone{
    public void call(){
        System.out.println("打电话");
    }

    public void sendMessage() {
        System.out.println("发信息");

    }
}
class OldPhone extends Phone{

}
class NewPhone extends Phone implements IPlay{

    @Override
    public void playGame() {
        System.out.println("玩游戏");
    }
}
interface IPlay{
    abstract void playGame();
}