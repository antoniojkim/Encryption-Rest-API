package EncryptionLibrary.EncryptionRestAPI;

import Byte_Encryption.ByteArrayOperations;
import Byte_Encryption.ByteEncryption;
import Byte_Encryption.ByteKeystore;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Created by Antonio on 2018-02-19.
 */
@RestController
public class EncryptionRestApiController {

    @GetMapping("/")
    public String defaultPage() {
        return "Hello! This is the Encryption Rest API by Antonio Kim. Visit https://github.com/antoniok9130/Encryption-Rest-API to see how to use this API.";
    }

    private ByteEncryption be = new ByteEncryption("");

    private class PrivateKey{
        private String key = null;
        private String message = null;
        public PrivateKey(byte[] key, String message){
            this(ByteArrayOperations.bytesToHex(key), message);
        }
        public PrivateKey(String key, String message){
            this.key = key;
            this.message = message;
        }

        public String getMessage() {
            return message;
        }

        public String getKey() {
            return key;
        }

        public void setKey(String key) {
            if (this.key == null) this.key = key;
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "/error", produces = "application/json") // @RequestParam(value="index", defaultValue = "-1") String strIndex
    public ResponseEntity<String> error(){
        return new ResponseEntity<String>("Encryption Rest API by Antonio Kim is not available right now.", HttpStatus.BAD_REQUEST);
    }

    @RequestMapping(method = RequestMethod.GET, value = "/key/generate", produces = "application/json") // @RequestParam(value="index", defaultValue = "-1") String strIndex
    public ResponseEntity<PrivateKey> generatePrivateKey(@RequestParam(value="length", defaultValue = "64") String length){
        try {
            int size = Integer.parseInt(length);
            return new ResponseEntity<PrivateKey>(
                    new PrivateKey(ByteKeystore.generateKey(size), "Generated Private Key"), HttpStatus.OK);
        }
        catch(NumberFormatException e){}
        return new ResponseEntity<PrivateKey>(new PrivateKey("", "Invalid Key Length"), HttpStatus.BAD_REQUEST);
    }

//    @RequestMapping(method = RequestMethod.POST, value = "/key/set", produces = "application/json") // @RequestParam(value="index", defaultValue = "-1") String strIndex
//    public ResponseEntity<PrivateKey> setPrivateKey(@RequestParam(value="key", defaultValue = "") String key){
//        if (key.length() == 0){
//            key = ByteArrayOperations.bytesToUnicode(ByteKeystore.generateKey(64));
//        }
//        be = new ByteEncryption(key);
//        return new ResponseEntity<PrivateKey>(new PrivateKey(key, "Private Key Set"), HttpStatus.OK);
//    }

    private class Encrypted{
        private String original = null;
        private String encrypted = null;

        public Encrypted(String original, byte[] encrypted) {
            this.original = original;
            this.encrypted = ByteArrayOperations.bytesToHex(encrypted);
        }

        public String getOriginal() {
            return original;
        }

        public void setOriginal(String original) {
            if (this.original == null) this.original = original;
        }

        public String getEncrypted() {
            return encrypted;
        }

        public void setEncrypted(String encrypted) {
            if (this.encrypted == null) this.encrypted = encrypted;
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "/encrypt", produces = "application/json") // @RequestParam(value="index", defaultValue = "-1") String strIndex
    public ResponseEntity<Encrypted> encrypt(@RequestParam(value="string", defaultValue = "") String str,
                                             @RequestParam(value="key", defaultValue = "") String key){
        if (key.length() > 0){
            ByteEncryption be = new ByteEncryption(key);
            return new ResponseEntity<Encrypted>(new Encrypted(str, be.encrypt(str.getBytes())), HttpStatus.OK);
        }
        return new ResponseEntity<Encrypted>(new Encrypted(str, be.encrypt(str.getBytes())), HttpStatus.OK);
    }

    private class Decrypted{
        private String original = null;
        private String decrypted = null;

        public Decrypted(String original, ByteEncryption be) {
            this.original = original;
            this.decrypted = new String(be.decrypt(ByteArrayOperations.hexToBytes(original)));
        }

        public String getOriginal() {
            return original;
        }

        public void setOriginal(String original) {
            if (this.original == null) this.original = original;
        }

        public String getDecrypted() {
            return decrypted;
        }

        public void setDecrypted(String decrypted) {
            if (this.decrypted == null) this.decrypted = decrypted;
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "/decrypt", produces = "application/json") // @RequestParam(value="index", defaultValue = "-1") String strIndex
    public ResponseEntity<Decrypted> decrypt(@RequestParam(value="string", defaultValue = "") String str,
                                             @RequestParam(value="key", defaultValue = "") String key){
        if (key.length() > 0){
            ByteEncryption be = new ByteEncryption(key);
            return new ResponseEntity<Decrypted>(new Decrypted(str, be), HttpStatus.OK);
        }
        return new ResponseEntity<Decrypted>(new Decrypted(str, be), HttpStatus.OK);
    }

    private class Hash{
        private String original = null;
        private String hash = null;

        public Hash(String original, String decrypted) {
            this.original = original;
            this.hash = decrypted;
        }

        public String getOriginal() {
            return original;
        }

        public void setOriginal(String original) {
            if (this.original == null) this.original = original;
        }

        public String getHash() {
            return hash;
        }

        public void setHash(String hash) {
            if (this.hash == null) this.hash = hash;
        }
    }

    @RequestMapping(method = RequestMethod.GET, value = "/hash", produces = "application/json") // @RequestParam(value="index", defaultValue = "-1") String strIndex
    public ResponseEntity<Hash> hash(@RequestParam(value="string", defaultValue = "") String str,
                                     @RequestParam(value="key", defaultValue = "") String key){
        if (key.length() > 0){
            ByteEncryption be = new ByteEncryption(key);
            return new ResponseEntity<Hash>(new Hash(str, be.hashString(str)), HttpStatus.OK);
        }
        return new ResponseEntity<Hash>(new Hash(str, be.hashString(str)), HttpStatus.OK);
    }

}
