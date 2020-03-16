/**
 * 
 */
package com.labbol.api.support.sign;

/**
 * @author PengFei
 * @date 2020年3月10日上午10:26:31
 * @since 1.0
 */
public class SignUtils {

	public static String byteArrayToHex(byte []bytes) {
		//字符数组，用来存放十六进制字符
		char[] hexReferChars = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
		//一个字节占8位 ，一个十六进制字符占4位；十六进制字符数组的长度为字节数组长度的两倍
		char[] hexChars = new char[bytes.length * 2];
		int index = 0;
		for(byte b : bytes){
			//取字节高的4位     
			hexChars[index++] = hexReferChars[b >>> 4 & 0xf];
			//取字节低四位
			hexChars[index++] = hexReferChars[b & 0xf];
		}
		return new String(hexChars);
	}
	
}
