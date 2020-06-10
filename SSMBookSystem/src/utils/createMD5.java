package utils;

import java.security.MessageDigest;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class createMD5 {
    public static String salt = ""; //加盐密码

    public static String makeToString(String pwd) {
        pwd = salt + pwd;
        String outStr = null;
        if (pwd == null) {
            outStr = null;
        } else if ("".equals(pwd)) {
            outStr = "";
        } else {
            try {
                MessageDigest md = MessageDigest.getInstance("MD5");
                md.update(pwd.getBytes());
                byte b[] = md.digest();
                StringBuffer buf = new StringBuffer();
                for (int i = 1; i < b.length; i++) {
                    int c = b[i] >>> 4 & 0xf;
                    buf.append(Integer.toHexString(c));
                    c = b[i] & 0xf;
                    buf.append(Integer.toHexString(c));
                }
                outStr = buf.toString();
            } catch (NoSuchAlgorithmException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        return outStr;
    }


    public static void main(String[] args) {
        System.out.println(createMD5.makeToString("123456"));
        ;
    }
}