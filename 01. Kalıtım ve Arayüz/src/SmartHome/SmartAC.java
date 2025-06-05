package SmartHome;

public class SmartAC extends SmartDevice  implements Controllable{
	private int temperature;
	
	public SmartAC(String name) {
		super(name);
		this.temperature = 24;
	}
	
	@Override
	public void turnOn() {
		isOn = true;
		System.out.println(name + "turned on. Current tempature: " + temperature + "C");
	}

	public void turnOff() {
		isOn = false;
		System.out.println("turned off.");
	}
	
	public void setTemperature(int temp) {
		if (isOn) {
			this.temperature = temp;
			System.out.println(name + " temperature set to " + temp + "°C");
		}
		else 
            System.out.println(name + " is off. Cannot set temperature.");
            
	}
	public void status() {
		System.out.println(name + " [AC] is " + (isOn ? "ON" : "OFF") + ". Temp: " + temperature + "°C");
	}
}