/**
 * 
 */
package com.labbol.api.support.sign;

import java.io.IOException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

import org.yelong.http.exception.HttpException;
import org.yelong.http.request.HttpRequest;

import com.labbol.api.support.exception.APIException;

/**
 * @author PengFei
 * @date 2020年3月10日上午10:26:11
 * @since 1.0
 */
@Deprecated
public class MD5APIRequestSign extends AbstractAPIRequestSign implements APIRequestSign{

	private static final String MD5 = "MD5";
	
	@Override
	public String generateSign(HttpRequest httpRequest) throws APIException, HttpException, IOException ,NoSuchAlgorithmException {
		return encryptMap(getSignRequestParams(httpRequest));
	}

	private static String encryptMap(Map<String, String> map) throws NoSuchAlgorithmException {
		String md5Str = null;
		StringBuffer encryptStr = new StringBuffer();
		if(!map.isEmpty()) {
			for(String key : map.keySet()) {
				encryptStr.append(map.get(key));
			}
			MessageDigest md = MessageDigest.getInstance(MD5);
			//使用指定byte[]更新摘要
			md.update(encryptStr.toString().getBytes());
			//完成计算，返回指定结果数组
			byte[] b = md.digest();
			md5Str = SignUtils.byteArrayToHex(b);
		}
		return md5Str;
	}
	
}
