package org.aes.gcm;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Base64;

public class AESGCMRunner {
    public static void main(String[] args) throws InvalidAlgorithmParameterException, NoSuchPaddingException, IllegalBlockSizeException, NoSuchAlgorithmException, BadPaddingException, InvalidKeyException {
        String planText = "i'm java encrypted Text";
        byte[] encryptedBytes = AesGcmEncryption.encryptBytes(planText.getBytes());

        System.out.format("encrypted string ->>> %s \n", Base64.getEncoder().encodeToString(encryptedBytes));

        byte[] decryptedBytes = AesGcmDecryption.decryptFile(encryptedBytes);
        System.out.format("decrypted string ->>> %s \n",  new String(decryptedBytes));

        //use Node.js encrypted text to decrypt here
        String encryptedBase64BytesFromNode="YQtqag/n7O0O02pMpIoYPxqNYWBYtMnOGvbbH11+guzPYpOA56utUzfbANm+mzS7TySApTdeZou90emoHh8PbZg=";
        byte[] decryptedNodeBytes = AesGcmDecryption.decryptFile(Base64.getDecoder().decode(encryptedBase64BytesFromNode));
        System.out.format("Node.js decrypted string  ->>> %s",  new String(decryptedNodeBytes));
    }
}
