package jp.co.yahoo.tetsufuru1968.hackathon.common;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Utility {
	// 日付変換用フォーマット
	private static final String FORMAT_DATE =  "yyyy/MM/dd";
	private static final String FORMAT_DATE_TIME =  "yyyy/MM/dd HH:mm:ss";


	public static Date convertToDateFromStr(String originalDate) throws ParseException {

		return convertFromStr(originalDate,FORMAT_DATE);
	}

	public static Date convertToDateTimeFromStr(String originalDate) throws ParseException {

		return convertFromStr(originalDate,FORMAT_DATE_TIME);
	}

	private static Date convertFromStr(String originalDate,String format) throws ParseException {

		// Stringからjava.util.Dateへの変換
		DateFormat foramt = new SimpleDateFormat(format);
		Date date = foramt.parse(originalDate);

		return date;
	}




}
