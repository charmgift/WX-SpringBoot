package com.wang.wei.utils;

import java.sql.Timestamp;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

import lombok.extern.slf4j.Slf4j;

@Slf4j
public class DateUtils {

	/** 骞�-鏈�-鏃� 鏃�:鍒�:绉� 鏄剧ず鏍煎紡 */
	// 澶囨敞:濡傛灉浣跨敤澶у啓HH鏍囪瘑浣跨敤24灏忔椂鏄剧ず鏍煎紡,濡傛灉浣跨敤灏忓啓hh灏辫〃绀轰娇鐢�12灏忔椂鍒舵牸寮忋��
	public static String DATE_TO_STRING_DETAIAL_PATTERN = "yyyy-MM-dd HH:mm:ss";

	/** 骞�-鏈�-鏃� 鏄剧ず鏍煎紡 */
	public static String DATE_TO_STRING_SHORT_PATTERN = "yyyy-MM-dd";

	private static SimpleDateFormat simpleDateFormat;

	/**
	 * Date绫诲瀷杞负鎸囧畾鏍煎紡鐨凷tring绫诲瀷
	 * 
	 * @param source
	 * @param pattern
	 * @return
	 */
	public static String DateToString(Date source, String pattern) {
		simpleDateFormat = new SimpleDateFormat(pattern);
		return simpleDateFormat.format(source);
	}

	/**
	 * 
	 * unix鏃堕棿鎴宠浆涓烘寚瀹氭牸寮忕殑String绫诲瀷
	 * 
	 * 
	 * System.currentTimeMillis()鑾峰緱鐨勬槸鏄粠1970骞�1鏈�1鏃ュ紑濮嬫墍缁忚繃鐨勬绉掓暟
	 * unix鏃堕棿鎴�:鏄粠1970骞�1鏈�1鏃ワ紙UTC/GMT鐨勫崍澶滐級寮�濮嬫墍缁忚繃鐨勭鏁�,涓嶈�冭檻闂扮
	 * 
	 * @param source
	 * @param pattern
	 * @return
	 */
	public static String timeStampToString(long source, String pattern) {
		simpleDateFormat = new SimpleDateFormat(pattern);
		Date date = new Date(source * 1000);
		return simpleDateFormat.format(date);
	}

	/**
	 * 灏嗘棩鏈熻浆鎹负鏃堕棿鎴�(unix鏃堕棿鎴�,鍗曚綅绉�)
	 * 
	 * @param date
	 * @return
	 */
	public static long dateToTimeStamp(Date date) {
		Timestamp timestamp = new Timestamp(date.getTime());
		return timestamp.getTime() / 1000;

	}

	/**
	 * 
	 * 瀛楃涓茶浆鎹负瀵瑰簲鏃ユ湡(鍙兘浼氭姤閿欏紓甯�)
	 * 
	 * @param source
	 * @param pattern
	 * @return
	 */
	public static Date stringToDate(String source, String pattern) {
		simpleDateFormat = new SimpleDateFormat(pattern);
		Date date = null;
		try {
			date = simpleDateFormat.parse(source);
		} catch (ParseException e) {
			log.error("瀛楃涓茶浆鎹㈡棩鏈熷紓甯�", e);
		}
		return date;
	}

	/**
	 * 鑾峰緱褰撳墠鏃堕棿瀵瑰簲鐨勬寚瀹氭牸寮�
	 * 
	 * @param pattern
	 * @return
	 */
	public static String currentFormatDate(String pattern) {
		simpleDateFormat = new SimpleDateFormat(pattern);
		return simpleDateFormat.format(new Date());

	}

	/**
	 * 鑾峰緱褰撳墠unix鏃堕棿鎴�(鍗曚綅绉�)
	 * 
	 * @return 褰撳墠unix鏃堕棿鎴�
	 */
	public static long currentTimeStamp() {
		return System.currentTimeMillis() / 1000;
	}

	/**
	 * 
	 * @methodDesc: 鍔熻兘鎻忚堪:(鑾峰彇褰撳墠绯荤粺鏃堕棿鎴�)
	 * @param: @return
	 */
	public static Timestamp getTimestamp() {
		return new Timestamp(new Date().getTime());
	}
}
// 寰呰ˉ鍏�
