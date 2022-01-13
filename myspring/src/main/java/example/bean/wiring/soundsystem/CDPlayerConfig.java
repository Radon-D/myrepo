package example.bean.wiring.soundsystem;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@Configuration
//@Import(CDConfig.class)
@ImportResource("classpath:/cdplayerconfig.xml")
public class CDPlayerConfig {

    // 构造器注入，自动装配CompactDisc对象
    @Bean
    public CDPlayer cdPlayer(CompactDisc compactDisc) {
        return new CDPlayer(compactDisc);
    }

    // setter方法注入
//    @Bean
//    public CDPlayer cdPlayer(CompactDisc compactDisc) {
//        CDPlayer cdPlayer = new CDPlayer();
//        cdPlayer.setCompactDisc(compactDisc);
//        return cdPlayer;
//    }

    // 构造器注入，手动调用CompactDisc的@Bean方法
//    @Bean
//    public CDPlayer cdPlayer() {
//        return new CDPlayer(sgtPeppers());
//    }

}
