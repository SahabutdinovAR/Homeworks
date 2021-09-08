import java.util.Scanner;

class Program {
	public static double f(double x) {
		return x * x;
	}

	public static double calcIntegralByRectangles(double a, double b, int n) {
		double h = (b - a) / n;

		double sum = 0;

		for (double x = a; x <= b; x += h) {
			double height = f(x);
			double width = h;
			double rectangleArea = height * width;

			sum += rectangleArea;
		}

		return sum;
	}

	public static void calcTableForIntegral(double a, double b, int ns[], double ys[]) {
		for (int i = 0; i < ns.length; i++) {
			ys[i] = calcIntegralByRectangles(a, b, ns[i]);
		}
	}

	public static void main(String args[]) {
		double REAL_VALUE = 333333.3333333333333;
		int ns[] = {100, 1_000, 10_000, 100_000, 500_000, 1_000_000, 10_000_000, 100_000_000};
		double ys[] = new double[ns.length];

		Scanner scanner = new Scanner(System.in);
		double a = scanner.nextDouble();
		double b = scanner.nextDouble();

		calcTableForIntegral(a, b, ns, ys);

		System.out.printf("%15s|%16s|%17s|\n", "N", "I", "EPS");
		for (int i = 0; i < ns.length; i++) {
			System.out.printf("%15d|%6.9f|%5.5f\n", ns[i], ys[i], REAL_VALUE - ys[i]);
		}
	}
}