package game.util;

public class Time {

	public static final long SECOND = 1000000000L;
	private static double delta=0;

	
	public static void setDelta(double delta) {
		Time.delta = delta;
	}

	public static long getTime() {
		return System.nanoTime();
	}
	
	public static double getDelta()
	{
		return delta;
	}

	public static void setDelta(int delta)
	{
		Time.delta = delta;
	}

}