package config;

/**
 * Spring中的新注解
 * Configuration
 *      作用：指定当前类是一个配置类
 *      细节：当配置类作为AnnotationConfigApplicationContext对象创建的参数时，该注解可以不写。在@ComponentScan({"io.github.lonelyMrZhang","config"})注解中
 *      指定扫描其他配置类时，在其他配置类上应该标上Configuration注解，Spring只有看到Configuration注解才会将这个类当作配置类
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
 *
 * Import:
 *      作用：用于导入其他的配置类
 *      属性：
 *          value：用于指定其他配置类的字节码
 *              当我们使用import的注解之后，有import注解的类是父配置类，导入的时子配置类
 * PropertySource
 *      作用：用于指定properties文件的位置
 *      书香：
 *          value:指定文件的名称和路径
 *              关键字：classpath，类路径下
 */

import com.mchange.v2.c3p0.ComboPooledDataSource;
import org.apache.commons.dbutils.QueryRunner;
import org.springframework.context.annotation.*;

import javax.sql.DataSource;

/**
 * @description: 配置类，作用和bean.xml一样
 * @author: lonely.mr.zhang
 * @date: 2020/6/16 11:59 上午
 */
//@Configuration
@Configuration
//@ComponentScan({"io.github.lonelyMrZhang","config"})
@ComponentScan("io.github.lonelyMrZhang")
@Import(JdbcConfiguration.class)
@PropertySource("classpath:jdbcConfig.properties")
public class SpringConfiguration {

}
