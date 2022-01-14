package example.di.aop.sia.knights.config;

import example.di.aop.sia.knights.BraveKnight;
import example.di.aop.sia.knights.Knight;
import example.di.aop.sia.knights.Quest;
import example.di.aop.sia.knights.SlayDragonQuest;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import example.di.aop.sia.knights.Minstrel;

@Configuration
public class KnightConfig {

    @Bean
    public Knight knight() {
        return new BraveKnight(quest());
    }

    @Bean
    public Quest quest() {
        return new SlayDragonQuest(System.out);
    }

    @Bean
    public Minstrel minstrel() {
        return new Minstrel(System.out);
    }

}
