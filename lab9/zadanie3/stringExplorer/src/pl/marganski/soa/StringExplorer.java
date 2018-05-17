package pl.marganski.soa;

import javax.jws.WebMethod;
import javax.jws.WebService;

@WebService
public class StringExplorer implements StringExplorerInterface {

	@Override
	@WebMethod
	public String exlopre(String entry) {
		char[] ch = entry.toCharArray();
		int characters = entry.length();
		int upperCases = 0;
		int lowerCases = 0;
		int whiteSpaces = 0;
		int digits = 0;
		int other = 0;
		for (int i = 0; i < entry.length(); i++) {
			if (Character.isUpperCase(ch[i])) {
				upperCases++;
			} else if (Character.isLowerCase(ch[i])) {
				lowerCases++;
			} else if (Character.isDigit(ch[i])) {
				digits++;
			} else if (Character.isWhitespace(ch[i])) {
				whiteSpaces++;
			} else {
				other++;
			}
		}

		String statement = entry + "\n\nStats of entry string:"
				+ "\ncharacter amount: " + characters
				+ "\nuppercases: " + upperCases
				+ "\nlowercases: " + lowerCases 
				+ "\nwhitespaces: " + whiteSpaces 
				+ "\ndigits: " + digits
				+ "\nothers: " + other;
		System.out.println(statement);
		return statement;
	}
}
