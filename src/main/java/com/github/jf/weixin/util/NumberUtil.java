package com.github.jf.weixin.util;

/**
 * 数字化工具<br>
 * @author henrybit
 * @since 2.0
 * @version 2.0
 */
public class NumberUtil {
	
	/**
	 * 字符串转整型<br>
	 * @param str 字符串
	 * @return int-转化结果
	 */
	public static int stringToint(String str) {
		try {
			return Integer.parseInt(str);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
	
	/**
	 * 对象转整型<br>
	 * @param obj 对象
	 * @return int-转化结果
	 */
	public static int objToint(Object obj) {
		try {
			return stringToint((String)obj);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
	
	/**
	 * 字符串转整型对象<br>
	 * @param str 字符串
	 * @return Integer-转化结果
	 */
	public static Integer stringToInteger(String str) {
		try {
			return Integer.valueOf(str);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 字符串转长整型<br>
	 * @param str 字符串
	 * @return long-转化结果
	 */
	public static long stringTolong(String str) {
		try {
			return Long.parseLong(str);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
	
	/**
	 * 对象转长整型<br>
	 * @param obj 待转化对象
	 * @return long-转化结果
	 */
	public static long objTolong(Object obj) {
		try {
			return stringTolong((String)obj);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
	
	/**
	 * 字符串转长整型对象<br>
	 * @param str 字符串
	 * @return Long-转化结果
	 */
	public static Long stringToLong(String str) {
		try {
			return Long.valueOf(str);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 字符串转浮点型<br>
	 * @param str 字符串
	 * @return float-转化结果
	 */
	public static float stringTofloat(String str) {
		try {
			return Float.parseFloat(str);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return -1.0f;
	}
	
	/**
	 * 对象转浮点型<br>
	 * @param obj 待转化对象
	 * @return float-转化结果
	 */
	public static float objTofloat(Object obj) {
		try {
			return stringTofloat((String)obj);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1.0f;
	}
	
	/**
	 * 字符串转浮点对象<br>
	 * @param str 字符串
	 * @return Float-转化结果
	 */
	public static Float stringToFloat(String str) {
		try {
			return Float.valueOf(str);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 字符串转双精度型<br>
	 * @param str 字符串
	 * @return double-转化结果
	 */
	public static double stringTodouble(String str) {
		try {
			return Double.parseDouble(str);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return -1.0d;
	}
	
	/**
	 * 对象转双精度型<br>
	 * @param obj 待转换对象
	 * @return double-转换结果
	 */
	public static double objTodouble(Object obj) {
		try {
			return stringTodouble((String)obj);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return -1.0d;
	}
	
	/**
	 * 字符串转双精度对象<br>
	 * @param str 字符串
	 * @return Double-转化结果
	 */
	public static Double stringToDouble(String str) {
		try {
			return Double.valueOf(str);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	/**
	 * 字符串转短整型<br>
	 * @param str 字符串
	 * @return short-转化结果
	 */
	public static short stringToshort(String str) {
		try {
			return Short.parseShort(str);
		} catch(Exception e) {
			e.printStackTrace();
		}
		return -1;
	}
	
	/**
	 * 字符串转短整型对象<br>
	 * @param str 字符串
	 * @return Short-转化结果
	 */
	public static Short stringToShort(String str) {
		try {
			return Short.valueOf(str);
		} catch (Exception e) {
			e.printStackTrace();
		}
		return null;
	}
	
	
}
