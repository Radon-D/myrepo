package example.bean.wiring.soundsystem;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
//@ComponentScan(basePackages = "example.bean.wiring.soundsystem")
public class CDPlayerConfig {

    @Bean
    public CompactDisc sgtPeppers() {
        return new SgtPeppers();
    }

    // 构造器注入，自动装配CompactDisc对象
    @Bean
    public CDPlayer cdPlayer(CompactDisc compactDisc) {
        return new CDPlayer(compactDisc);
    }

    // setter方法注入
//    @Bean
//    public CDPlayer cdPlayer(CompactDisc compactDisc) {
//        CDPlayer cdPlayer = new CDPlayer();
//        cdPlayer.setCd(compactDisc);
//        return cdPlayer;
//    }

    // 构造器注入，手动调用CompactDisc的@Bean方法
//    @Bean
//    public CDPlayer cdPlayer() {
//        return new CDPlayer(sgtPeppers());
//    }

}
