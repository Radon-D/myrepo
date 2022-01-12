package example.bean.wiring.soundsystem;

import org.springframework.stereotype.Component;

@Component
public class CDPlayer implements MediaPlayer {

    private CompactDisc cd;

    public CDPlayer() {
    }

//    @Autowired
    public CDPlayer(CompactDisc cd) {
        this.cd = cd;
    }

    public void setCd(CompactDisc cd) {
        this.cd = cd;
    }

    @Override
    public void play() {
        cd.play();
    }

}
