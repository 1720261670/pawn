package com.config;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

@Configuration
public class DruidConfig {
    @Bean(name = "druidDataSource")
    //读取properties文件中的以spring.datasource 为前缀的内容构建的数据源
    @ConfigurationProperties(prefix = "spring.datasource")//启动包
    public DataSource druidDataSource(){
        System.out.println("druid dataSource 数据源加载");//重启查看数据源的加载
        DruidDataSource dataSource = new DruidDataSource();

//        //可选 创建filter类的集合
//        List<Filter> list = new ArrayList<>();
//        list.add(wallFilter());
//        //设置filter
//        dataSource.setProxyFilters(list);

        return dataSource;
    }
    /**
     * 设置允许执行多条sql语句（可选）
     */
//    @Bean
//    public WallFilter wallFilter(){
//        WallFilter wallFilter = new WallFilter();
//        WallConfig config = wallFilter.getConfig();
//        config.setMultiStatementAllow(true);
//        return wallFilter;
//    }
}
