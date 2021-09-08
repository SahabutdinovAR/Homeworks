class Program9 {
	public static void main(String[] args) {
		int a[] = {1, 2, 3, 4, 5}; // a -> pointer on a[0] ~ 120
		int b[];

		b = a; // b ~ 120, a ~ 120

		b[2] = 777;

		System.out.println(a[2]);

	}
}