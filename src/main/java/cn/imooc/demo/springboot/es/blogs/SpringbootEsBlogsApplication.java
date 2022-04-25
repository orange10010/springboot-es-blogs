package cn.imooc.demo.springboot.es.blogs;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.jdbc.DataSourceAutoConfiguration;
import org.springframework.boot.autoconfigure.orm.jpa.HibernateJpaAutoConfiguration;

@SpringBootApplication
public class SpringbootEsBlogsApplication {

    public static void main(String[] args) {

        SpringApplication.run(SpringbootEsBlogsApplication.class, args);
    }

}
