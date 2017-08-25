package designPattern.command.simpleremote;

/**
 * Created by zack.lr on 2017/8/23.
 */
public class LightOnCommand implements Command{
    Light light;

    public LightOnCommand(Light light){
        this.light=light;
    }

    public void execute() {
        light.on();
    }
}
