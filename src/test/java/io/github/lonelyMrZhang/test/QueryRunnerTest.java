package io.github.lonelyMrZhang.test;

import config.SpringConfiguration;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

/**
 * @description:
 * @author: lonely.mr.zhang
 * @date: 2020/6/16 12:56 下午
 */
public class QueryRunnerTest {

    @Test
    public void testQueryRunner(){
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        Object runner1 = applicationContext.getBean("runner");
        Object runner2 = applicationContext.getBean("runner");
        System.out.println(runner1==runner2);
    }
}
