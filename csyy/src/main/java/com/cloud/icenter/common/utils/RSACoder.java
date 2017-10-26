package com.cloud.icenter.common.utils;

import java.security.Key;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.Signature;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.PKCS8EncodedKeySpec;
import java.security.spec.X509EncodedKeySpec;
import java.util.HashMap;
import java.util.Map;

import javax.crypto.Cipher;

import sun.misc.BASE64Decoder;
import sun.misc.BASE64Encoder;

/**  
 * Copyright (C) 2012 软通动力
 * 文件名: RSACode.java
 * 包路径: com.iss.common.util
 * 创建描述  
 *        创建人：zhaohy
 *        创建日期：2015-6-12 上午9:18:01
 *        内容描述：
 * 修改描述  
 *        修改人：zhaohy 
 *        修改日期：2015-6-12 上午9:18:01 
 *        修改内容:
 * 版本: V1.0   
 */
public class RSACoder {

	public static final String KEY_ALGORITHM = "RSA";  
    public static final String SIGNATURE_ALGORITHM = "MD5withRSA";  
  
    private static final String PUBLIC_KEY = "RSAPublicKey!@#";  
    private static final String PRIVATE_KEY = "RSAPrivateKeyZXS!*&";  
  
    /** 
     * 用私钥对信息生成数字签名 
     *  
     * @param data 
     *            加密数据 
     * @param privateKey 
     *            私钥 
     *  
     * @return 
     * @throws Exception 
     */  
    public static String sign(byte[] data, String privateKey) throws Exception {  
        // 解密由base64编码的私钥  
        byte[] keyBytes = decryptBASE64(privateKey);  
  
        // 构造PKCS8EncodedKeySpec对象  
        PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(keyBytes);  
  
        // KEY_ALGORITHM 指定的加密算法  
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);  
  
        // 取私钥匙对象  
        PrivateKey priKey = keyFactory.generatePrivate(pkcs8KeySpec);  
  
        // 用私钥对信息生成数字签名  
        Signature signature = Signature.getInstance(SIGNATURE_ALGORITHM);  
        signature.initSign(priKey);  
        signature.update(data);  
  
