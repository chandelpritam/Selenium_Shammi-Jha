package TestSelenium;

import java.io.FileNotFoundException;

public class EH1 {

	public static void main(String[] args) {
		try {
			int data = 50 / 0;
		} catch (ArithmeticException e) {
			System.out.println(e);
			e.printStackTrace();
		} catch (NullPointerException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}
		try {
			int a = 10 / 0;
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			System.out.println("Finally will always exeute");
		}

	}

}
