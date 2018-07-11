package com.imooc.springbootmybatis.config;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;


/**
 * @author E470
 * redis配置
 * @create 2018 - 05 - 17 16:59
 */
@Configuration
@EnableAutoConfiguration
@EnableCaching
public class RedisConfig  extends CachingConfigurerSupport {
//    @Value("${spring_redis_host}")
//    private String host;
//
//    @Value("${spring_redis_port}")
//    private int port;
//
//    @Value("${spring_redis_timeout}")
//    private int timeout;
//
//    @Value("${spring_redis_database}")
//    private int database;
//
//    @Value("${spring_redis_password}")
//    private String password;
//
//    @Value("${spring_redis_sentinel_nodes}")
//    private String redisNodes;
//
//    @Value("${spring_redis_sentinel_master}")
//    private String master;
//
//
//    /**
//     * redis哨兵配置
//     * @return
//     */
//    @Bean
//    public RedisSentinelConfiguration redisSentinelConfiguration(){
//        RedisSentinelConfiguration configuration = new RedisSentinelConfiguration();
//        String[] host = redisNodes.split(",");
//        for(String redisHost : host){
//            String[] item = redisHost.split(":");
//            String ip = item[0];
//            String port = item[1];
//            configuration.addSentinel(new RedisNode(ip, Integer.parseInt(port)));
//        }
//        configuration.setMaster(master);
//        return configuration;
//    }
//
//    /**
//     * 连接redis的工厂类
//     *
//     * @return
//     */
//    @Bean
//    public JedisConnectionFactory jedisConnectionFactory() {
//        JedisConnectionFactory factory = new JedisConnectionFactory(redisSentinelConfiguration());
//        factory.setHostName(host);
//        factory.setPort(port);
//        factory.setTimeout(timeout);
//        factory.setPassword(password);
//        factory.setDatabase(database);
//        return factory;
//    }
//
//    /**
//     * 配置RedisTemplate
//     * 设置添加序列化器
//     * key 使用string序列化器
//     * value 使用Json序列化器
//     * 还有一种简答的设置方式，改变defaultSerializer对象的实现。
//     *
//     * @return
//     */
//    @Bean
//    public RedisTemplate<Object, Object> redisTemplate() {
//        //StringRedisTemplate的构造方法中默认设置了stringSerializer
//        RedisTemplate<Object, Object> template = new RedisTemplate<>();
//        //设置开启事务
//        template.setEnableTransactionSupport(true);
//        //set key serializer
//        StringRedisSerializer stringRedisSerializer = new StringRedisSerializer();
//        template.setKeySerializer(stringRedisSerializer);
//        template.setHashKeySerializer(stringRedisSerializer);
//        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);
//        ObjectMapper objectMapper = new ObjectMapper();
//        objectMapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
//        objectMapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
//
//        jackson2JsonRedisSerializer.setObjectMapper(objectMapper);
//
//        //set value serializer
////        template.setDefaultSerializer(jackson2JsonRedisSerializer);
//        template.setValueSerializer(jackson2JsonRedisSerializer);
//        template.setHashValueSerializer(jackson2JsonRedisSerializer);
//
//        template.setConnectionFactory(jedisConnectionFactory());
//        template.afterPropertiesSet();
//        return template;
//    }
//
//    /**
//     * 设置RedisCacheManager
//     * 使用cache注解管理redis缓存
//     *
//     * @return
//     */
////    @Bean
////    public RedisCacheManager cacheManager() {
////        RedisCacheManager redisCacheManager = new RedisCacheManager(redisTemplate());
////        return redisCacheManager;
////    }
//
//    /**
//     * 自定义生成redis-key
//     *
//     * @return
//     */
//    @Override
//    public KeyGenerator keyGenerator() {
//        return new KeyGenerator() {
//            @Override
//            public Object generate(Object o, Method method, Object... objects) {
//                StringBuilder sb = new StringBuilder();
//                sb.append(o.getClass().getName()).append(".");
//                sb.append(method.getName()).append(".");
//                for (Object obj : objects) {
//                    sb.append(obj.toString());
//                }
//                System.out.println("keyGenerator=" + sb.toString());
//                return sb.toString();
//            }
//        };
//    }
    /**
     * RedisTemplate配置
     *
     * @param redisFactory
     * @return
     */
    @Bean
    //@SuppressWarnings({ "rawtypes", "unchecked" })
    public RedisTemplate<String, String> redisTemplate(RedisConnectionFactory redisFactory){
       //参数是配置文件里面的信息被封装成一个redis工厂
        StringRedisTemplate template = new StringRedisTemplate(redisFactory);
        Jackson2JsonRedisSerializer jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer(Object.class);

        ObjectMapper om = new ObjectMapper();
        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        jackson2JsonRedisSerializer.setObjectMapper(om);

        template.setValueSerializer(jackson2JsonRedisSerializer);
        template.afterPropertiesSet();
        return template;
    }
}
