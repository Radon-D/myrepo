package example.spring.aop.concert;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@EnableAspectJAutoProxy
@ComponentScan(basePackages = "example.spring.aop.concert")
public class ConcertConfig {

//    @Bean
//    public Audience audience() {
//        return new Audience();
//    }
//
//    @Bean
//    public Performance performance() {
//        return new PerformanceImpl();
//    }

}
