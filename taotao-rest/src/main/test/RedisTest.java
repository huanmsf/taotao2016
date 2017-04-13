import org.junit.Before;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import redis.clients.jedis.Jedis;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

/**
 * Created by root on 17-4-12.
 */
public class RedisTest {

    private ApplicationContext applicationContext;

    @Before
    public void init() {
        applicationContext = new ClassPathXmlApplicationContext(
                "classpath:spring/applicationContext-*.xml");
    }

    @Test
    public void testJedisPool() {
        Jedis jedis = null;
        JedisPool pool = (JedisPool) applicationContext.getBean("jedisPool");
        try {
            jedis = pool.getResource();
            jedis.set("name", "lisi");
            System.out.println(jedis.get("name"));
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (jedis != null) {
                //关闭连接
                jedis.close();
            }
        }
    }

//****************************************
    @Test
    public void testJedisSingle() {

        Jedis jedis = new Jedis("47.93.47.177", 6379);
        jedis.set("name", "bar");
        String name = jedis.get("name");
        System.out.println(name);
        jedis.close();

    }


    @Test
    public void pool() {
        JedisPoolConfig config = new JedisPoolConfig();
        //最大连接数
        config.setMaxTotal(30);
        //最大连接空闲数
        config.setMaxIdle(2);

        JedisPool pool = new JedisPool(config, "47.93.47.177", 6379);
        Jedis jedis = null;
        try {
            jedis = pool.getResource();
            jedis.set("name", "lisi");
            System.out.println(jedis.get("name"));
        } catch (Exception ex) {
            ex.printStackTrace();
        } finally {
            if (jedis != null) {
                //关闭连接
                jedis.close();
            }
        }

    }
}
