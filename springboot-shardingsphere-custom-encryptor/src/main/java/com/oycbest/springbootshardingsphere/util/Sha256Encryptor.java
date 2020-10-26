package com.oycbest.springbootshardingsphere.util;

import lombok.Getter;
import lombok.Setter;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.shardingsphere.encrypt.strategy.spi.Encryptor;

import java.util.Properties;

/**
 * @ClassName Sha256Encryptor
 * @Description Sha256Encryptor
 * @Author oyc
 * @Date 2020/10/26 10:17
 * @Version
 */
@Getter
@Setter
public final class Sha256Encryptor implements Encryptor {

    private Properties properties = new Properties();

    @Override
    public void init() {

    }

    @Override
    public String encrypt(final Object plaintext) {
        if (null == plaintext) {
            return null;
        }
        return DigestUtils.sha256Hex(String.valueOf(plaintext));
    }

    @Override
    public Object decrypt(final String ciphertext) {
        return ciphertext;
    }

    @Override
    public String getType() {
        return "SHA256" ;
    }

}
