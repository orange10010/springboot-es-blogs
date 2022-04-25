package cn.imooc.demo.springboot.es.blogs;

import cn.imooc.demo.springboot.es.blogs.entity.es.EsBlog;
import cn.imooc.demo.springboot.es.blogs.repository.es.EsBlogRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Arrays;
import java.util.Iterator;

@SpringBootTest
@RunWith(SpringRunner.class)
public class SpringbootEsBlogsApplicationTests {

    private char arr2;
    @Autowired
    private EsBlogRepository esBlogRepository;

    @Test
    public void contextLoads() {
    }

    @Test
    public void testEsBlog() {

        Iterable<EsBlog> all = esBlogRepository.findAll();
        Iterator<EsBlog> iterator = all.iterator();
        while (iterator.hasNext()) {
            System.out.println(iterator.next());
        }
    }


}
