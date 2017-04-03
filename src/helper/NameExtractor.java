package helper;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class NameExtractor {

	public static String extractCategoryName(String name) {
		String regex = ".{8}_";
		Pattern p = Pattern.compile(regex);
		Matcher m = p.matcher(name);
		if (m.find()) {
			name = m.replaceFirst("");
		}
		return name;
	}
}
