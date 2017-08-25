package designPattern.observer.display;

import designPattern.observer.DisplayElement;
import designPattern.observer.Observer;
import designPattern.observer.Subject;

public class CurrentConditionsDisplay implements Observer, DisplayElement {
	private float temperature;
	private float humidity;
	private Subject weatherData;			//�۲��߱���ע��������⣬�Ա���ո���
	
	public CurrentConditionsDisplay(Subject weatherData) {
		this.weatherData = weatherData;
		weatherData.registerObserver(this);//�۲��߱���ע��������⣬�Ա���ո���
	}
	
	public void update(float temperature, float humidity, float pressure) {
		this.temperature = temperature;
		this.humidity = humidity;
		display();
	}
	
	public void display() {
		System.out.println("Current conditions: " + temperature 
			+ "F degrees and " + humidity + "% humidity");
	}
}
