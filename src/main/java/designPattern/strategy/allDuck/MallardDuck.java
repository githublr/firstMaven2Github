package designPattern.strategy.allDuck;

import designPattern.strategy.xingweiLei.FlyWithWings;
import designPattern.strategy.xingweiLei.Quack;

public class MallardDuck extends Duck {
 
	public MallardDuck() {
		quackBehavior = new Quack();
		flyBehavior = new FlyWithWings();
	}
 
	public void display() {
		System.out.println("I'm a real Mallard duck");
	}
}
