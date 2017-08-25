package designPattern.command.simpleremote;

/**
 * Created by zack.lr on 2017/8/23.
 */
//命令模式的客户端
public class RemoteControlTest {
    public static void main(String[] args) {
        Light light = new Light();                         //请求接受者
        LightOnCommand lightOn = new LightOnCommand(light);//创建一个命令

        GarageDoor garageDoor = new GarageDoor();
        GarageDoorOpenCommand garageOpen = new GarageDoorOpenCommand(garageDoor);


        SimpleRemoteControl remote = new SimpleRemoteControl();//调用者。发出请求。

        remote.setCommand(lightOn);          //把命令传给调用者
        remote.buttonWasPressed();

        remote.setCommand(garageOpen);
        remote.buttonWasPressed();
    }

    /*一句话总结，Invoker得到命令对象后，在某个时刻调用特定方法（比如遥控器按钮按下）触发命令对象调用execute方法，
    从而调用Receiver的相应方法（比如电灯的开或关）。*/
}
