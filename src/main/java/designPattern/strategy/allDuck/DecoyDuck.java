package designPattern.strategy.allDuck;

import designPattern.strategy.xingweiLei.FlyNoWay;
import designPattern.strategy.xingweiLei.MuteQuack;

public class DecoyDuck extends Duck {
	public DecoyDuck() {
		setFlyBehavior(new FlyNoWay());
		setQuackBehavior(new MuteQuack());
	}
	public void display() {
		System.out.println("I'm a duck Decoy");
	}
}