        return encryptBASE64(signature.sign());  
    }  
  
    /** 
     * 校验数字签名 
     *  
     * @param data 
     *            加密数据 
     * @param publicKey 
     *            公钥 
     * @param sign 
     *            数字签名 
     *  
     * @return 校验成功返回true 失败返回false 
     * @throws Exception 
     *  
     */  
    public static boolean verify(byte[] data, String publicKey, String sign)  
            throws Exception {  
  
        // 解密由base64编码的公钥  
        byte[] keyBytes = decryptBASE64(publicKey);  
  
        // 构造X509EncodedKeySpec对象  
        X509EncodedKeySpec keySpec = new X509EncodedKeySpec(keyBytes);  
  
        // KEY_ALGORITHM 指定的加密算法  
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);  
  
        // 取公钥匙对象  
        PublicKey pubKey = keyFactory.generatePublic(keySpec);  
  
        Signature signature = Signature.getInstance(SIGNATURE_ALGORITHM);  
        signature.initVerify(pubKey);  
        signature.update(data);  
  
        // 验证签名是否正常  
        return signature.verify(decryptBASE64(sign));  
    }  
  
    /** 
     * 解密<br> 
     * 用私钥解密 
     *  
     * @param data 
     * @param key 
     * @return 
     * @throws Exception 
     */  
    public static byte[] decryptByPrivateKey(byte[] data, String key)  
            throws Exception {  
        // 对密钥解密  
        byte[] keyBytes = decryptBASE64(key);  
  
        // 取得私钥  
        PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(keyBytes);  
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);  
        Key privateKey = keyFactory.generatePrivate(pkcs8KeySpec);  
  
        // 对数据解密  
        Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());  
        cipher.init(Cipher.DECRYPT_MODE, privateKey);  
  
        return cipher.doFinal(data);  
    }  
  
    /** 
     * 解密<br> 
     * 用公钥解密 
     *  
     * @param data 
     * @param key 
     * @return 
     * @throws Exception 
     */  
    public static byte[] decryptByPublicKey(byte[] data, String key)  
            throws Exception {  
        // 对密钥解密  
        byte[] keyBytes = decryptBASE64(key);  
  
        // 取得公钥  
        X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(keyBytes);  
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);  
        Key publicKey = keyFactory.generatePublic(x509KeySpec);  
  
        // 对数据解密  
        Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());  
        cipher.init(Cipher.DECRYPT_MODE, publicKey);  
  
        return cipher.doFinal(data);  
    }  
  
    /** 
     * 加密<br> 
     * 用公钥加密 
     *  
     * @param data 
     * @param key 
     * @return 
     * @throws Exception 
     */  
    public static byte[] encryptByPublicKey(byte[] data, String key)  
            throws Exception {  
        // 对公钥解密  
        byte[] keyBytes = decryptBASE64(key);  
  
        // 取得公钥  
        X509EncodedKeySpec x509KeySpec = new X509EncodedKeySpec(keyBytes);  
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);  
        Key publicKey = keyFactory.generatePublic(x509KeySpec);  
  
        // 对数据加密  
        Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());  
        cipher.init(Cipher.ENCRYPT_MODE, publicKey);  
  
        return cipher.doFinal(data);  
    }  
  
    /** 
     * 加密<br> 
     * 用私钥加密 
     *  
     * @param data 
     * @param key 
     * @return 
     * @throws Exception 
     */  
    public static byte[] encryptByPrivateKey(byte[] data, String key)  
            throws Exception {  
        // 对密钥解密  
        byte[] keyBytes = decryptBASE64(key);  
  
        // 取得私钥  
        PKCS8EncodedKeySpec pkcs8KeySpec = new PKCS8EncodedKeySpec(keyBytes);  
        KeyFactory keyFactory = KeyFactory.getInstance(KEY_ALGORITHM);  
        Key privateKey = keyFactory.generatePrivate(pkcs8KeySpec);  
  
        // 对数据加密  
        Cipher cipher = Cipher.getInstance(keyFactory.getAlgorithm());  
        cipher.init(Cipher.ENCRYPT_MODE, privateKey);  
  
        return cipher.doFinal(data);  
    }  
  
    /** 
     * 取得私钥 
     *  
     * @param keyMap 
     * @return 
     * @throws Exception 
     */  
    public static String getPrivateKey(Map<String, Object> keyMap)  
            throws Exception {  
        Key key = (Key) keyMap.get(PRIVATE_KEY);  
  
        return encryptBASE64(key.getEncoded());  
    }  
  
    /** 
     * 取得公钥 
     *  
     * @param keyMap 
     * @return 
     * @throws Exception 
     */  
    public static String getPublicKey(Map<String, Object> keyMap)  
            throws Exception {  
        Key key = (Key) keyMap.get(PUBLIC_KEY);  
  
        return encryptBASE64(key.getEncoded());  
    }  
  
    /** 
     * 初始化密钥 
     *  
     * @return 
     * @throws Exception 
     */  
    public static Map<String, Object> initKey() throws Exception {  
        KeyPairGenerator keyPairGen = KeyPairGenerator  
                .getInstance(KEY_ALGORITHM);  
        keyPairGen.initialize(1024);  
  
        KeyPair keyPair = keyPairGen.generateKeyPair();  
  
        // 公钥  
        RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();  
  
        // 私钥  
        RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();  
  
        Map<String, Object> keyMap = new HashMap<String, Object>(2);  
  
        keyMap.put(PUBLIC_KEY, publicKey);  
        keyMap.put(PRIVATE_KEY, privateKey);
        return keyMap;
    }
    
    /**
     * 
     * 功能描述:base64编码
     * @param key
     * @return
     * @throws Exception
     */
    public static byte[] decryptBASE64(String key) throws Exception{
    	BASE64Decoder decoder=new BASE64Decoder();
		return decoder.decodeBuffer(key);
    }
    
    public static String encryptBASE64(byte[]key) throws Exception{
    	BASE64Encoder baseEncoder = new BASE64Encoder();
    	return baseEncoder.encode(key);
    }
    
    public static void main(String[]args) throws Exception{
    	//Map<String, Object> keyMap = RSACoder.initKey();  
    	  
        //String publicKey = RSACoder.getPublicKey(keyMap);  
        //String privateKey = RSACoder.getPrivateKey(keyMap);  
    	String publicKey="MIGfMA0GCSqGSIb3DQEBAQUAA4GNADCBiQKBgQCMmufjBW7BYalFaKxVbphhXTgAa8D/1rnKWdyW"+
"vvVtz7Y2zi0l+BuGvGHcRFl7pTevr33Gpi6EQdeiEJYTcFh4cvwsyi3ryDgy/qXn8BM69HpbRytj"+
"RXxrjZekh5DyptXzyD/DUk7FOtbaI/ai4CXc5Avzn82Nob6jew/vgc8S7QIDAQAB";
    	String privateKey="MIICeAIBADANBgkqhkiG9w0BAQEFAASCAmIwggJeAgEAAoGBAKQmU+Ap9V8xphBhD+psJpQkotsq"+
"wvX/lILrjpKMQ3vt6FvRlD225Kr0QmrjxIjO/6WSM+QaEgMy20xpuSGI5PvlYlbUZhTytXfTFuic"+
"NuWbO0UEAuJTIzdbQZz9dEu28VOZAhx80AZv5EGmsJHwZl5yryzkQ03Zq+jJ/fotVLlJAgMBAAEC"+
"gYAPWzKPjv1QeYGSmLH3eUSmqUK/BCIXB2DqWoUM+qg5iMkrBdE7cMe1ooIwI7y4G71YzPOjzDiR"+
"KgnP/Tf/hiH9tF0RX18RXBu7IjEsPyKe7mlZDEOz1rFcdQyiK8mExJ/Z1SCKjvxhL09aL0RAHpwX"+
"pbCsW4UQk7JGp9CauB9vfQJBAM/V/bkDOMklkgb9mwg3IFu+pY95hFgBP8bCFFyCfIJAZmWO0eeI"+
"UV3+rl89DkS3T3CFi6hLYf90HOOTDfyuT9cCQQDKMJ+SM9rnADViskZs1qOXlAc7jSmai4R8cYlc"+
"2ueLA7/bH3Xcbuh7uStIhMjoAs73IDui4H4hVTgVYZbFSpvfAkEAs+Mv3Dbhq5gNMGfJC+9K3p3A"+
"htJSrilGni3VmcyHH+XFuxlGrPPcGVMacexSsT9ITsgH/P5iL8y8RG0/qfjluQJBALwDhv8fNTmF"+
"mh8TBCYFWc6EGk2oML3DawmFUmSEMre0Xt3WXXUDtTAHulYPE/ubUPXAhXQqKV+5rRNE0jzX6iUC"+
"QQCbwWSJRAkVVnXRSzuN9EDjzve++BxPRLQK9pgavjEQx7x9UaC/L53MJ0C7W7DTa3tWz9ufSFEJ"+
"tSPiKblyAThn";
        /*System.err.println("公钥: \n\r" + publicKey);  
        System.err.println("私钥： \n\r" + privateKey);
        String ss=Encoding.encoding(publicKey);
        System.out.println("加密后的公钥：==="+ss);
        System.out.println("解密后的公钥：=="+Encoding.decoding(ss));
        System.err.println("私钥加密——公钥解密");  
        String inputStr = "sign";  
        byte[] data = inputStr.getBytes();  
  
        byte[] encodedData = RSACoder.encryptByPrivateKey(data, privateKey);  
        String account=new sun.misc.BASE64Encoder().encodeBuffer(encodedData);
        System.out.println("加密后的账号："+account);
        String outputStr = new String(decodedData);  
        System.err.println("加密前: " + inputStr + "\n\r" + "解密后: " + outputStr);  
  
        System.err.println("私钥签名——公钥验证签名");  
        // 产生签名  
        String sign = RSACoder.sign(encodedData, privateKey);  
        System.err.println("签名:\r" + sign);  
  
        // 验证签名  
        boolean status = RSACoder.verify(encodedData, publicKey, sign);  
        System.err.println("状态:\r" + status);  */
        
        String pu="7b3b5535bf24dddb8fcb31e874c8b64ecf20742b0518cb262d74d012014a5a6779fd3ed78e5c236895975767f85c83a8810059d9ee7dd179616b0c77eb70d898e74b42c41b940e4612d087baa7c8c2fde5c2f576e9c2090879d9bd6f9361d14dbca44be5324385f2c635818c0d4545d99c657d5a1f84ad73975daf4d6bd4ce2604af713a170f19d8792418395a09526c79a64eae082cb03219faf10393673c68c61589454d52b67ccc784ca5d36403965e0f2b81d63d6602ca665d7ab9cb5c9604b5f5719f14b24650aca3a17ee2ab3b29bc8b0e5819cc21388d61e25100ecc5";
        String publica=Encoding.decoding(pu);
        String account="SZNm7oOV9klhjSHoAo4Wkgvx++oPf5YxVIrjBzUGWBswgrxGPkR4Y3otg24RZMtMmJXC3IfD2x7w"+
        "kaWRhbn396Ih24WdXTAgaF3LPl+ehzOyYMtvlQ0BvP5dEumcED5Pux2fgQPoJa0RP/C8O0YT7QKr"+
        		"oDJHva3/8rzFjnYoP4M=";
        
        System.out.println("解密后的公钥===="+publica);
        byte[] decodedData = RSACoder.decryptByPublicKey(new sun.misc.BASE64Decoder().decodeBuffer(account), publica);  
  
        String outputStr = new String(decodedData);  
        System.err.println( "解密后: " + outputStr);  
  
  
    }
}
