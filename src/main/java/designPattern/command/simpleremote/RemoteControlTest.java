package designPattern.command.simpleremote;

/**
 * Created by zack.lr on 2017/8/23.
 */
//����ģʽ�Ŀͻ���
public class RemoteControlTest {
    public static void main(String[] args) {
        Light light = new Light();                         //���������
        LightOnCommand lightOn = new LightOnCommand(light);//����һ������

        GarageDoor garageDoor = new GarageDoor();
        GarageDoorOpenCommand garageOpen = new GarageDoorOpenCommand(garageDoor);


        SimpleRemoteControl remote = new SimpleRemoteControl();//�����ߡ���������

        remote.setCommand(lightOn);          //�������������
        remote.buttonWasPressed();

        remote.setCommand(garageOpen);
        remote.buttonWasPressed();
    }

    /*һ�仰�ܽᣬInvoker�õ�����������ĳ��ʱ�̵����ض�����������ң������ť���£���������������execute������
    �Ӷ�����Receiver����Ӧ�����������ƵĿ���أ���*/
}
