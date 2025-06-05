package SmartHome;
public class SmartHomeTest {
	public static void main(String[] args) {
		SmartAC ac = new SmartAC("Living Room AC");
		SecurityCamera camera = new SecurityCamera("Front Door Cam");
		
		ac.turnOn();
		ac.setTemperature(22);
		ac.status();
		
		System.out.println();
		
		camera.turnOn();
		camera.startRecording();
		camera.status();
		
		System.out.println();
		
		ac.turnOff();
		camera.stopRecording();
		camera.turnOff();
	}
}
