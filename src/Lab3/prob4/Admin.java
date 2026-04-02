package Lab3.prob4;

public class Admin {
	public static double computeTotalRent(Object[] properties) {
		double totalRent = 0;
		for (Object o : properties) {
			if (o instanceof Property) {
				totalRent += ((Property) o).computeRent();
			}
		}
		return totalRent;
	}
}
