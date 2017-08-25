package designPattern.decorator;

import designPattern.decorator.concreteComponent.Beverage;

//װ���߶�Ҫʵ�ֵĽӿڣ�Ҳ����˵�ǳ����ࣩ
public abstract class CondimentDecorator extends Beverage {
	public abstract String getDescription();
}
