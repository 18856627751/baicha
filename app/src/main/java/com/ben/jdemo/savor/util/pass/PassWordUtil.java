package com.ben.jdemo.savor.util.pass;

import android.os.Build;
import android.util.Base64;

import com.ben.jdemo.savor.constant.Parameter;
import com.ben.jdemo.savor.util.TLog;

import java.security.Key;
import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

import javax.crypto.Cipher;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;

/**
 * @author： BaiCha
 * @Time:2019/1/20
 * @description :密码加密过程,加密之后再MD5匹配
 */
public class PassWordUtil {



    public static String encode(String pass){
        try {
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            Key keySpec = new SecretKeySpec(Parameter.AES.getBytes(), "AES");
            IvParameterSpec ivParameterSpec = new IvParameterSpec(Parameter.AES.getBytes());
            cipher.init(Cipher.ENCRYPT_MODE, keySpec,ivParameterSpec);
            byte[] doFinal = cipher.doFinal(pass.getBytes());
            return Base64.encodeToString(doFinal,0);

        } catch (Exception e) {
            TLog.e("PassWordUtil","encode-encode-error:"+e.getMessage());
            return Parameter.ERROR;
        }
    }

    public static String decode(String pass){
        try {
            Cipher cipher = Cipher.getInstance("AES/CBC/PKCS5Padding");
            Key keySpec = new SecretKeySpec(Parameter.AES.getBytes(), "AES");
            IvParameterSpec ivParameterSpec = new IvParameterSpec(Parameter.AES.getBytes());
            cipher.init(Cipher.DECRYPT_MODE, keySpec,ivParameterSpec);
            byte[] doFinal = cipher.doFinal(Base64.decode(pass, 0));
            return new String(doFinal);
        } catch (Exception e) {
            TLog.e("PassWordUtil","encode-decode-error:"+e.getMessage());
            return Parameter.ERROR;
        }




    }


    public static String md5(String pass){
        try {
            MessageDigest md5 = MessageDigest.getInstance("MD5");
            byte[] digest = md5.digest(pass.getBytes());
            StringBuilder builder= new StringBuilder();
            for (byte b : digest) {
                builder.append(Integer.toHexString((int)b & 0xff));
            }
            return builder.toString();
        } catch (Exception e) {
            TLog.e("PassWordUtil","encode-md5-error:"+e.getMessage());
            return Parameter.ERROR;
        }

    }


}
