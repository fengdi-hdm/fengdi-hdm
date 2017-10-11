package com.jingao.util;

import java.math.BigInteger;
import java.security.MessageDigest;

import com.jingao.Log.LogUtil;

public class MD5 {
	public static String getMD5(String s) {
		try {
			char hexDigits[] = { '0', '1', '2', '3', '4', '5', '6', '7', '8', '9', 'A', 'B', 'C', 'D', 'E', 'F' };
			byte[] btInput = s.getBytes();
			// 生成一个MD5加密计算摘要
			MessageDigest mdInst = MessageDigest.getInstance("MD5");
			// 计算md5函数
			mdInst.update(btInput);
			byte[] md = mdInst.digest();
			// 把密文转换成十六进制的字符串形式
			int j = md.length;
			char str[] = new char[j * 2];
			int k = 0;
			for (int i = 0; i < j; i++) {
				byte byte0 = md[i];
				str[k++] = hexDigits[byte0 >>> 4 & 0xf];
				str[k++] = hexDigits[byte0 & 0xf];
			}
			return new String(str).toLowerCase();
		} catch (Exception e) {
			LogUtil.log.error(e.getMessage(), e);
		}
		return null;
	}

	public static void main(String[] args) {
		try {
			System.err.println(getMD5(
					"edition=NX535J_CNCommon_V1.26merge_count=0model=Z11Max经典版 (NX535J)module=桌面rom_version=1same_experience=0submodule=桌面thread_id=77777thread_url=bbsui.server.ztemt.com.cn/thread-88888-1-1.htmltitle=yycreate_time=2017-07-26 16:20:59PrivateKeyStr"));
			
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
