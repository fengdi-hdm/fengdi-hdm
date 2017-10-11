package com.jingao.util;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class DateUtil {
	public static final String format1 = "yyyy-MM-dd";
	public static final String format2 = "yyyy-MM-dd HH:mm:ss";
	public static final String format3 = "YYYY-MM-dd'T'HH:mm:ss.sssZ";//ISO 8601
	public static final String format4  = "dd/七月/yy hh:mm 上午";
	
	/**
	 * ��ʽ������ÿ�δ���һ���µĸ�ʽ������ȷ�����԰�ȫ
	 * @param format
	 * @param date
	 * @return
	 */
	public static String formatDate(String format,Date date){
		DateFormat df = new SimpleDateFormat(format);
		return df.format(date);
	}
	
	
	/**
	 * 
	 * @param arg0
	 * @throws ParseException 
	 */
	public static long dateToLong(String dateStr) {
		DateFormat df = new SimpleDateFormat(DateUtil.format2);
		Date date = new Date();
		try {
			date = df.parse(dateStr);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return date.getTime();
	}
	
	/**
	 * �Ƚ����ڴ�С
	 * @param date1
	 * @param date2
	 * @return
	 */
	public static boolean compareDate(String date1,String date2){
		long a = DateUtil.dateToLong(date1);
		long b = DateUtil.dateToLong(date2);
		return a>b;
	}
	
	public static String forWardDate(String date,long time){
		Date newDate = new Date(dateToLong(date)-time);
		return formatDate(DateUtil.format2,newDate);
	}
	
	@SuppressWarnings("deprecation")
	public static void main(String[] arg0){
		Date date = new Date(dateToLong("2017-07-20 11:14:00"));
		
		System.err.println(DateUtil.formatDate(DateUtil.format3, date));
	}
	
	
}
