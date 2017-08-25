package designPattern.strategy.allDuck;

import designPattern.strategy.xingweiLei.FlyNoWay;
import designPattern.strategy.xingweiLei.Squeak;

public class RubberDuck extends Duck {
 
	public RubberDuck() {
		flyBehavior = new FlyNoWay();
		quackBehavior = new Squeak();
	}
 
	public void display() {
		System.out.println("I'm a rubber duckie");
	}
}
