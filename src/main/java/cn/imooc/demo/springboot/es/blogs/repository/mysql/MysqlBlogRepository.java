package cn.imooc.demo.springboot.es.blogs.repository.mysql;

import cn.imooc.demo.springboot.es.blogs.entity.mysql.MysqlBlog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface MysqlBlogRepository extends JpaRepository<MysqlBlog,Integer> {

    // 添加HQL表达式(因为spring-data-jpa是基于hibernate实现的）
    @Query("select e from MysqlBlog e order by e.createTime desc")
    List<MysqlBlog> queryAll();

    @Query("select e from MysqlBlog e where e.title" +
            " like concat('%',:keyword,'%') or e.content like concat('%',:keyword,'%')")
    List<MysqlBlog> queryBlogs(@Param("keyword") String keyword);
}
