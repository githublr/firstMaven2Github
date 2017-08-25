package designPattern.strategy.allDuck;

import designPattern.strategy.xingweiLei.FlyNoWay;
import designPattern.strategy.xingweiLei.Quack;

public class ModelDuck extends Duck {
	public ModelDuck() {
		flyBehavior = new FlyNoWay();
		quackBehavior = new Quack();
	}

	public void display() {
		System.out.println("I'm a model duck");
	}
}
