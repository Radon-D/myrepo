package example.bean.wiring.soundsystem;

import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class BlankDisc implements CompactDisc {

//    @Value("${disc.title}")
    private String title;

//    @Value("${disc.artist}")
    private String artist;

    private List<String> tracks;

    public BlankDisc() {
    }

    public BlankDisc(String title, String artist) {
        this.title = title;
        this.artist = artist;
    }

//    public BlankDisc(String title, String artist, List<String> tracks) {
//        this.title = title;
//        this.artist = artist;
//        this.tracks = tracks;
//    }

    public void setTitle(String title) {
        this.title = title;
    }

    public void setArtist(String artist) {
        this.artist = artist;
    }

    public void setTracks(List<String> tracks) {
        this.tracks = tracks;
    }

    @Override
    public void play() {
        System.out.println("Palying " + title + " by " + artist);
//        for (String track : tracks) {
//            System.out.println(track);
//        }
    }

}
