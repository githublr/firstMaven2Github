package designPattern.decorator.concreteComponent;

//���������ÿ���������һ�ֿ�������
public class Espresso extends Beverage {
	public Espresso() {
		description = "Espresso";
	}
  
	public double cost() {
		return 1.99;
	}
}

