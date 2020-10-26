package com.oycbest.springbootshardingsphere.util;

import cn.hutool.crypto.digest.HMac;
import cn.hutool.crypto.digest.HmacAlgorithm;
import lombok.Getter;
import lombok.Setter;
import org.apache.commons.codec.digest.DigestUtils;
import org.apache.shardingsphere.encrypt.strategy.spi.QueryAssistedEncryptor;

import java.time.LocalDateTime;
import java.util.Properties;

/**
 * @ClassName Sha256RandomEncryptor
 * @Description Sha256RandomEncryptor
 * @Author oyc
 * @Date 2020/10/26 10:23
 * @Version
 */
@Getter
@Setter
public final class Sha256RandomEncryptor implements QueryAssistedEncryptor {

    private Properties properties = new Properties();

    @Override
    public String queryAssistedEncrypt(final String plaintext) {
        if (null == plaintext) {
            return null;
        }
        // 原始字符串
        return DigestUtils.sha256Hex(String.valueOf(plaintext));
    }

    @Override
    public void init() {

    }

    @Override
    public String encrypt(final Object plaintext) {
        if (null == plaintext) {
            return null;
        }
        // 原始字符串+变动因子
        byte[] bytes = LocalDateTime.now().toString().getBytes();
        HMac hMac = new HMac(HmacAlgorithm.HmacSHA256, bytes);
        return hMac.digestHex(String.valueOf(plaintext));
    }

    @Override
    public Object decrypt(final String ciphertext) {
        return ciphertext;
    }

    @Override
    public String getType() {
        return "SHA256_RANDOM";
    }

}
