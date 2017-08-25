package designPattern.decorator.concreteComponent;

//具体组件。每个组件代表一种咖啡类型
public class Espresso extends Beverage {
	public Espresso() {
		description = "Espresso";
	}
  
	public double cost() {
		return 1.99;
	}
}

