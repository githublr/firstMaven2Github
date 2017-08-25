package designPattern.decorator;

import designPattern.decorator.concreteComponent.Beverage;
import designPattern.decorator.concreteComponent.Espresso;
import designPattern.decorator.concreteComponent.HouseBlend;
import designPattern.decorator.concreteDecorator.Mocha;
import designPattern.decorator.concreteDecorator.Soy;
import designPattern.decorator.concreteDecorator.Whip;

/**
 * Created by zack.lr on 2017/8/22.
 */
public class StartbuzzCoffee {
    public static void main(String[] args) {
        Beverage beverage1 = new Espresso();
        System.out.println(beverage1.getDescription()+" $"+beverage1.cost());

        Beverage beverage2 = new HouseBlend();
        beverage2 = new Soy(beverage2);
        beverage2 = new Mocha(beverage2);
        beverage2 = new Whip(beverage2);
        System.out.println(beverage2.getDescription()+" $"+beverage2.cost());
    }

}
