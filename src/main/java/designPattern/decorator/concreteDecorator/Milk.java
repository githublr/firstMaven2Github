package designPattern.decorator.concreteDecorator;

import designPattern.decorator.concreteComponent.Beverage;
import designPattern.decorator.CondimentDecorator;

public class Milk extends CondimentDecorator {
	Beverage beverage;	//װ������һ��ʵ�����������Լ�¼��װ�ε�����

	public Milk(Beverage beverage) {
		this.beverage = beverage;
	}

	public String getDescription() {
		return beverage.getDescription() + ", Milk";
	}

	public double cost() {
		return .10 + beverage.cost();
	}
}
