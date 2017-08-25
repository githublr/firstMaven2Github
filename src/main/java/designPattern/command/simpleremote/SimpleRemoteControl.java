package designPattern.command.simpleremote;

/**
 * Created by zack.lr on 2017/8/23.
 */
//遥控器类
public class SimpleRemoteControl {
    Command slot;       //这个插槽持有命令

    public SimpleRemoteControl() {    }

    public void setCommand(Command slot) {
        this.slot = slot;
    }

    public void buttonWasPressed(){
        slot.execute();
    }
}
