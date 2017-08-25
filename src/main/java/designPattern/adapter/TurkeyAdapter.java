package designPattern.adapter;

/**
 * Created by zack.lr on 2017/8/23.
 */

//����ð��Ѽ�ӡ�����Ҫʵ��Duck�ӿ�
public class TurkeyAdapter implements Duck {
    Turkey turkey;

    public TurkeyAdapter(Turkey turkey){    //��Ҫȡ��Ҫ����Ķ������á�
        this.turkey = turkey;               //���ù�����ȡ���������
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
