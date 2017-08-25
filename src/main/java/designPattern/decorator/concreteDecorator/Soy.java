package designPattern.decorator.concreteDecorator;

import designPattern.decorator.concreteComponent.Beverage;
import designPattern.decorator.CondimentDecorator;

//����װ�����ࣨ�󶹡����ͣ�
public class Soy extends CondimentDecorator {
	Beverage beverage;	//װ������һ��ʵ�����������Լ�¼��װ�ε�����

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
