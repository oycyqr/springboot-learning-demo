package com.oycbest.springbootelasticsearch.document;

import lombok.Data;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.io.Serializable;

/**
 * @ClassName Blog
 * @Description TODO
 * @Author oyc
 * @Date 2020/12/4 22:31
 * @Version
 */
@Data
@Entity
public class Blog implements Serializable {
    private static final long serialVersionUID = 339460670228746794L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String title;
    private String content;
}