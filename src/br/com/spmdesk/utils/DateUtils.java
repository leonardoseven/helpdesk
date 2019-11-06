package br.com.spmdesk.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtils {

	public static String now() {
		Date data = new Date(System.currentTimeMillis());
		SimpleDateFormat formatarDate = new SimpleDateFormat("dd/MM/yyyy"); 
		return formatarDate.format(data);
	}
}
