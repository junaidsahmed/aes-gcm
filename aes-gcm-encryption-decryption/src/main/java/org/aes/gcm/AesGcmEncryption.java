package org.aes.gcm;

import com.google.common.primitives.Bytes;

import javax.crypto.*;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.*;

public class AesGcmEncryption {

    private static final int GCM_IV_LENGTH=16;
    private static final int GCM_TAG_LENGTH=128;
    private static final String KEY="NdRgUkXp2s5v8y/B/E/G+KbPeShVmYq3";



    public static byte[] encryptBytes(byte[] plainTextBytes) throws NoSuchPaddingException, NoSuchAlgorithmException, InvalidKeyException, InvalidAlgorithmParameterException, IllegalBlockSizeException, BadPaddingException {
        Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
        byte[] initializationVector = new byte[GCM_IV_LENGTH];
        new SecureRandom().nextBytes(initializationVector);

        GCMParameterSpec gcmParameterSpec = new GCMParameterSpec(GCM_TAG_LENGTH,initializationVector);
        SecretKey secretKey = new SecretKeySpec(KEY.getBytes(),0,KEY.length(),"AES");
        cipher.init(1, secretKey, gcmParameterSpec);
        return Bytes.concat(initializationVector,cipher.doFinal(plainTextBytes));
    }
}
