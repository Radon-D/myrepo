package example.spring.aop.concert;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.DeclareParents;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class EncodeableIntroducer {

    @DeclareParents(value = "example.spring.aop.concert.Performance+", defaultImpl = DefaultEncoreable.class)
    public static Encoreable encoreable;

}
