package example.advanced.wiring.expression;

import example.bean.wiring.soundsystem.BlankDisc;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(classes = ExpressiveConfig.class)
@ContextConfiguration("classpath:/blankdisc.xml")
public class ExpressiveTest {

    @Autowired
    BlankDisc blankDisc;

    @Test
    public void test() {
        blankDisc.play();
    }

}
