package designPattern.strategy.allDuck;

import designPattern.strategy.FlyBehavior;
import designPattern.strategy.QuackBehavior;

/*	1、在Duck类中加入两个【实例变量】，分别为FlyBehavior接口和QuackBahavior接口。
	2、用两个相似的方法performQuack()和performFly()取代Duck类中的fly()和quack()*/
public abstract class Duck {
	FlyBehavior flyBehavior;
	QuackBehavior quackBehavior;
 
	public Duck() {
	}
 
	public void setFlyBehavior (FlyBehavior fb) {
		flyBehavior = fb;
	}
 
	public void setQuackBehavior(QuackBehavior qb) {
		quackBehavior = qb;
	}
 
	abstract void display();
 
	public void performFly() {
		flyBehavior.fly();
	}
 
	public void performQuack() {
		quackBehavior.quack();
	}
 
	public void swim() {
		System.out.println("All ducks float, even decoys!");
	}
}
