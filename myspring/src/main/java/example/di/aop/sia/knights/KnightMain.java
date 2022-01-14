package example.di.aop.sia.knights;

import example.di.aop.sia.knights.config.KnightConfig;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class KnightMain {

    public static void main(String[] args) {
        loadFromXml();
        loadFromJavaConfig();
    }

    public static void loadFromXml() {
        ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("META-INF/spring/knights.xml");
        Knight knight = context.getBean(Knight.class);
        knight.embarkOnQuest();
        context.close();
    }

    public static void loadFromJavaConfig() {
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(KnightConfig.class);
        Knight knight = context.getBean(Knight.class);
        knight.embarkOnQuest();
        context.close();
    }

}
