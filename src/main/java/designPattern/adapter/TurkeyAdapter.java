package designPattern.adapter;

/**
 * Created by zack.lr on 2017/8/23.
 */

//火鸡想冒充鸭子。必须要实现Duck接口
public class TurkeyAdapter implements Duck {
    Turkey turkey;

    public TurkeyAdapter(Turkey turkey){    //需要取得要适配的对象引用。
        this.turkey = turkey;               //利用构造器取得这个引用
    }

    public void quack() {
        turkey.gobble();
    }

    public void fly() {
        for(int i=0;i<5;i++){
            turkey.fly();
        }
    }
}
