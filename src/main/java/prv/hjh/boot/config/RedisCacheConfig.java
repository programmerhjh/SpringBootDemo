package prv.hjh.boot.config;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.interceptor.KeyGenerator;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.util.Arrays;

/**
 * @author 洪家豪
 * Created by HJH on 2017/10/24.
 * Redis 缓存配置类
 */
// 把该类交给Spring管理
@Configuration
// 当你在配置类(@Configuration)上使用@EnableCaching注解时，会触发一个post processor，
// 这会扫描每一个spring bean，查看是否已经存在注解对应的缓存。
// 如果找到了，就会自动创建一个代理拦截方法调用，使用缓存的bean执行处理。
@EnableCaching
public class RedisCacheConfig extends CachingConfigurerSupport {

    /**
     * 存取value为String类型所用到的RedisTemplate
     * @param connectionFactory
     * @return
     */
    @Bean
    public StringRedisTemplate stringRedisTemplate(RedisConnectionFactory connectionFactory){
        return new StringRedisTemplate(connectionFactory);
    }

    /**
     * 存取value为对象类型所用到的RedisTemplate
     * @param connectionFactory
     * @return
     */
    @Bean
    public RedisTemplate<Object, Object> redisTemplate(RedisConnectionFactory connectionFactory) {
        RedisTemplate<Object, Object> template = new RedisTemplate();
        template.setConnectionFactory(connectionFactory);

        //使用Jackson2JsonRedisSerializer来序列化和反序列化redis的value值
        Jackson2JsonRedisSerializer serializer = new Jackson2JsonRedisSerializer(Object.class);

        ObjectMapper mapper = new ObjectMapper();
        mapper.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        mapper.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        serializer.setObjectMapper(mapper);

        template.setValueSerializer(serializer);
        //使用StringRedisSerializer来序列化和反序列化redis的key值
        template.setKeySerializer(new StringRedisSerializer());
        template.afterPropertiesSet();
        return template;
    }

    /**
     * 自定义redis中key的生成器
     * @return
     */
    @Bean
    public KeyGenerator getKeyGenerator(){
        return (o, method, objects) -> {
            StringBuffer userKey = new StringBuffer();
            userKey.append("prv.hjh.users." + System.currentTimeMillis());
            return userKey.toString();
        };
    }


    /**
     * RedisCacheManager用于告诉spring boot将使用redis作为系统的缓存。
     * @param redisTemplate
     * @return
     */
    @Bean
    public CacheManager cacheManager(RedisTemplate redisTemplate) {
        String[] cacheNames = {"users"};
        RedisCacheManager rcm = new RedisCacheManager(redisTemplate, Arrays.asList(cacheNames));
        rcm.setDefaultExpiration(86400);
        //设置缓存过期时间
        //rcm.setDefaultExpiration(60);//秒
        return rcm;
    }

}
