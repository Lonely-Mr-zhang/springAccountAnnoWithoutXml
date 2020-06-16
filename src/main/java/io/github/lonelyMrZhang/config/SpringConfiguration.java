package io.github.lonelyMrZhang.config;

/**
 * Spring中的新注解
 * Configuration
 *      作用：指定当前类是一个配置类
 * ComponentScan
 *      作用：用于通过注解指定Spring在创建容器时要扫描的包
 *      属性：
 *          value：它和basePackages的作用相同，都是用于指定创建容器时要扫描的包。使用此注解就等于在xml配置文件中配置了：
 *              <context:component-scan base-package="io.github.lonelyMrZhang"></context:component-scan>
 * Bean
 *      作用：用于把当前方法的返回值作为bean对象注入Spring的IOC容器中
 *      属性：
 *          name：用于指定bean的id，默认为当情方法名称
 *      细节：
 *          当我们使用注解配置方法时，如果方法有参数，Spring框架会去容器中查找有没有可用的bean对象，查找的方式和Autowired注解的作用时一样的
 */

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Scope;

import javax.sql.DataSource;
import java.beans.PropertyVetoException;

/**
 * @description: 配置类，作用和bean.xml一样
 * @author: lonely.mr.zhang
 * @date: 2020/6/16 11:59 上午
 */
@Configuration
@ComponentScan("io.github.lonelyMrZhang")
public class SpringConfiguration {
    /**
     * 用于创建一个QueryRunner对象
     * @param dataSource
     * @return
     */
    @Bean(name="runner")
//    @Scope("prototype")
    public QueryRunner createQueryRunner(DataSource dataSource){
        return new QueryRunner(dataSource);
    }

    /**
     * 创建数据源对象
     * @return
     */
    @Bean(name = "dataSource")
    public DataSource createDateSource(){
        try {
            ComboPooledDataSource ds = new ComboPooledDataSource();
            ds.setDriverClass("com.mysql.jdbc.Driver");
            ds.setJdbcUrl("jdbc:mysql://192.168.31.254:3306/coupling_code");
            ds.setUser("root");
            ds.setPassword("2486");
            return ds;
        } catch (Exception e) {
           throw new RuntimeException(e);
        }
    }
}
