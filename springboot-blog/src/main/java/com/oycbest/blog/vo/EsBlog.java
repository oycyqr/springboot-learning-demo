package com.oycbest.blog.vo;


import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;

/**
 * @ClassName: EsBlog
 * @Description: Blog 文档实体类
 * @Author oyc
 * @Date 2020/12/25 17:06
 * @Version 1.0
 */
@Data
@Document(indexName = "blog_index", type = "blog")
public class EsBlog {

    @Id
    private int id;
    /**
     * 是否索引: 看该域是否能被搜索, index = true（默认为true）
     * 是否分词: 表示搜索的时候是整体匹配还是单词匹配
     * 是否存储: 是否在页面上显示
     */
    @Field(index = true, analyzer = "ik_smart", searchAnalyzer = "ik_smart")
    private String title;

    @Field(analyzer = "ik_smart", searchAnalyzer = "ik_smart")
    private String content;

    public EsBlog() {
    }

    public EsBlog(int id, String title, String content) {
        this.id = id;
        this.title = title;
        this.content = content;
    }

}