package TestSelenium;

public class EH3 {

	public static void main(String[] args) {
		try {
			int c = 5 / 0;
		} catch (ArithmeticException e) {
			e.printStackTrace();
		} catch (ArrayIndexOutOfBoundsException e) {
			System.out.println(e);
		} catch (NullPointerException e) {
			System.out.println(e);
		} catch (Exception e) {
			System.out.println(e);
		}
		System.out.println("Exception get Handled");
	}

}
