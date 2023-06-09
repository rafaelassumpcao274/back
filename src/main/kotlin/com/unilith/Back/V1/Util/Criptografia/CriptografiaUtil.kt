package com.unilith.Back.V1.Util.Criptografia

import org.springframework.security.crypto.password.DelegatingPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.security.crypto.password.Pbkdf2PasswordEncoder

class CriptografiaUtil {


    fun criptografiaSenha(senha:String):String{
        val encoders: MutableMap<String, PasswordEncoder> = HashMap();
        val pbkdf2Encoder = Pbkdf2PasswordEncoder("", 8, 185000, Pbkdf2PasswordEncoder.SecretKeyFactoryAlgorithm.PBKDF2WithHmacSHA256);
        encoders["pbkdf2"] = pbkdf2Encoder;
        val passwordEncoder = DelegatingPasswordEncoder("pbkdf2", encoders);
        passwordEncoder.setDefaultPasswordEncoderForMatches(pbkdf2Encoder);

        val result = passwordEncoder.encode(senha);

        return result.toString().substring("{pbkdf2}".length);
    }
}