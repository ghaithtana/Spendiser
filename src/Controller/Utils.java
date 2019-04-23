package Controller;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utils {
	private static final String dateFormat = "yyyy-mm-dd";

	public static Date stringToDate(String date) {
		try {
			return new SimpleDateFormat(dateFormat).parse(date);
		} catch (ParseException e) {
			e.printStackTrace();
			return null;
		}
	}

	public static String dateToString(Date date) {
		DateFormat df = new SimpleDateFormat(dateFormat);
		return df.format(date);
	}

}
