# AES GCM 256
aes-gcm 256 encrytpion decrption implementation for node and java projects

If you have a senerio in which you have some encrypted file which is being encrypted by java and you want to decrpt within node or vice versa.

In this repository you can get java and node.js encryption and decrption implementation using aes gcm 256.

### Decrypt Node.js encrypted string in java

```java
//use Node.js encrypted text to decrypt here
String encryptedBase64BytesFromNode="YQtqag/n7O0O02pMpIoYPxqNYWBYtMnOGvbbH11+guzPYpOA56utUzfbANm+mzS7TySApTdeZou90emoHh8PbZg=";
byte[] decryptedNodeBytes = AesGcmDecryption.decryptFile(Base64.getDecoder().decode(encryptedBase64BytesFromNode));
System.out.format("Node.js decrypted string  ->>> %s",  new String(decryptedNodeBytes));
        
```
### Decrypt java encrypted string in Node.js
```javascript
// using java encrypted text to decrypt here
let javaEncryptedString ="5rXiCsQaz+apn/ftc8Wvhoj/km7w2SAFBFwIPiybPVaW9S26V9d7lyRalTVlySYahHautV+nug=";
let javaDecryptedText = decrypt(javaEncryptedString, key);
console.log('java decrypted Text ->>> ', javaDecryptedText)
```
