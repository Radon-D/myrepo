package example.bean.wiring.soundsystem;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class CDConfig {

    @Bean
    public CompactDisc sgtPeppers() {
        return new SgtPeppers();
    }

}
