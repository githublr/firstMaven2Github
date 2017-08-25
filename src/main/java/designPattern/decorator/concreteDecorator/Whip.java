package designPattern.decorator.concreteDecorator;

import designPattern.decorator.concreteComponent.Beverage;
import designPattern.decorator.CondimentDecorator;

//具体装饰者类（搅打奶油甜食）
public class Whip extends CondimentDecorator {
	Beverage beverage;	//装饰者有一个实例变量，可以记录所装饰的事物
 
	public Whip(Beverage beverage) {
		this.beverage = beverage;
	}
 
	public String getDescription() {
		return beverage.getDescription() + ", Whip";
	}
 
	public double cost() {
		return .10 + beverage.cost();
	}
}
