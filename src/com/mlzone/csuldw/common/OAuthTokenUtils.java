package com.mlzone.csuldw.common;

import io.jsonwebtoken.*;
import org.apache.commons.codec.binary.Base64;
import org.json.JSONObject;

import com.thoughtworks.xstream.io.binary.Token;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import javax.crypto.SecretKey;
import javax.crypto.spec.SecretKeySpec;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletResponse;
import javax.xml.bind.DatatypeConverter;
import java.util.Date;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;
 
 
public class OAuthTokenUtils {
    private String APP_ID = "MLZone1";
    private String APP_SECRET = "zola2";
    private String KEY_SING =  ""; //用於存放TOKEN的標誌,Redis
    private LinkedHashMap<String, Object> pairs = new LinkedHashMap<>();
    public static final int MINUTE_TTL = 60*1000;  //millisecond
    public static final int HOURS_TTL = 60*60*1000;  //millisecond
    public static final int DAY_TTL = 12*60*60*1000;  //millisecond
 
 
    String header = "{ \"typ\": \"JWT11\", \"typ12\": \"JWT11\",	\"alg\": \"HS256\"}";
 
    private OAuthTokenUtils() {}
    private static OAuthTokenUtils single=null;
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
 
    public void put(String key, Object value){//向json中添加属性，在js中访问，请调用data.map.key
        pairs.put(key, value);
    }
 
    public void remove(String key){
        pairs.remove(key);
    }
 
    /**
     * 總體封裝
     * @param appid
     * @param secret
     * @param logicInterface 回調函數
     * @return
     */
    public String token(String appid, String secret, String content){
        //获取appid和secret
        this.accessPairs(appid, secret);
        Object subject = content;
        //生成JWT签名数据ToKen
        String token = this.createToken(this.generalSubject(subject), this.MINUTE_TTL);
        return token;
    }
 
    public void accessPairs(String APP_ID, String APP_SECRET) {
        this.APP_ID = APP_ID;
        this.APP_SECRET = APP_SECRET;
//        this.KEY_SING = MD5Util.MD5Encode(APP_ID+"_"+APP_SECRET, "UTF-8").toUpperCase();//要用到的时候才用
    }
 
    /**
     * 由字符串生成加密key
     * @return
     */
    public SecretKey generalKey(){
        String stringKey = APP_ID + APP_SECRET;
        byte[] encodedKey = Base64.encodeBase64(stringKey.getBytes());
        SecretKey key = new SecretKeySpec(encodedKey, 0, encodedKey.length, "AES");
        return key;
    }
    /**
     * 生成subject信息
     * @param obj
     * @return
     */
    public static String generalSubject(Object obj){
        if(obj != null ) {
            JSONObject json = new JSONObject(obj.toString());
            return json.toString();
        }else{
            return "{}";
        }
 
    }
 
    /**
     * 创建token
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
        Map<String, Object> header1 = new HashMap<>();
        header1.put("typ", "JWT");
        JwtBuilder builder = Jwts.builder()
                .setId(APP_ID)
                .setHeader(header1)
                .setSubject(subject)
//                .claim("payload", header)
                .setIssuedAt(now)
                .signWith(signatureAlgorithm, key);
        if (ttlMillis >= 0) {
            long expMillis = nowMillis + ttlMillis;
            Date exp = new Date(expMillis);
            builder.setExpiration(exp);
        }
        return builder.compact();
    }
 
    /**
     * 解密token
     * @param token
     * @return
     * @throws Exception
     */
    public Claims parseToken(String token) throws Exception{
        Claims claims = Jwts.parser()
                .setSigningKey(generalKey())
                .parseClaimsJws(token).getBody();
        System.out.println("ID: " + claims.getId());
        System.out.println("Subject: " + claims.getSubject());
        System.out.println("Issuer: " + claims.getIssuer());
        System.out.println("Expiration: " + claims.getExpiration());
        return claims;
    }
 //eyJhbGciOiJIUzI1NiJ9
    public static void main(String[] args)
	{
    	OAuthTokenUtils tokenUtils = OAuthTokenUtils.getInstance();
    	String token = tokenUtils.token("MLZone", "zola", tokenUtils.header);
    	System.out.println(token);
    	try
		{
			tokenUtils.parseToken(token);
		} catch (Exception e)
		{
			e.printStackTrace();
		}
	}
 
    //eyJhbGciOiJIUzI1NiJ9.
    //eyJqdGkiOiJNTFpvbmUiLCJpYXQiOjE1MTM1ODQ3NjEsInN1YiI6IntcImFsZ1wiOlwiSFMyNTZcIixcInR5cFwiOlwiSldUXCJ9IiwiZXhwIjoxNTEzNTg0ODIxfQ.
    //NijJLNe8_rLOf_OfxflvIcVdQV_ZlPwqwzobnI6LlCw

}
