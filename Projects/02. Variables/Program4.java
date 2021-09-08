class Program4 {
	public static void main(String[] args) {
		double x = 5;
		double y = 2;
		double z = x / 2;
		int a = (int)z; // почему java сама не может преобразовать, отбросив остаток?
		System.out.println(a); 
	}
}