package org.aes.gcm;

import javax.crypto.*;
import javax.crypto.spec.GCMParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Arrays;

public class AesGcmDecryption {

    private static final int GCM_IV_LENGTH=16;
    private static final int GCM_TAG_LENGTH=128;
    private static final String KEY="NdRgUkXp2s5v8y/B/E/G+KbPeShVmYq3";


    public static byte[] decryptFile(byte[] encryptedText) throws IllegalBlockSizeException, BadPaddingException, NoSuchPaddingException, NoSuchAlgorithmException, InvalidAlgorithmParameterException, InvalidKeyException {

        Cipher cipher = Cipher.getInstance("AES/GCM/NoPadding");
        GCMParameterSpec gcmParameterSpec = new GCMParameterSpec(GCM_TAG_LENGTH, encryptedText, 0, GCM_IV_LENGTH);
        SecretKey secretKeySpec = new SecretKeySpec(KEY.getBytes(), 0,KEY.length(), "AES");
        cipher.init(2, secretKeySpec, gcmParameterSpec);
        byte[] intermediateBytes = Arrays.copyOfRange(encryptedText, GCM_IV_LENGTH, encryptedText.length);
        return cipher.doFinal(intermediateBytes);
    }
}
