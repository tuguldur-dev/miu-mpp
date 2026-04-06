package Lab6.prob1.rulesets;

import Lab6.prob1.gui.BookWindow;
import Lab6.prob1.gui.CDWindow;

import java.awt.Component;

/**
 * Rules:
 *  1. All fields must be nonempty 
 *  2. Price must be a floating point number with two decimal places 
 *  3. Price must be a number greater than 0.49. 
 */

public class CDRuleSet implements RuleSet {

	@Override
	public void applyRules(Component ob) throws RuleException {
		CDWindow cdWindow = (CDWindow) ob;

		String title = cdWindow.getTitleValue().trim();
		String priceStr = cdWindow.getPriceValue().trim();
		String artist = cdWindow.getArtistValue().trim();

		// Rule 1: all fields must be nonempty
		if (title.isEmpty() || artist.isEmpty() || priceStr.isEmpty()) {
			throw new RuleException("All fields must be nonempty.");
		}

		// Rule 2: price must be floating point with two decimal places
		if (!priceStr.matches("\\d+\\.\\d{2}")) {
			throw new RuleException("Price must be a floating point number with two decimal places.");
		}

		// Rule 3: price must be > 0.49
		double price;
		try {
			price = Double.parseDouble(priceStr);

			if (price <= 0.49) {
				throw new RuleException("Price must be greater than 0.49.");
			}
		} catch (NumberFormatException e){
			System.out.println(e.getMessage());
		}

	}
	
}
