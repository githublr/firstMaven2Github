package designPattern.strategy.allDuck;

import designPattern.strategy.xingweiLei.FlyNoWay;

/**
 * Created by zack.lr on 2017/8/23.
 */
public class SimUDuck2{
    public static void main(String[] args)
    {
        Duck duck1=new MallardDuck();
        System.out.println("野鸭子出场-----------------");
        duck1.performQuack();
        duck1.swim();
        duck1.display();
        duck1.performFly();
        duck1.setFlyBehavior(new FlyNoWay());//动态的改变飞行行为
        duck1.performFly();
    }
}
