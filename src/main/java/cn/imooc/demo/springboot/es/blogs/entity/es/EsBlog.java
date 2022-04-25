package cn.imooc.demo.springboot.es.blogs.entity.es;

import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.elasticsearch.annotations.DateFormat;
import org.springframework.data.elasticsearch.annotations.Document;
import org.springframework.data.elasticsearch.annotations.Field;
import org.springframework.data.elasticsearch.annotations.FieldType;

import java.util.Date;

/**
 * CREATE TABLE `t_blog` (
 *   `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '自增id',
 *   `title` varchar(60) DEFAULT NULL COMMENT '博客标题',
 *   `author` varchar(60) DEFAULT NULL COMMENT '博客作者',
 *   `content` mediumtext COMMENT '博客内容',
 *   `create_time` datetime DEFAULT NULL COMMENT '创建时间',
 *   `update_time` datetime DEFAULT NULL COMMENT '更新时间',
 *   PRIMARY KEY (`id`)
 * ) ENGINE=InnoDB AUTO_INCREMENT=9 DEFAULT CHARSET=utf8mb4;
 */

@Data
@Document(indexName = "springboot_es_blog", type = "doc",//MysqlBlog写的是t_blog
        useServerConfiguration = true, createIndex = false)
public class EsBlog {

    @Id //注：data.annotation中的Id
    private int id;

    @Field(type = FieldType.Text, analyzer = "ik_smart") //使用ik分词器。用ik_max_word也差不多
    private String title;
    @Field(type = FieldType.Text, analyzer = "ik_smart")
    private String author;
    @Field(type = FieldType.Text, analyzer = "ik_smart")
    private String content;
    @Field(type = FieldType.Date, format = DateFormat.custom,
            pattern = "yyyy-MM-dd HH:mm:ss||yyyy-MM-dd||epoch_millis")
    private Date createTime;
    @Field(type = FieldType.Date, format = DateFormat.custom,
            pattern = "yyyy-MM-dd HH:mm:ss||yyyy-MM-dd||epoch_millis")
    private Date updateTime;

}