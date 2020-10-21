package TestSelenium;

public class EH6 {

	public static void main(String[] args) {
		try {
			int a[] = new int[5];
			a[10] = 50;
		} catch (Exception e) {
			e.printStackTrace();
		}
		System.out.println("Exception Handled");
	}

}
