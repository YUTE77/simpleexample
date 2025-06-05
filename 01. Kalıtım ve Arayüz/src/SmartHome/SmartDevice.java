package SmartHome;
public abstract class SmartDevice {
	protected String name;
	protected boolean isOn;
	
	public SmartDevice(String name) {
		this.name = name;
		this.isOn = false;
		
	}
	
	public String getName() {
		return name;
	}
	
	public boolean isOn() {
		return isOn;
	}
	
	public abstract void status();

}
