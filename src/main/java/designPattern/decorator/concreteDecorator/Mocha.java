package designPattern.decorator.concreteDecorator;

import designPattern.decorator.concreteComponent.Beverage;
import designPattern.decorator.CondimentDecorator;

//����װ�����ࣨĦ����
public class Mocha extends CondimentDecorator {
	Beverage beverage;	//װ������һ��ʵ�����������Լ�¼��װ�ε�����
 
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
