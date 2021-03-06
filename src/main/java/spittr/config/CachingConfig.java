package spittr.config;


import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

/**
 * 缓存的配置文件
 * @author: monkey
 * @date: 2018/5/29 22:20
 */
@Configuration
//启用缓存
@EnableCaching
public class CachingConfig {

//    Spring 3.1内置了五个缓存管理器实现，如下所示：
//    SimpleCacheManager
//    NoOpCacheManager
//    ConcurrentMapCacheManager
//    CompositeCacheManager
//    EhCacheCacheManager

//    Spring 3.2引入了另外一个缓存管理器，这个管理器可以用在基于JCache（JSR-107）的缓存提供商之中。除了核心的Spring框架，
//    Spring Data又提供了两个缓存管理器：
//    RedisCacheManager（来自于Spring Data Redis项目）
//    GemfireCacheManager（来自于Spring Data GemFire项目）

    //申明缓存管理器
    //EhCacheCacheManager
//    @Bean
//    public EhCacheCacheManager cacheManager(CacheManager cm){
//        return new EhCacheCacheManager(cm);
//    }

//    @Bean
//    public EhCacheManagerFactoryBean ehcache(){
//        EhCacheManagerFactoryBean factoryBean = new EhCacheManagerFactoryBean();
//        factoryBean.setConfigLocation(new ClassPathResource("ehcache.xml"));
//        return factoryBean;
//    }

    //RedisCacheManager
    //redis缓存管理器
    @Bean
    public CacheManager cacheManager(RedisTemplate redisTemplate){
        return new RedisCacheManager(redisTemplate);
    }

    //redis连接工厂
    @Bean
    public JedisConnectionFactory redisConnectionFactory(){
        JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory();
        jedisConnectionFactory.afterPropertiesSet();
        return jedisConnectionFactory;
    }

    //redisTemplate
    @Bean
    public RedisTemplate<String,String> redisTemplate(RedisConnectionFactory connectionFactory){
        RedisTemplate<String,String> redisTemplate=new RedisTemplate<>();
        redisTemplate.setConnectionFactory(connectionFactory);
        //发现此时设置这两个属性在缓存的时候没有问题，但是从缓存中取出时有问题
//        redisTemplate.setKeySerializer(new StringRedisSerializer());
//        redisTemplate.setValueSerializer(new Jackson2JsonRedisSerializer<String>(String.class));
        redisTemplate.afterPropertiesSet();
        return redisTemplate;
    }

}
