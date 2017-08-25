package designPattern.strategy.xingweiLei;

import designPattern.strategy.QuackBehavior;

public class MuteQuack implements QuackBehavior {
	public void quack() {
		System.out.println("<< Silence >>");
	}
}
