package com.imooc.springbootmybatis.config;

import org.mybatis.spring.SqlSessionFactoryBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.ClassPathResource;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;

import javax.sql.DataSource;
import java.io.IOException;

/**
 * @author E470
 * @create 2018 - 05 - 14 14:50
 */
@Configuration
public class SessionFactoryConfiguration {
    @Value("${mybatis_config_file}")
    private String mybatisConfigPath;
    @Value("${mapper_path}")
    private String mapperPath;
    @Autowired
    @Qualifier("dataSource")
    private DataSource dataSource;
    @Value("${entity_package}")
    private String entityPackage;

    @Bean("sqlSessionFactory")
    public SqlSessionFactoryBean createSqlSessionFactoryBean() throws IOException {
        //创建工厂配置
        SqlSessionFactoryBean sqlSessionFactoryBean = new SqlSessionFactoryBean();
        //设置mybatis的配置路径
        sqlSessionFactoryBean.setConfigLocation(new ClassPathResource(mybatisConfigPath));
        PathMatchingResourcePatternResolver resolver = new PathMatchingResourcePatternResolver();
        //获取mapper的路径
        String packageSearchPath = PathMatchingResourcePatternResolver.CLASSPATH_ALL_URL_PREFIX + mapperPath;
        //设置mapper的路径
        sqlSessionFactoryBean.setMapperLocations(resolver.getResources(packageSearchPath));
        //设置数据源
        sqlSessionFactoryBean.setDataSource(dataSource);
        //设置实体类的路径
        sqlSessionFactoryBean.setTypeAliasesPackage(entityPackage);
        return sqlSessionFactoryBean;

    }
}
