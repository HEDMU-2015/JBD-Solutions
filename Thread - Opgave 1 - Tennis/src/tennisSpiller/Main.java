package tennisSpiller;

public class Main {

	public static void main(String[] args) {

		TennisSpiller ts1, ts2;
		ts1 = new TennisSpiller("Vosniakki");
		ts2 = new TennisSpiller("Walliams");

		ts1.Setmodstander(ts2);
		ts2.Setmodstander(ts1);

		ts1.start();
		ts2.start();
		
		ts1.modtagBold();

	}

}
