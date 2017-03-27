package tennisSpiller;

public class TennisSpiller extends Thread {

	private TennisSpiller modstander;
	private String name;
	private boolean harBold;

	public TennisSpiller(String name) {
		this.name = name;

		harBold = false;
	}

	public void Setmodstander(TennisSpiller modstander) {
		this.modstander = modstander;
	}

	public void modtagBold() {
		harBold = true;
	}

	private void println(String message) {
		System.out.println(name + " " + message);
	}

	@Override
	public void run() {
		while (true) {
			while (!harBold)
				Sleeper.nap();
			println("Ser bolden");
			Sleeper.sleepRandom(2.0);
			if (Math.random() < 0.8) {
				println("returnere bolden");
				harBold = false;
				modstander.modtagBold();
			} else {
				println("Misser bolden");
				break;
			}
		}
	}
}
