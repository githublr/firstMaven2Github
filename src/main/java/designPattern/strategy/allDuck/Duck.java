package designPattern.strategy.allDuck;

import designPattern.strategy.FlyBehavior;
import designPattern.strategy.QuackBehavior;

/*	1����Duck���м���������ʵ�����������ֱ�ΪFlyBehavior�ӿں�QuackBahavior�ӿڡ�
	2�����������Ƶķ���performQuack()��performFly()ȡ��Duck���е�fly()��quack()*/
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
