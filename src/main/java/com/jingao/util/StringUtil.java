package com.jingao.util;

public class StringUtil {
	public static String firstToUp(String source) {
		try {
			String s = source.substring(0, 1).toUpperCase() + source.substring(1, source.length());
			return s;
		} catch (Exception e) {
			e.printStackTrace();
			System.err.println("source=" + source);
		}
		return null;
	}

	public static boolean isEmpty(Object o) {
		if (o == null) {
			return true;
		}
		if (o instanceof String && o.equals("null")) {
			return true;
		}
		return false;
	}

	public static boolean isStringEmtpy(String o) {
		if (o == null) {
			return true;
		}
		if (o.equals("null")) {
			return true;
		}
		if (o.equals("")) {
			return true;
		}
		return false;

	}

	public static String tohtml(String html) {
		html = html.replaceAll("&amp;", "&");
		html = html.replace("&quot;", "\""); // "
		html = html.replace("&nbsp;&nbsp;", "\t");// 替换跳格
		html = html.replace("&nbsp;", " ");// 替换空格
		html = html.replace("&lt;", "<");
		html = html.replaceAll("&gt;", ">");
		return html;
	}

	public static String asciiToNative(String asciicode) {
		if (asciicode == null) {
			return asciicode;
		}
		String[] asciis = asciicode.split("\\\\u");
		String nativeValue = asciis[0];
		try {
			for (int i = 1; i < asciis.length; i++) {
				String code = asciis[i];
				nativeValue += (char) Integer.parseInt(code.substring(0, 4), 16);
				if (code.length() > 4) {
					nativeValue += code.substring(4, code.length());
				}
			}
		} catch (NumberFormatException e) {
			return asciicode;
		}
		return nativeValue;
	}

}
