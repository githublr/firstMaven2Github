package designPattern.strategy.allDuck;

import designPattern.strategy.xingweiLei.FlyWithWings;
import designPattern.strategy.xingweiLei.Quack;

public class RedHeadDuck extends Duck {
 
	public RedHeadDuck() {
		flyBehavior = new FlyWithWings();
		quackBehavior = new Quack();
	}
 
	public void display() {
		System.out.println("I'm a real Red Headed duck");
	}
}
