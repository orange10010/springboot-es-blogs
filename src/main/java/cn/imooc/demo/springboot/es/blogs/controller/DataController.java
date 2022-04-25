package cn.imooc.demo.springboot.es.blogs.controller;

import cn.imooc.demo.springboot.es.blogs.entity.es.EsBlog;
import cn.imooc.demo.springboot.es.blogs.entity.mysql.MysqlBlog;
import cn.imooc.demo.springboot.es.blogs.repository.es.EsBlogRepository;
import cn.imooc.demo.springboot.es.blogs.repository.mysql.MysqlBlogRepository;
import lombok.Data;
import org.elasticsearch.common.inject.internal.Stopwatch;
import org.elasticsearch.index.query.BoolQueryBuilder;
import org.elasticsearch.index.query.QueryBuilders;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.util.StopWatch;
import org.springframework.web.bind.annotation.*;

import java.util.HashMap;
import java.util.List;
import java.util.Optional;


@RestController
public class DataController {

    @Autowired
    private MysqlBlogRepository mysqlBlogRepository;

    @Autowired
    private EsBlogRepository esBlogRepository;

    @GetMapping("/blogs")
    public Object blogs() {
        List<MysqlBlog> mysqlBlogs = mysqlBlogRepository.queryAll();
        return mysqlBlogs;
    }

    @PostMapping("/search")
    public Object search(@RequestBody Param param) {
        HashMap<Object, Object> map = new HashMap<>();
        StopWatch stopWatch = new StopWatch();
        stopWatch.start();
        String type = param.getType();
        if ("mysql".equalsIgnoreCase(type)) {
            // mysql
            List<MysqlBlog> mysqlBlogs = mysqlBlogRepository.queryBlogs(param.getKeyword());
            map.put("list", mysqlBlogs);

        } else if("es".equalsIgnoreCase(type)) {
            // es
            BoolQueryBuilder builder = QueryBuilders.boolQuery();
            builder.should(QueryBuilders.matchPhraseQuery("title", param.getKeyword()));
            builder.should(QueryBuilders.matchPhraseQuery("content", param.getKeyword()));
            Page<EsBlog> search = (Page<EsBlog>) esBlogRepository.search(builder);
            List<EsBlog> content = search.getContent();
            map.put("list", content);
        } else {
            return "I don't understand";
        }

        stopWatch.stop();
        long totalTimeMillis = stopWatch.getTotalTimeMillis();
        map.put("duration", totalTimeMillis);
        return map;
    }

    @GetMapping("/blog/{id}")
    public Object blog(@PathVariable("id") Integer id) {
        Optional<MysqlBlog> byId = mysqlBlogRepository.findById(id);
        MysqlBlog blog = byId.get();
        return blog;
    }

    @Data
    public static class Param {
        // mysql 或 es
        private String type;
        // 输入的关键字
        private  String keyword;
    }
}

