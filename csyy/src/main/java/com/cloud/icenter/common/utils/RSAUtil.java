package com.cloud.icenter.common.utils;

/**
 * 
 */

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.math.BigInteger;
import java.security.KeyFactory;
import java.security.KeyPair;
import java.security.KeyPairGenerator;
import java.security.NoSuchAlgorithmException;
import java.security.PrivateKey;
import java.security.PublicKey;
import java.security.SecureRandom;
import java.security.interfaces.RSAPrivateKey;
import java.security.interfaces.RSAPublicKey;
import java.security.spec.InvalidKeySpecException;
import java.security.spec.RSAPrivateKeySpec;
import java.security.spec.RSAPublicKeySpec;
import java.util.HashMap;

import javax.crypto.Cipher;

import org.apache.commons.codec.binary.Hex;
import org.apache.commons.lang3.StringUtils;
import org.bouncycastle.jce.provider.BouncyCastleProvider;
import org.springframework.stereotype.Component;

/**
 * RSA 工具类。提供加密，解密，生成密钥对等方法。
 * 需要到http://www.bouncycastle.org下载bcprov-jdk14-123.jar。
 *
 */
@Component
public class RSAUtil {

	private String RSAKeyStore = "src/RSA/text.txt";
	private HashMap<String, KeyPair> keyMap = new HashMap<String, KeyPair>(50);
	private static BouncyCastleProvider bouncyCastleProvider=null;
	/**
	 * * 生成密钥对 *
	 *
	 * @return KeyPair *
	 * @throws EncryptException
	 */
	public String generateKeyPair() throws Exception {
		try {
			KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("RSA",
					getInstanceprovider());
			final int KEY_SIZE = 512;// 没什么好说的了，这个值关系到块加密的大小，可以更改，但是不要太大，否则效率会低
			keyPairGen.initialize(KEY_SIZE, new SecureRandom());
			KeyPair keyPair = keyPairGen.generateKeyPair();
			RSAPublicKey rsap = (RSAPublicKey) keyPair.getPublic();
			// saveKeyPair(keyPair);
			keyMap.put(rsap.getModulus().toString(16), keyPair);
			// System.out.println(rsap.getPublicExponent().toString(16));
			return rsap.getModulus().toString(16);
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	/**
	 * 获取私钥
	 *
	 * @return
	 * @throws Exception
	 */
	public KeyPair getKeyPair() throws Exception {
		FileInputStream fis = new FileInputStream(RSAKeyStore);
		ObjectInputStream oos = new ObjectInputStream(fis);
		KeyPair kp = (KeyPair) oos.readObject();
		oos.close();
		fis.close();
		return kp;
	}

	/**
	 * 保存私钥
	 *
	 * @param KeyPair
	 *            *
	 * @author yuhaitao
	 * */
	public void saveKeyPair(KeyPair kp) throws Exception {

		FileOutputStream fos = new FileOutputStream(RSAKeyStore);
		ObjectOutputStream oos = new ObjectOutputStream(fos);
		// 生成密钥
		oos.writeObject(kp);
		oos.close();
		fos.close();
	}

	/**
	 * * 生成公钥 *
	 *
	 * @param modulus
	 *            *
	 * @param publicExponent
	 *            *
	 * @return RSAPublicKey *
	 * @throws Exception
	 */
	public RSAPublicKey generateRSAPublicKey(byte[] modulus,
											 byte[] publicExponent) throws Exception {
		KeyFactory keyFac = null;
		try {
			keyFac = KeyFactory.getInstance("RSA",
					getInstanceprovider());
		} catch (NoSuchAlgorithmException ex) {
			throw new Exception(ex.getMessage());
		}

		RSAPublicKeySpec pubKeySpec = new RSAPublicKeySpec(new BigInteger(
				modulus), new BigInteger(publicExponent));
		try {
			return (RSAPublicKey) keyFac.generatePublic(pubKeySpec);
		} catch (InvalidKeySpecException ex) {
			throw new Exception(ex.getMessage());
		}
	}

	/**
	 * * 生成私钥 *
	 *
	 * @param modulus
	 *            *
	 * @param privateExponent
	 *            *
	 * @return RSAPrivateKey *
	 * @throws Exception
	 */
	public RSAPrivateKey generateRSAPrivateKey(byte[] modulus,
											   byte[] privateExponent) throws Exception {
		KeyFactory keyFac = null;
		try {
			keyFac = KeyFactory.getInstance("RSA",
					getInstanceprovider());
		} catch (NoSuchAlgorithmException ex) {
			throw new Exception(ex.getMessage());
		}

		RSAPrivateKeySpec priKeySpec = new RSAPrivateKeySpec(new BigInteger(
				modulus), new BigInteger(privateExponent));
		try {
			return (RSAPrivateKey) keyFac.generatePrivate(priKeySpec);
		} catch (InvalidKeySpecException ex) {
			throw new Exception(ex.getMessage());
		}
	}

	/**
	 * * 加密 *
	 *
	 * @param key
	 *            加密的密钥 *
	 * @param data
	 *            待加密的明文数据 *
	 * @return 加密后的数据 *
	 * @throws Exception
	 */
	public byte[] encrypt(PublicKey pk, byte[] data) throws Exception {
		try {
			Cipher cipher = Cipher.getInstance("RSA",
					getInstanceprovider());
			cipher.init(Cipher.ENCRYPT_MODE, pk);
			int blockSize = cipher.getBlockSize();// 获得加密块大小，如：加密前数据为128个byte，而key_size=1024
			// 加密块大小为127
			// byte,加密后为128个byte;因此共有2个加密块，第一个127
			// byte第二个为1个byte
			int outputSize = cipher.getOutputSize(data.length);// 获得加密块加密后块大小
			int leavedSize = data.length % blockSize;
			int blocksSize = leavedSize != 0 ? data.length / blockSize + 1
					: data.length / blockSize;
			byte[] raw = new byte[outputSize * blocksSize];
			int i = 0;
			while (data.length - i * blockSize > 0) {
				if (data.length - i * blockSize > blockSize)
					cipher.doFinal(data, i * blockSize, blockSize, raw, i
							* outputSize);
				else
					cipher.doFinal(data, i * blockSize, data.length - i
							* blockSize, raw, i * outputSize);
				// 这里面doUpdate方法不可用，查看源代码后发现每次doUpdate后并没有什么实际动作除了把byte[]放到
				// ByteArrayOutputStream中，而最后doFinal的时候才将所有的byte[]进行加密，可是到了此时加密块大小很可能已经超出了
				// OutputSize所以只好用dofinal方法。

				i++;
			}
			return raw;
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}

	/**
	 * * 加密 *
	 *
	 * @param key
	 *            加密的密钥 *
	 * @param data
	 *            待加密的明文数据 *
	 * @return 加密后的数据 *
	 * @throws Exception
	 */
	public byte[] encrypt(PrivateKey pk, byte[] data) throws Exception {
		try {
			Cipher cipher = Cipher.getInstance("RSA",
					getInstanceprovider());
			cipher.init(Cipher.ENCRYPT_MODE, pk);
			int blockSize = cipher.getBlockSize();// 获得加密块大小，如：加密前数据为128个byte，而key_size=1024
			// 加密块大小为127
			// byte,加密后为128个byte;因此共有2个加密块，第一个127
			// byte第二个为1个byte
			int outputSize = cipher.getOutputSize(data.length);// 获得加密块加密后块大小
			int leavedSize = data.length % blockSize;
			int blocksSize = leavedSize != 0 ? data.length / blockSize + 1
					: data.length / blockSize;
			byte[] raw = new byte[outputSize * blocksSize];
			int i = 0;
			while (data.length - i * blockSize > 0) {
				if (data.length - i * blockSize > blockSize)
					cipher.doFinal(data, i * blockSize, blockSize, raw, i
							* outputSize);
				else
					cipher.doFinal(data, i * blockSize, data.length - i
							* blockSize, raw, i * outputSize);
				// 这里面doUpdate方法不可用，查看源代码后发现每次doUpdate后并没有什么实际动作除了把byte[]放到
				// ByteArrayOutputStream中，而最后doFinal的时候才将所有的byte[]进行加密，可是到了此时加密块大小很可能已经超出了
				// OutputSize所以只好用dofinal方法。

				i++;
			}
			return raw;
		} catch (Exception e) {
			throw new Exception(e.getMessage());
		}
	}


	/**
	 *
	 * @param pk
	 *            公钥
	 * @param pw
	 *            密码
	 * @return 解密后的密码
	 * @throws Exception
	 * @author yuhaitao
	 */
	public String decryptString(String pk, String word) throws Exception {
		KeyPair privateKey = keyMap.get(pk);
		if (privateKey == null || StringUtils.isBlank(word)) {
			return null;
		}
		byte[] en_data = Hex.decodeHex(word.toCharArray());
		byte[] data = decrypt(privateKey.getPrivate(), en_data);
		StringBuffer sb = new StringBuffer();
		sb.append(new String(data));
		return sb.reverse().toString();
	}

	public void deletekeyPair(String pk) {
		if (keyMap.containsKey(pk)) {
			keyMap.remove(pk);
		}
	}

	/**
	 * * 解密 *
	 *
	 * @param key
	 *            解密的密钥 *
	 * @param raw
	 *            已经加密的数据 *
	 * @return 解密后的明文 *
	 * @throws Exception
	 */
	public byte[] decrypt(PublicKey publickey, byte[] raw) throws Exception {
		Cipher ci = Cipher.getInstance("RSA", getInstanceprovider());
		ci.init(Cipher.DECRYPT_MODE, publickey);
		return ci.doFinal(raw);
	}

	/**
	 * * 解密 *
	 *
	 * @param key
	 *            解密的密钥 *
	 * @param raw
	 *            已经加密的数据 *
	 * @return 解密后的明文 *
	 * @throws Exception
	 */
	public byte[] decrypt(PrivateKey privateKey, byte[] raw) throws Exception {
		Cipher ci = Cipher.getInstance("RSA", getInstanceprovider());
		ci.init(Cipher.DECRYPT_MODE, privateKey);
		return ci.doFinal(raw);
	}

	/**
	 * 生成公钥和私钥
	 * @throws NoSuchAlgorithmException
	 * by wuym 20161014
	 */
	public static HashMap<String, String> getKeys() throws NoSuchAlgorithmException{
		HashMap<String, String> map = new HashMap<String, String>();
		KeyPairGenerator keyPairGen = KeyPairGenerator.getInstance("RSA");
		keyPairGen.initialize(512);
		KeyPair keyPair = keyPairGen.generateKeyPair();
		RSAPublicKey publicKey = (RSAPublicKey) keyPair.getPublic();
		RSAPrivateKey privateKey = (RSAPrivateKey) keyPair.getPrivate();
		String modulus = publicKey.getModulus().toString(16);
		String publicexponent = publicKey.getPublicExponent().toString(16);
		String privateexponent = privateKey.getPrivateExponent().toString(16);
		map.put("publicexponent", publicexponent);
		map.put("privateexponent", privateexponent);
		map.put("modulus", modulus);
		return map;
	}

	/**
	 * 使用模和指数生成RSA公钥
	 * 注意：【此代码用了默认补位方式，为RSA/None/PKCS1Padding，不同JDK默认的补位方式可能不同，如Android默认是RSA
	 * /None/NoPadding】
	 * @param modulus  模
	 * @param exponent  指数
	 * @return
	 * by wuym 20161014
	 */
	public static RSAPublicKey getPublicKey(String modulus, String exponent) {
		try {
			BigInteger b1 = new BigInteger(modulus,16);
			BigInteger b2 = new BigInteger(exponent,16);
			KeyFactory keyFactory = KeyFactory.getInstance("RSA");
			RSAPublicKeySpec keySpec = new RSAPublicKeySpec(b1, b2);
			return (RSAPublicKey) keyFactory.generatePublic(keySpec);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	/**
	 * 使用模和指数生成RSA私钥
	 * 注意：【此代码用了默认补位方式，为RSA/None/PKCS1Padding，不同JDK默认的补位方式可能不同，如Android默认是RSA
	 * /None/NoPadding】
	 * @param modulus 模
	 * @param exponent 指数
	 * @return
	 * by wuym 20161014
	 */
	public static RSAPrivateKey getPrivateKey(String modulus, String exponent) {
		try {
			BigInteger b1 = new BigInteger(modulus,16);
			BigInteger b2 = new BigInteger(exponent,16);
			KeyFactory keyFactory = KeyFactory.getInstance("RSA");
			RSAPrivateKeySpec keySpec = new RSAPrivateKeySpec(b1, b2);
			return (RSAPrivateKey) keyFactory.generatePrivate(keySpec);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
	}

	public static synchronized BouncyCastleProvider getInstanceprovider() {  
        if (bouncyCastleProvider == null) {  
            bouncyCastleProvider = new BouncyCastleProvider();  
        }  
        return bouncyCastleProvider;  
    }  

}