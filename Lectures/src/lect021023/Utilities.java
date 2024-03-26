package lect021023;

public class Utilities {
	public final static int IN_PER_FT = 12;
	public final static double CM_PER_IN = 2.54;
	
	public static double convertFtToIn(double ft) {
		return ft * IN_PER_FT;
	}
	public static double convertInToCM(double in) {
		return in * CM_PER_IN;
	}
	public static double ftInToCm(double ft, double in) {
		return convertInToCM(convertFtToIn(ft) + in);
	}
	
	public static double calcVolumeOfSphere(double r) {
		double volume;
		volume = 4.0 / 3;
		volume *= Math.PI;
		volume *= Math.pow(r,  3);
		return volume;
	}
}
