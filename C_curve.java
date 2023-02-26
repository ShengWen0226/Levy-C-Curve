import java.util.ArrayList;

public class C_curve {

	static ArrayList<Double> xPoint = new ArrayList<>();
	static ArrayList<Double> yPoint = new ArrayList<>();

	public static void main(String[] args) {
		double length = 10000;
		int iteration = 12, n = 1;
		xPoint.add(0.0);
		yPoint.add(0.0);
		xPoint.add(length);
		yPoint.add(0.0);
		c_curve(iteration, n);
		printPoint();
	}

	public static void c_curve(int iteration, int n) {
		if (iteration == 1)
			return;
		for (int i = 1; i <= n * 2; i += 2) {
			double x = (xPoint.get(i - 1) + xPoint.get(i)) / 2 + (yPoint.get(i - 1) - yPoint.get(i)) / 2;
			double y = (yPoint.get(i - 1) + yPoint.get(i)) / 2 + (xPoint.get(i) - xPoint.get(i - 1)) / 2;
			xPoint.add(i, x);
			yPoint.add(i, y);
		}
		c_curve(iteration - 1, n * 2);
	}

	public static void printPoint() {
		for (int i = 0; i < xPoint.size(); i++)
			System.out.println(xPoint.get(i) + "," + yPoint.get(i));
	}

}
