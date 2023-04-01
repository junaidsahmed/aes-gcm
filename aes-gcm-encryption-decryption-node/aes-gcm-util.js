const _crypto = require('crypto');

var encrypt = function (text, masterkey) {
    // random initialization vector
    const iv = _crypto.randomBytes(16);

    // AES 256 GCM Mode
    const cipher = _crypto.createCipheriv("aes-256-gcm", masterkey, iv);

    // encrypt the given text
    const encrypted = Buffer.concat([
        cipher.update(text, "utf8"),
        cipher.final(),
    ]);

    // extract the auth tag
    const tag = cipher.getAuthTag();

    // generate output
    return Buffer.concat([iv, encrypted, tag]).toString("base64");
}

var decrypt = function (encdata, masterkey) {

    // base64 decoding
    const bData = Buffer.from(encdata, 'base64');

    // convert data to buffers
    const iv = bData.slice(0, 16);
    const tag = bData.slice(bData.length - 16, bData.length);
    const text = bData.slice(16, bData.length - 16);

    // AES 256 GCM Mode
    const decipher = _crypto.createDecipheriv('aes-256-gcm', masterkey, iv);
    decipher.setAuthTag(tag);

    // encrypt the given text
    const decrypted = decipher.update(text, 'binary', 'utf8') + decipher.final('utf8');
    return decrypted;
}


let key = "NdRgUkXp2s5v8y/B/E/G+KbPeShVmYq3";
let plainText = "i'm the encrypted text by node.js"
let encryptedText = encrypt(plainText, key);

console.log('encrypted text ->>>', encryptedText);

let dec = decrypt("Yy4jgnu/AwEyhz1hQuwm6fFRsmJzLBy3Qu+UQYqJkS4IrHxoqRCXpMbtX4JHcISEDvhqJQ==", key)

console.log('decrypted Text ->>> ', dec)

// using java encrypted text to decrypt here
let javaEncryptedString ="5rXiCsQaz+apn/ftc8Wvhoj/km7w2SAFBFwIPiybPVaW9S26V9d7lyRalTVlySYahHautV+nug=";
let javaDecryptedText = decrypt(javaEncryptedString, key);
console.log('java decrypted Text ->>> ', javaDecryptedText)

