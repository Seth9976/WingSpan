package com.unity3d.plugin.downloader.d;

import com.unity3d.plugin.downloader.e.b;
import java.io.UnsupportedEncodingException;
import java.security.GeneralSecurityException;
import javax.crypto.BadPaddingException;
import javax.crypto.Cipher;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.PBEKeySpec;
import javax.crypto.spec.SecretKeySpec;

public final class a implements k {
    private static final byte[] a;
    private Cipher b;
    private Cipher c;

    static {
        a.a = new byte[]{16, 74, 71, -80, 0x20, 101, (byte)0xD1, 72, 0x75, -14, 0, -29, 70, 65, -12, 74};
    }

    public a(byte[] arr_b, String s, String s1) {
        try {
            SecretKeySpec secretKeySpec0 = new SecretKeySpec(SecretKeyFactory.getInstance("PBEWITHSHAAND256BITAES-CBC-BC").generateSecret(new PBEKeySpec((s + s1).toCharArray(), arr_b, 0x400, 0x100)).getEncoded(), "AES");
            Cipher cipher0 = Cipher.getInstance("AES/CBC/PKCS5Padding");
            this.b = cipher0;
            cipher0.init(1, secretKeySpec0, new IvParameterSpec(a.a));
            Cipher cipher1 = Cipher.getInstance("AES/CBC/PKCS5Padding");
            this.c = cipher1;
            cipher1.init(2, secretKeySpec0, new IvParameterSpec(a.a));
        }
        catch(GeneralSecurityException generalSecurityException0) {
            throw new RuntimeException("Invalid environment", generalSecurityException0);
        }
    }

    @Override  // com.unity3d.plugin.downloader.d.k
    public final String a(String s, String s1) {
        if(s == null) {
            return null;
        }
        try {
            return com.unity3d.plugin.downloader.e.a.a(this.b.doFinal(("com.google.android.vending.licensing.AESObfuscator-1|" + s1 + s).getBytes("UTF-8")));
        }
        catch(UnsupportedEncodingException unsupportedEncodingException0) {
            throw new RuntimeException("Invalid environment", unsupportedEncodingException0);
        }
        catch(GeneralSecurityException generalSecurityException0) {
            throw new RuntimeException("Invalid environment", generalSecurityException0);
        }
    }

    @Override  // com.unity3d.plugin.downloader.d.k
    public final String b(String s, String s1) {
        if(s == null) {
            return null;
        }
        try {
            String s2 = new String(this.c.doFinal(com.unity3d.plugin.downloader.e.a.a(s)), "UTF-8");
            if(s2.indexOf("com.google.android.vending.licensing.AESObfuscator-1|" + s1) != 0) {
                throw new o("Header not found (invalid data or key):" + s);
            }
            return s2.substring(s1.length() + 53, s2.length());
        }
        catch(b b0) {
            throw new o(b0.getMessage() + ":" + s);
        }
        catch(IllegalBlockSizeException illegalBlockSizeException0) {
            throw new o(illegalBlockSizeException0.getMessage() + ":" + s);
        }
        catch(BadPaddingException badPaddingException0) {
            throw new o(badPaddingException0.getMessage() + ":" + s);
        }
        catch(UnsupportedEncodingException unsupportedEncodingException0) {
            throw new RuntimeException("Invalid environment", unsupportedEncodingException0);
        }
    }
}

