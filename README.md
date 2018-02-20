# Encryption-Rest-API
Public Rest API for my [Encryption Library](https://github.com/antoniok9130/Encryption-Library)

All encrypting, decrypting, and hashing is done using the ByteEncryption algorithm found in my [Encryption Library](https://github.com/antoniok9130/Encryption-Library)

## Documentation
### Generate Private Key

```
https://encryption-rest-api-jhk.appspot.com/key/generate
https://encryption-rest-api-jhk.appspot.com/key/generate?length=<integer>
```

Params: length (Integer)

Request Method:   [GET](https://encryption-rest-api-jhk.appspot.com/key/generate)

 This generates a unicode private key of specified length (default 64) that can be used in other API requests.

### Encrypt a string

```
https://encryption-rest-api-jhk.appspot.com/encrypt?string=<text>
https://encryption-rest-api-jhk.appspot.com/encrypt?string=<text>&key=<private-key>
```

Params: **string** (String), **key** (String)

Request Method:   [GET](https://encryption-rest-api-jhk.appspot.com/encrypt?string=<text>&key=<private-key>)

This encrypts the *string* parameter using the *key* parameter. If a key is not provided, the default key will be used.

### Decrypt a string

```
https://encryption-rest-api-jhk.appspot.com/decrypt?string=<text>
https://encryption-rest-api-jhk.appspot.com/decrypt?string=<text>&key=<private-key>
```

Params: **string** (String), **key** (String)

Request Method:   [GET](https://encryption-rest-api-jhk.appspot.com/decrypt?string=<text>&key=<private-key>)

This decrypts the *string* parameter using the *key* parameter. If a key is not provided, the default key will be used.

### Hash a string

```
https://encryption-rest-api-jhk.appspot.com/hash?string=<text>
https://encryption-rest-api-jhk.appspot.com/hash?string=<text>&key=<private-key>
```

Params: **string** (String), **key** (String)

Request Method:   [GET](https://encryption-rest-api-jhk.appspot.com/hash?string=<text>&key=<private-key>)

This hashes the *string* parameter using the *key* parameter. If a key is not provided, the default key will be used.
 
