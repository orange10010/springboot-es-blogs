package cn.imooc.demo.springboot.es.blogs.entity.mysql;

import lombok.Data;

import javax.persistence.*;
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
@Table(name = "t_blog")
@Entity
public class MysqlBlog {

    @Id // 这里的id是javax中的
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String title;
    private String author;
    @Column(columnDefinition = "mediumtext")
    private String content;
    private Date createTime;
    private Date updateTime;
}
