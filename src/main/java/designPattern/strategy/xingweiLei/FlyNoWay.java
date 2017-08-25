package designPattern.strategy.xingweiLei;

import designPattern.strategy.FlyBehavior;

public class FlyNoWay implements FlyBehavior {
	public void fly() {
		System.out.println("I can't fly");
	}
}
