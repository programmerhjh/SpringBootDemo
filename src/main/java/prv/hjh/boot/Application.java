package prv.hjh.boot;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.PropertyAccessor;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.orm.jpa.support.OpenEntityManagerInViewFilter;
import prv.hjh.boot.domain.User;

/**
 * @author 洪家豪
 * Created by HJH on 2017/10/24.
 */
@SpringBootApplication
public class Application {

    private static final Logger LOGGER = LoggerFactory.getLogger(Application.class);

    @Bean
    public StringRedisTemplate stringRedisTemplate(RedisConnectionFactory connectionFactory){
        return new StringRedisTemplate(connectionFactory);
    }

    @Bean
    public RedisTemplate<String, User> redisTemplate(RedisConnectionFactory connectionFactory) {
        RedisTemplate<String, User> template = new RedisTemplate();
        Jackson2JsonRedisSerializer<Object> jackson2JsonRedisSerializer = new Jackson2JsonRedisSerializer<>(Object.class);
        ObjectMapper om = new ObjectMapper();
        om.setVisibility(PropertyAccessor.ALL, JsonAutoDetect.Visibility.ANY);
        om.enableDefaultTyping(ObjectMapper.DefaultTyping.NON_FINAL);
        jackson2JsonRedisSerializer.setObjectMapper(om);
        template.setConnectionFactory(connectionFactory);
        template.setKeySerializer(jackson2JsonRedisSerializer);
        template.setValueSerializer(jackson2JsonRedisSerializer);
        template.setHashKeySerializer(jackson2JsonRedisSerializer);
        template.setHashValueSerializer(jackson2JsonRedisSerializer);
        template.afterPropertiesSet();
        return template;
    }

    public static void main(String[] args) {
        SpringApplication.run(Application.class, args);
    }

    @Bean
    public OpenEntityManagerInViewFilter openEntityManagerInViewFilter() {
        return new OpenEntityManagerInViewFilter();
    }

}