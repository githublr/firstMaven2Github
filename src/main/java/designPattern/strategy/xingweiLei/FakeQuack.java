package designPattern.strategy.xingweiLei;

import designPattern.strategy.QuackBehavior;

public class FakeQuack implements QuackBehavior {
	public void quack() {
		System.out.println("Qwak");
	}
}
