package com.mlzone.csuldw.common;

import io.jsonwebtoken.Claims;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.JwtBuilder;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.MalformedJwtException;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.SignatureException;
import io.jsonwebtoken.UnsupportedJwtException;

import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;

import org.apache.commons.codec.binary.Base64;
import org.apache.log4j.Logger;
import org.json.JSONObject;

public class OAuthTokenUtils {
	
	private Logger log = Logger.getLogger(OAuthTokenUtils.class);
	
	private String userId; 
	private String APP_ID = "MLZone";
	private String APP_SECRET = "zola";
	private String KEY_SING = ""; 	// 用于存放TOKEN的标志,Redis
	private LinkedHashMap<String, Object> pairs = new LinkedHashMap<>();
	public static final int MINUTE_TTL = 60 * 1000; // millisecond
	public static final int HOURS_TTL = 60 * 60 * 1000; // millisecond
	public static final int DAY_TTL = 12 * 60 * 60 * 1000; // millisecond

	private OAuthTokenUtils() {
	}

	private static OAuthTokenUtils single = null;

	public static OAuthTokenUtils getInstance() {
		if (single == null) {
			single = new OAuthTokenUtils();
		}
		return single;
	}

	public String getKEY_SING() {
		return KEY_SING;
	}

	public void setPairs(LinkedHashMap<String, Object> pairs) {
		this.pairs = pairs;
	}

	public LinkedHashMap<String, Object> getPairs() {
		return pairs;
	}

	public void put(String key, Object value) {// 向json中添加属性，在js中访问，请调用data.map.key
		pairs.put(key, value);
	}

	public void remove(String key) {
		pairs.remove(key);
	}

	public String generateInfo(){
		JSONObject jsonInfo = new JSONObject();
		jsonInfo.put("userId", userId);
		return jsonInfo.toString();
	}
	
	/**
	 * 總體封裝
	 * 
	 * @param appid
	 * @param secret
	 * @param logicInterface
	 *            回調函數
	 * @return
	 */
	public String token(String appid, String secret, String userId) {
		this.userId = userId;
		// 获取appid和secret
		this.accessPairs(appid, secret);
		Object subject = generateInfo();
		// 生成JWT签名数据ToKen
		String token = this.createToken(generalSubject(subject), 15 * MINUTE_TTL);
		return token;
	}

	public void accessPairs(String APP_ID, String APP_SECRET) {
		this.APP_ID = APP_ID;
		this.APP_SECRET = APP_SECRET;
		// this.KEY_SING = MD5Util.MD5Encode(APP_ID+"_"+APP_SECRET,
		// "UTF-8").toUpperCase();//要用到的时候才用
	}

	/**
	 * 由字符串生成加密key
	 * 
	 * @return
	 */
	public SecretKey generalKey() {
		String stringKey = APP_ID + APP_SECRET;
		byte[] encodedKey = Base64.encodeBase64(stringKey.getBytes());
		SecretKey key = new SecretKeySpec(encodedKey, 0, encodedKey.length,
				"AES");
		return key;
	}

	/**
	 * 生成subject信息
	 * 
	 * @param obj
	 * @return
	 */
	public static String generalSubject(Object obj) {
		if (obj != null) {
			JSONObject json = new JSONObject(obj.toString());
			return json.toString();
		} else {
			return "{}";
		}

	}

	/**
	 * 创建token
	 * 
	 * @param subject
	 * @param ttlMillis
	 * @return
	 * @throws Exception
	 */
	public String createToken(String subject, long ttlMillis) {

		SignatureAlgorithm signatureAlgorithm = SignatureAlgorithm.HS256;
		long nowMillis = System.currentTimeMillis();
		Date now = new Date(nowMillis);
		SecretKey key = generalKey();
		Map<String, Object> header = new HashMap<>();
		header.put("typ", "JWT");
		JwtBuilder builder = Jwts.builder().setId(APP_ID).setHeader(header)
				.setSubject(subject)
				// .claim("payload", header)
				.setIssuedAt(now).signWith(signatureAlgorithm, key);
		if (ttlMillis >= 0) {
			long expMillis = nowMillis + ttlMillis;
			Date exp = new Date(expMillis);
			builder.setExpiration(exp);
		}
		return builder.compact();
	}

	/**
	 * 解密token
	 *
	 * Author:liudiwei
	 * Date:2017年12月18日
	 * @param token
	 * @return
	 * @throws Exception
	 * @since
	 */
	public Map<String, Object> parseToken(String token) {
		Map<String, Object> result = new HashMap<>();
		try {
			Claims claims = Jwts.parser().setSigningKey(generalKey())
					.parseClaimsJws(token).getBody();
			result.put("data", claims.getSubject());
			result.put("code", 1000);
			result.put("msg", "success");
		} catch (Exception e) {
			log.info("解析token失败" + e.toString());
			result.put("code", 2001);
			result.put("msg", "解析token结果异常!");
		} 
//		System.out.println("ID: " + claims.getId());
//		System.out.println("Subject: " + claims.getSubject());
//		System.out.println("Issuer: " + claims.getIssuer());
//		System.out.println("Expiration: " + claims.getExpiration());
		return result;
	}

	public static void main(String[] args) {
		String userId = "123456";
		OAuthTokenUtils tokenUtils = OAuthTokenUtils.getInstance();
		String token = tokenUtils.token("MLZone", "zola", "123456");
		
		
		try {
			Map<String, Object> result = tokenUtils.parseToken(token);
			System.out.println(result.get("data"));
			JSONObject jsonObj = new JSONObject(result.get("data").toString());
			System.out.println(jsonObj.get("userId"));
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
