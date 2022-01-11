package example.diandaop.sia.knights.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import example.diandaop.sia.knights.BraveKnight;
import example.diandaop.sia.knights.Knight;
import example.diandaop.sia.knights.Minstrel;
import example.diandaop.sia.knights.Quest;
import example.diandaop.sia.knights.SlayDragonQuest;

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
