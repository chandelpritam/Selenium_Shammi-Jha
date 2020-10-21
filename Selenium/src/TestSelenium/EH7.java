package TestSelenium;

public class EH7 {

	public static void main(String[] args) {
		try {
			int a[] = new int[7];
			a[7] = 10 / 0;
		} catch (Exception e) {
			System.out.println(e);
		}
		System.out.println("Exception get Handled");
	}

}
