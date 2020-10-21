package TestSelenium;

public class EH8 {

	public static void main(String[] args) {
		try {
			int i = 10 / 0;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println("This will execute always!");
		}

	}

}
