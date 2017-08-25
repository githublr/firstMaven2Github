package designPattern.command.simpleremote;

/**
 * Created by zack.lr on 2017/8/23.
 */
//ң������
public class SimpleRemoteControl {
    Command slot;       //�����۳�������

    public SimpleRemoteControl() {    }

    public void setCommand(Command slot) {
        this.slot = slot;
    }

    public void buttonWasPressed(){
        slot.execute();
    }
}
