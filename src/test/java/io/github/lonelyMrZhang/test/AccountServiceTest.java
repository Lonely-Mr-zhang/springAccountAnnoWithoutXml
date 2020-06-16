package io.github.lonelyMrZhang.test;

import io.github.lonelyMrZhang.config.SpringConfiguration;
import io.github.lonelyMrZhang.entity.Account;
import io.github.lonelyMrZhang.service.IAccountService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import java.util.List;

/**
 * @description:
 * @author: lonely.mr.zhang
 * @date: 2020/6/16 12:40 上午
 */
public class AccountServiceTest {

    @Test
    public void testFindAll(){
        //1、获取容器
//        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean.xml");
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        //2、得到业务层对象
        IAccountService accountService = applicationContext.getBean("accountService", IAccountService.class);
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
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        //2、得到业务层对象
        IAccountService accountService = applicationContext.getBean("accountService", IAccountService.class);
        Account account = new Account();
        account.setId(4);
        account.setName("ddd");
        account.setMoney(1000f);
        accountService.saveAccount(account);
    }


    @Test
    public void testUpdate(){
        //1、获取容器
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        //2、得到业务层对象
        IAccountService accountService = applicationContext.getBean("accountService", IAccountService.class);
        Account account = accountService.findAccountById(4);
        account.setMoney(2222f);
        accountService.updateAccount(account);
    }


    @Test
    public void testDelete(){
        //1、获取容器
        ApplicationContext applicationContext = new AnnotationConfigApplicationContext(SpringConfiguration.class);
        //2、得到业务层对象
        IAccountService accountService = applicationContext.getBean("accountService", IAccountService.class);
        accountService.deleteAccount(5);
    }

}
