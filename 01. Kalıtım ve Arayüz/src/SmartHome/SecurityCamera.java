package SmartHome;
public class SecurityCamera extends SmartDevice implements Controllable, Recordable {
	private boolean recording;
	
	public SecurityCamera(String name) {
		super(name);
		this.recording = false;
	}

	@Override
	public void startRecording() {
		if (isOn) {
			recording = true;
			System.out.println(name + "started recording.");
		}
		else
			System.out.println(name + "is off. Cannot record.");
		
	}

	@Override
	public void stopRecording() {
		recording = false;
		System.out.println(name + "stopped recording.");
	}

	@Override
	public void turnOn() {
		isOn = true;
		System.out.println(name + " camera powered on." );
		
	}

	@Override
	public void turnOff() {
		isOn = false;
		recording = false;
		System.out.println(name + "camera powered off.");
		
	}

	@Override
	public void status() {
		 System.out.println(name + " [Camera] is " + (isOn ? "ON" : "OFF") +
	                ". Recording: " + (recording ? "YES" : "NO"));
	}

}
