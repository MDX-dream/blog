package com.master.util;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;

/**
 * <p>
 * MD5加密工具类
 * </p>
 *
 * @author MDX
 * @since 2023/4/11 22:13
 */
public class MD5Utils {
    /**
     * @param str: 要加密的字符串
     * @return 要加密后的字符串
     * @Description MD5加密
     */
    public static String code(String str) {
        try {
            MessageDigest md = MessageDigest.getInstance("MD5");
            md.update(str.getBytes());
            byte[] byteDigest = md.digest();
            int i;
            StringBuilder buf = new StringBuilder();

/*            for (int offset = 0; offset < byteDigest.length; offset++) {
                i = byteDigest[offset];
                if (i < 0)
                    i += 256;
                if (i < 16)
                    buf.append("0");
                buf.append(Integer.toHexString(i));
            }*/
            for (byte b : byteDigest) {
                i = b;
                if (i < 0)
                    i += 256;
                if (i < 16)
                    buf.append("0");
                buf.append(Integer.toHexString(i));
            }
            //32位加密
            return buf.toString();
            // 16位的加密
            //return buf.toString().substring(8, 24);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
            return null;
        }
    }

    //获取明码加密后的密码
    public static void main(String[] args) {
        System.out.println(code("111111"));
    }
}
