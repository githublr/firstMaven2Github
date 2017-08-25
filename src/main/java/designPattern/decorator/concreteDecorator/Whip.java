package designPattern.decorator.concreteDecorator;

import designPattern.decorator.concreteComponent.Beverage;
import designPattern.decorator.CondimentDecorator;

//����װ�����ࣨ����������ʳ��
public class Whip extends CondimentDecorator {
	Beverage beverage;	//װ������һ��ʵ�����������Լ�¼��װ�ε�����
 
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
