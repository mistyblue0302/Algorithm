import java.util.Scanner;

public class Main {
	@SuppressWarnings("resource")
	public static void main(String args[]) {
		double bar = 64;
		double x = new Scanner(System.in).nextDouble();

		int w = 0;
		while (x > 0) {
			if (bar > x)
				bar /= 2;
			else {
				x -= bar;
				w++;
			}
		}
		System.out.println(w);
	}
}
