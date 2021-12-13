package javapgm;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Sample {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
//		DateFormat format = new SimpleDateFormat();
//		int dayOfWeekInMonthField = format.DAY_OF_WEEK_IN_MONTH_FIELD;
//		System.out.println(dayOfWeekInMonthField);
		System.out.println(Calendar.getInstance().get(Calendar.YEAR)+1);
		System.out.println();
		Calendar c = Calendar.getInstance();
		//c.setTime(new Date());
		c.add(Calendar.DATE, 20);
		String date = new SimpleDateFormat("dd/MM/yyyy").format(c.getTime());
		System.out.println(date);

	}

}
