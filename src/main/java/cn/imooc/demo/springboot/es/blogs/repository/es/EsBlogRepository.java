package cn.imooc.demo.springboot.es.blogs.repository.es;

import cn.imooc.demo.springboot.es.blogs.entity.es.EsBlog;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

public interface EsBlogRepository extends ElasticsearchRepository<EsBlog,Integer> {
}
