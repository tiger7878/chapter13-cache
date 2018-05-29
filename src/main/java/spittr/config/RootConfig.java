package spittr.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

/**
 * @author: monkey
 * @date: 2018/5/29 22:39
 */
@Configuration
@ComponentScan("spittr.db")
@Import({DataConfig.class,CachingConfig.class})
public class RootConfig {

}
