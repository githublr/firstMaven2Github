package designPattern.decorator.concreteDecorator;

import designPattern.decorator.concreteComponent.Beverage;
import designPattern.decorator.CondimentDecorator;

//具体装饰者类（大豆、酱油）
public class Soy extends CondimentDecorator {
	Beverage beverage;	//装饰者有一个实例变量，可以记录所装饰的事物

	public Soy(Beverage beverage) {
		this.beverage = beverage;
	}

	public String getDescription() {
		return beverage.getDescription() + ", Soy";
	}

	public double cost() {
		return .15 + beverage.cost();
	}
}
