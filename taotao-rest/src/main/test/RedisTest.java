public class RedisTest {
/*
    private ApplicationContext applicationContext;

    @Before
    public void init() {
        applicationContext = new ClassPathXmlApplicationContext(
                "classpath:spring/applicationContext-*.xml");
    }



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


    // 连接redis集群
    @Test
    public void testJedisCluster1() {

        JedisPoolConfig config = new JedisPoolConfig();
        // 最大连接数
        config.setMaxTotal(30);
        // 最大连接空闲数
        config.setMaxIdle(2);

        //集群结点
        Set<HostAndPort> jedisClusterNode = new HashSet<HostAndPort>();
        jedisClusterNode.add(new HostAndPort("47.93.47.177", 7001));
        jedisClusterNode.add(new HostAndPort("47.93.47.177", 7002));
        jedisClusterNode.add(new HostAndPort("47.93.47.177", 7003));
        jedisClusterNode.add(new HostAndPort("47.93.47.177", 7004));
        jedisClusterNode.add(new HostAndPort("47.93.47.177", 7005));
        jedisClusterNode.add(new HostAndPort("47.93.47.177", 7006));
        JedisCluster jc = new JedisCluster(jedisClusterNode, config);

        JedisCluster jcd = new JedisCluster(jedisClusterNode);
        jcd.set("name", "zhangsan");
        String value = jcd.get("name");
        System.out.println(value);
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


    //redis集群
    @Test
    public void testJedisCluster() {
        JedisCluster jedisCluster = (JedisCluster) applicationContext.getBean("jedisCluster");

        jedisCluster.set("name", "zhangsan");
        String value = jedisCluster.get("name");
        System.out.println(value);
    }*/
}
