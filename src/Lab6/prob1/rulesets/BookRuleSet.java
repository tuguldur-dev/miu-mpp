package Lab6.prob1.rulesets;

import Lab6.prob1.gui.BookWindow;

import java.awt.Component;


/**
 * Rules:
 * 1. All fields must be nonempty
 * 2. Isbn must be numeric and consist of either 10 or 13 characters
 * 3. If Isbn has length 10, the first digit must be 0 or 1
 * 4. If Isbn has length 13, the first 3 digits must be either 978 or 979
 * 5. Price must be a floating point number with two decimal places
 * 6. Price must be a number greater than 0.49.
 *
 */
public class BookRuleSet implements RuleSet {

    @Override
    public void applyRules(Component ob) throws RuleException {
        BookWindow bookWindow = (BookWindow) ob;

        String isbn = bookWindow.getIsbnValue().trim();
        String title = bookWindow.getTitleValue().trim();
        String priceStr = bookWindow.getPriceValue().trim();

        // Rule 1: all fields must be nonempty
        if (isbn.isEmpty() || title.isEmpty() || priceStr.isEmpty()) {
            throw new RuleException("All fields must be nonempty.");
        }

        // Rule 2: isbn must be numeric and length 10 or 13
        if (!isbn.matches("\\d+")) {
            throw new RuleException("ISBN must be numeric.");
        }

        if (isbn.length() != 10 && isbn.length() != 13) {
            throw new RuleException("ISBN must consist of either 10 or 13 digits.");
        }

        // Rule 3: if length 10, first digit must be 0 or 1
        if (isbn.length() == 10) {
            char firstChar = isbn.charAt(0);
            if (firstChar != '0' && firstChar != '1') {
                throw new RuleException("A 10-digit ISBN must start with 0 or 1.");
            }
        }

        // Rule 4: if length 13, first 3 digits must be 978 or 979
        if (isbn.length() == 13) {
            String prefix = isbn.substring(0, 3);
            if (!prefix.equals("978") && !prefix.equals("979")) {
                throw new RuleException("A 13-digit ISBN must start with 978 or 979.");
            }
        }

        // Rule 5: price must be floating point with two decimal places
        if (!priceStr.matches("\\d+\\.\\d{2}")) {
            throw new RuleException("Price must be a floating point number with two decimal places.");
        }

        // Rule 6: price must be > 0.49
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
