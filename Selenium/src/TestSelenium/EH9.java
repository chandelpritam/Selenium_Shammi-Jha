package TestSelenium;

public class EH9 {

	public static void main(String[] args) {
		try {
			int a = 30 / 2;
			System.out.println(a);
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println("Finally block will always execute!");
		}
	}

}
