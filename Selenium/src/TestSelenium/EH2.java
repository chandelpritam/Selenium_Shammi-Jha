package TestSelenium;

public class EH2 {

	public static void main(String[] args) {
		try {
			int c = 3 / 0;
		} catch (ArithmeticException e) {
			System.out.println(e);
		}

		System.out.println("Exception handled");
		for (int i = 0; i <= 5; i++) {
			System.out.println(i);
		}
	}

}
