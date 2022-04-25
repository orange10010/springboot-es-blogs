package cn.imooc.demo.springboot.es.blogs.controller;

import cn.imooc.demo.springboot.es.blogs.entity.mysql.MysqlBlog;
import cn.imooc.demo.springboot.es.blogs.repository.mysql.MysqlBlogRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class IndexController {

    @Autowired
    private MysqlBlogRepository mysqlBlogRepository;

    @RequestMapping("/")
    public String index() {
        List<MysqlBlog> all = mysqlBlogRepository.findAll();
        System.out.println(all.size());
        return "index.html";
    }
}
