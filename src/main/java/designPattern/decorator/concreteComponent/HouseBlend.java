package designPattern.decorator.concreteComponent;

//具体组件。每个组件代表一种咖啡类型
public class HouseBlend extends Beverage {
	public HouseBlend() {
		description = "House Blend Coffee";
	}
 
	public double cost() {
		return .89;
	}
}

