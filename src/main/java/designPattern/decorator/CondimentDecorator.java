package designPattern.decorator;

import designPattern.decorator.concreteComponent.Beverage;

//装饰者都要实现的接口（也可以说是抽象类）
public abstract class CondimentDecorator extends Beverage {
	public abstract String getDescription();
}
