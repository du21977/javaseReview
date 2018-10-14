package com.dobi;

import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;

import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.SecretKeySpec;
import java.io.UnsupportedEncodingException;
import java.math.BigInteger;
import java.net.URLDecoder;
import java.net.URLEncoder;
import java.nio.charset.StandardCharsets;
import java.security.InvalidKeyException;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

/**
 * 加密与安全
 */
public class Day10 {
   //加密的作用
   //防止窃听。防止修改，防止伪造

    public static void main(String[] args) {
        ////////////////////////////////////////下面是URL编码//////////////////////////////////////////////////
        //URL编码----常用场景---http get请求url后面 的参数就是
        String original = "URL 参数";
        try {
            //URL编码
            String encoded = URLEncoder.encode(original,"UTF-8");
            System.out.println(encoded);
            //URL解码
            String ori = new String(URLDecoder.decode(encoded,"UTF-8"));
            System.out.println(ori);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
        //说明：一个汉字占3个字节

        ////////////////////////////////////////下面是Base64编码//////////////////////////////////////////////////
        //Base64编码--一种二进制数据用文本表示的编码算法
        String original_base64 = "Hello\u00ff编码测试";
        String b64 = null;
        try {
            b64 = Base64.getEncoder().encodeToString(original_base64.getBytes("UTF-8"));
            System.out.println(b64);
            String ori = new String(Base64.getDecoder().decode(b64), "UTF-8");
            System.out.println(ori);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        //总结：
        //Base64是编码算法，不是加密算法
        //Base64编码的目的是把任意二进制数据编码为文本(长度会增加1/3)
        //其他编码Base32---Base48---Base58


        //摘要算法又称hash算法
        //相同的输入(equals)始终得到相同的输出
        //不同的输入尽量得到不同的输出
        //目的：验证原始数据是否被篡改
        //碰撞：两个不同的输入得到了相同的输出
        //常见的摘要算法：MD5(输出16字节)，SHA-1(20字节)，SHA-256(32字节)，RipeMD(20字节)
        //java的Object.hashCode方法就是一个摘要算法
        /////////////////////////////////下面是MD5加密算法///////////////////////////////////////////////////////////////////////
        //MD5常用文件是否修改
        //MD5的输入是字节
        try {
            String md5str = "MD5摘要算法测试";

            MessageDigest md = MessageDigest.getInstance("MD5");
            try {
                md.update(md5str.getBytes("UTF-8"));
            } catch (UnsupportedEncodingException e) {
                e.printStackTrace();
            }
            System.out.println(String.format("%032x",new BigInteger(1,md.digest())));


        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        /////////////////////////////////下面是SHA-1加密算法////////////////////////////////////////////////////////////

        //SHA-1也是一种hash算法，输出160bits,也就是20个字节bytes,是美国国家安全局开发
        //SHA256输出256bits,32字节
        //SHA512输出512bits,64字节
        //比MD5更安全
        String sha1Str = "SHA1摘要算法";
        try {
            byte[] bytesSha1 = sha1(sha1Str.getBytes("UTF-8"));
            System.out.println(String.format("%040x",new BigInteger(1,bytesSha1)));
            System.out.println(sha1(bytesSha1).length);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }

        //////////////////////////////////////////////加密算法////////////////////////////////////////////////////////////////////////////
        //对称加密：加密和解密使用同一个密钥，常用的对称加密DES(密钥过短，可以短时间内暴力破解，已经不安全了)和AES
        String message = "Hello,world! encryted using AES!";
        System.out.println("message: "+message);
        //128位密钥 =16 bytes key
        try {
            byte[] key = "1234567890abcdef".getBytes("UTF-8");
            //加密
            byte[] data = message.getBytes(StandardCharsets.UTF_8);
            try {
                byte[] encrypted = encrypt(key,data);
                //输出加密后的数据
                System.out.println("加密后的数据:"+Base64.getEncoder().encodeToString(encrypted));
                byte[] decrypted = decrypt(key,encrypted);
                System.out.println("解密后的数据--"+new String(decrypted,"UTF-8"));
            } catch (NoSuchPaddingException e) {
                e.printStackTrace();
            } catch (NoSuchAlgorithmException e) {
                e.printStackTrace();
            } catch (InvalidKeyException e) {
                e.printStackTrace();
            } catch (BadPaddingException e) {
                e.printStackTrace();
            } catch (IllegalBlockSizeException e) {
                e.printStackTrace();
            }


        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }


        //非对称加密
        //加密和解密使用不同的密钥，只有使用同一个公钥和私钥对才能加解密
        //方式一
        //加密：用自己的私钥加密，然后发送给对方
        //解密：对方用自己的公钥解密
        //方式二
        //加密：用对方的公钥加密，然后发送给对方
        //解密：用自己的私钥解密
        //非对称加密典型的算法：RSA算法
        //缺点：运算速度慢






        //////////////////////////////////////////签名算法///////////////////////////////////////////////////////////////
        //数字签名就是发送方用自己的私钥对消息进行签名，接收方用发送方的公钥验证签名是否有效
        //目的：消息是发送方发送的，防止信息在传输过程中被篡改
        //常用的签名算法：RSA，DSA





        ////////////////////////////////////////数字证书//////////////////////////////////////////////
        //数字证书包含了下面几个，就是一个合集
        //非对称加密算法：对数据进行加解密
        //签名算法：确保数据的完整性
        //摘要算法：确保证书本身没有被篡改



    }

    /**
     * SHA-1
     * @param input
     * @return
     */
    public  static  byte[] sha1(byte[] input){
        MessageDigest messageDigest =null;
        try {
             messageDigest =MessageDigest.getInstance("SHA-1");
            messageDigest.update(input);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }

        return messageDigest.digest();
    }

    /**
     * AES对称加密
     */
    static final  String CIPHER_NAME = "AES/ECB/PKCS5Padding";
    //加密
    public static byte[] encrypt(byte[] key,byte[] input) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        Cipher cipher = Cipher.getInstance(CIPHER_NAME);
        SecretKeySpec keySpec = new SecretKeySpec(key,"AES");
        cipher.init(Cipher.ENCRYPT_MODE,keySpec);
        return cipher.doFinal(input);
    }
    //解密
    public static byte[] decrypt(byte[] key,byte[] input) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, BadPaddingException, IllegalBlockSizeException {
        Cipher cipher = Cipher.getInstance(CIPHER_NAME);
        SecretKeySpec keySpec = new SecretKeySpec(key,"AES");
        cipher.init(Cipher.ENCRYPT_MODE,keySpec);
        return cipher.doFinal(input);
    }




}
