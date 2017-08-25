package designPattern.decorator.concreteDecorator;

import designPattern.decorator.concreteComponent.Beverage;
import designPattern.decorator.CondimentDecorator;

//具体装饰者类（摩卡）
public class Mocha extends CondimentDecorator {
	Beverage beverage;	//装饰者有一个实例变量，可以记录所装饰的事物
 
	public Mocha(Beverage beverage) {
		this.beverage = beverage;
	}
 
	public String getDescription() {
		return beverage.getDescription() + ", Mocha";
	}
 
	public double cost() {
		return .20 + beverage.cost();
	}
}
