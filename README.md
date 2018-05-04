# Encryption-Rest-API
Public Rest API for my [Encryption Library](https://github.com/antoniok9130/Encryption-Library)

All encrypting, decrypting, and hashing is done using the ByteEncryption algorithm found in my [Encryption Library](https://github.com/antoniok9130/Encryption-Library)

## Documentation
### Generate Private Key

```
http://encryption.antoniojkim.com/generate/key
http://encryption.antoniojkim.com/generate/key?length=<integer>
```

Params: length (Integer)

Request Method:   [GET](https://encryption-rest-api-jhk.appspot.com/generate/key)

This generates a hex private key of twice the specified length (default 64) that can be used in other API requests.
 
Returns: **JSON**

E.g.

`{"key":"E23D8925935EAA5A02D90ED22B4890297A6FE11552D0D498E707182E749BB05DFB886E8EA9B782955A9C0CBC4439A23402764CD8D46B0C9538711EAFB1C25EAE","message":"Generated Private Key"}`

### Generate KeyStore

```
http://encryption.antoniojkim.com/generate/keystore
http://encryption.antoniojkim.com/generate/keystore?scrambler=<string>
http://encryption.antoniojkim.com/generate/keystore/random
```

Params: scrambler (String) (optional)

Request Method:   [GET](http://encryption.antoniojkim.com/generate/keystore)

This generates a keystore that can be used in the ByteEncryption algorithm. It uses the scrambler to generate a unique keystore. If no scrambler is provided, the default scrambler is used. If the random href is used, then it will generate a random keystore.
 
Returns: **JSON**


### Encrypt a string

```
http://encryption.antoniojkim.com/encrypt?text=<text>
http://encryption.antoniojkim.com/encrypt?text=<text>&key=<private-key>
```

Params: **string** (String), **key** (String)

Request Method:   [GET](http://encryption.antoniojkim.com/encrypt?text=<text>&key=<private-key>)

This encrypts the *string* parameter using the *key* parameter. If a key is not provided, the default key will be used.

Returns: **JSON**

E.g. 

`{"encrypted":"+4UD_WL3n+FneiWTgAqfco1JeozFrcG4XPWlmCudwH601"}`



### Decrypt a string

```
http://encryption.antoniojkim.com/decrypt?text=<text>
http://encryption.antoniojkim.com/decrypt?text=<text>&key=<private-key>
```

Params: **string** (String), **key** (String)

Request Method:   [GET](http://encryption.antoniojkim.com/decrypt?text=<text>&key=<private-key>)

This decrypts the *string* parameter using the *key* parameter. If a key is not provided, the default key will be used.

Returns: **JSON**

E.g.

`{"decrypted": "<text>"}`

### Hash a string

```
http://encryption.antoniojkim.com/hash?text=<text>
http://encryption.antoniojkim.com/hash?text=<text>&key=<private-key>
```

Params: **string** (String), **key** (String)

Returns: **JSON**

Request Method:   [GET](http://encryption.antoniojkim.com/hash?text=<text>&key=<private-key>)

This hashes the *string* parameter using the *key* parameter. If a key is not provided, the default key will be used.

Returns: **JSON**

E.g.

`{"hash":"F02142FB686C5C15C1EE05E5D8916AEF72A1926F5B0BEB2D81B3177105EFCC061831984CF639C0790A0633F80BCE556EC7D17D84E6701C5679726F7DA4CD2742"}`
 
