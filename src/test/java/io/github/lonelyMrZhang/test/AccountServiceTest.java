package io.github.lonelyMrZhang.test;

import config.JdbcConfiguration;
import config.SpringConfiguration;
import io.github.lonelyMrZhang.entity.Account;
import io.github.lonelyMrZhang.service.IAccountService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import java.util.List;

/**
 * 1、应用程序的入口
 *      main方法
 * 2、junit单元测试中，没有main方法也能执行
 *      junit集成了一个main方法，该方法就会判断当前测试类中那些方法有@Test注解，junit就让有Test注解的方法执行
 * 3、junit不会管我们是否采用Spring框架
 *      在执行测试方法时，junit根本不知道我们是不是使用了Spring框架，所以也不会为我们读取配置文件/配置类创建IOC容器
 * 4、由以上三点可知：
 *      当测试方法执行时，没有IOC容器，就算写了Autowrited注解，也无法实现注入，
 */

/**
 * Spring整合junit的配置
 *      1、导入Spring整合junit的jar包
 *      2、使用junit提供的注解把原有的main方法替换了，替换成Spring提供的
 *          RunWith
 *      3、告知Spring的运行器，Spring的IOC创建时基于xml还是注解的，并说明位置
 *          ContextConfiguration
 *              locations:指定xml文件的位置，加上classpath关键字，表示在类路径下
 *              classes：指定注解类所在地位置
 *
 * 当我们使用Spring 5.x版本的时候，要求junit的jar必须是4.12及以上
 */

/**
 * @description: 使用junit单元测试，测试我们的配置
 * @author: lonely.mr.zhang
 * @date: 2020/6/16 12:40 上午
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = SpringConfiguration.class)
public class AccountServiceTest {

    @Autowired
    private IAccountService accountService;

    @Test
    public void testFindAll(){
        //1、获取容器
//        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
//        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfiguration.class, JdbcConfiguration.class);
//        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        //2、得到业务层对象
//        IAccountService accountService = applicationContext.getBean("accountService", IAccountService.class);
        //3、执行方法
        List<Account> allAccount = accountService.findAllAccount();
        for (Account item:allAccount){
            System.out.println(item);
        }
    }

    @Test
    public void testFindOne(){
        //1、获取容器
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        //2、得到业务层对象
        IAccountService accountService = applicationContext.getBean("accountService", IAccountService.class);
        Account account = accountService.findAccountById(1);
        System.out.println(account);
    }

    @Test
    public void testSave(){
        //1、获取容器
//        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        //2、得到业务层对象
//        IAccountService accountService = applicationContext.getBean("accountService", IAccountService.class);
        Account account = new Account();
        account.setId(4);
        account.setName("ddd");
        account.setMoney(1000f);
        accountService.saveAccount(account);
    }


    @Test
    public void testUpdate(){
        //1、获取容器
//        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        //2、得到业务层对象
//        IAccountService accountService = applicationContext.getBean("accountService", IAccountService.class);
        Account account = accountService.findAccountById(4);
        account.setMoney(2222f);
        accountService.updateAccount(account);
    }


    @Test
    public void testDelete(){
        //1、获取容器
//        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        //2、得到业务层对象
//        IAccountService accountService = applicationContext.getBean("accountService", IAccountService.class);
        accountService.deleteAccount(5);
    }

}
