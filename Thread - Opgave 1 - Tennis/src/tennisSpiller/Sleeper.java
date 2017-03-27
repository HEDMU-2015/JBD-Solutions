package tennisSpiller;

public class Sleeper {

	public static double sleepInterruptable(double sekunder) {
		long start = System.currentTimeMillis();

		try {
			Thread.sleep((long) (sekunder * 1000));
		} catch (InterruptedException e) {
			// accept interruption
		}

		return ((double) System.currentTimeMillis() - start) / 1000;
	}

	public static double sleep(double sekunder) {
		double delta = 0;

		while (delta < sekunder)
			delta += sleepInterruptable(sekunder - delta);

		return delta;
	}

	public static double nap() {
		return sleep(0.1);
	}

	public static double sleepRandom(double sekunder) {
		return sleep(sekunder * Math.random());
	}

	public static void wait(Object obj) {
		try {
			obj.wait();
		} catch (InterruptedException e) {
			// ignore
		}
	}
}