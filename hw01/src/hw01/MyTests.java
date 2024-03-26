package hw01;

public class MyTests {
	public static void main(String args[]) {
		CameraBattery bat = new CameraBattery(2, 10);
		
		// testing external charger
		bat.moveBatteryExternal();
		bat.buttonPress();
		bat.buttonPress();
		bat.buttonPress();
		System.out.println(bat.externalCharge(2) + " Expect 6.0");
		System.out.println("Charger setting: " + bat.getChargerSetting());
		System.out.println("batteryCharge: " + bat.getBatteryCharge());
	}
}
