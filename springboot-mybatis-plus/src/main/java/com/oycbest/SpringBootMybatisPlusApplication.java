package com.oycbest;

import com.baomidou.mybatisplus.core.toolkit.AES;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class SpringBootMybatisPlusApplication {

    public static void main(String[] args) {

        // 生成 16 位随机 AES 密钥
//        String randomKey = AES.generateRandomKey();
        String randomKey = "a469408fff97d86f";

        // 随机密钥加密
//        randomKey: a469408fff97d86f ,
//        url: ib3WahyAm+ykppYtwIzmfV2okR3Ft9c0u4zmnmj5mDfhzvR4vlA2dIBCOLkvo6gzQYlyNxIMASQ23/yix9lLlkizAMU5hpKgrV5vbs6gaSEEDYlGyQtkLJSquV4N5nzlWvtoiiEzZ4P5XWpkadMBIGDiHwUKOf4QndLuzEW2EcDLL4tkWU9zZ/gdHemAE266
//        username: S52Ob1/3YW3g7+iMMogsrw==
//        password: WQs5me3mnnbiylPFK2magQ==

                String url = AES.encrypt("jdbc:mysql://146.56.192.87:3306/oyc?useUnicode=true&characterEncoding=utf8&zeroDateTimeBehavior=convertToNull&serverTimezone=GMT%2B8", randomKey);
        String username = AES.encrypt("oyc", randomKey);
        String password = AES.encrypt("123456", randomKey);

        System.out.println(String.format("randomKey: %s ,url: %s ,username: %s ,password: %s",randomKey,url,username,password));

        SpringApplication.run(SpringBootMybatisPlusApplication.class, args);
    }

}
