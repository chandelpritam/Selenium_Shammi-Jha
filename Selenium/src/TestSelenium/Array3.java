package TestSelenium;

public class Array3 {
	// creating a method which receives an array as a parameter
	public static void min(int arr[]) {
		int min = arr[0];
		for (int i = 0; i < arr.length; i++) {
			if (min > arr[i]) {
				System.out.println(min);
			}
		}

	}

	public static void main(String[] args) {
		int a[] = { 33, 3, 4, 5 };
		min(a);
	}

}
