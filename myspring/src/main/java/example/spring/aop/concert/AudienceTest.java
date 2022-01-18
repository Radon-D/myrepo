package example.spring.aop.concert;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = ConcertConfig.class)
public class AudienceTest {

    @Autowired
    private Performance performance;

    @Autowired
    private TrackCounter trackCounter;

    @Autowired
    private BlankDisc blankDisc;

    @Test
    public void testPerformance() {
        performance.perform();
    }

    @Test
    public void testTrackCounter() {
        blankDisc.playTrack(1);
        blankDisc.playTrack(2);
        blankDisc.playTrack(3);
        blankDisc.playTrack(3);
        blankDisc.playTrack(3);
        blankDisc.playTrack(2);
        blankDisc.playTrack(2);
        blankDisc.playTrack(2);
        blankDisc.playTrack(2);
        blankDisc.playTrack(2);

        System.out.println(trackCounter.getPlayCount(1));
        System.out.println(trackCounter.getPlayCount(2));
        System.out.println(trackCounter.getPlayCount(3));
    }

    @Test
    public void testDeclareParents() {
        performance.perform();
        Encoreable encoreable = (Encoreable)performance;
        encoreable.performEncore();
    }

}
