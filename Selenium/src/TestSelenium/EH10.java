package TestSelenium;

public class EH10 {
	public static void eligbility(int age) {
		if (age < 18) {
			throw new ArithmeticException("Not valid");
		} else {
			System.out.println("Eligible for Voting");
		}
	}

	public static void main(String[] args) throws Exception {
		Thread.sleep(3000);

		// eligbility(15);
		eligbility(19);
	}

}
