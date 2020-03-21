package com.xiaokunliu.springdata.redis;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.data.redis.core.StringRedisTemplate;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringBootTest
public class SpringRedisTest {

    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private StringRedisTemplate stringRedisTemplate;

    @Test
    public void testRedisTemplate(){
        System.out.println(redisTemplate);
        System.out.println(stringRedisTemplate);
//        redisTemplate.opsForZSet().
//        redisTemplate.executePipelined(new RedisCallback<Object>() {
//            @Override
//            public Object doInRedis(RedisConnection redisConnection) throws DataAccessException {
//                return null;
//            }
//        });
    }

//    自动根据方法生成缓存，value的值就是缓存到redis中的key
//    @RequestMapping("/getUser")
//    @Cacheable(value="user-key")
//    public User getUser() {
//        User user=userRepository.findByUserName("aa");
//        System.out.println("若下面没出现“无缓存的时候调用”字样且能打印出数据表示测试成功");
//        return user;
//    }
}
