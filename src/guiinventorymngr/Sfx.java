package guiinventorymngr;

import java.io.File;
import javafx.scene.media.Media;
import javafx.scene.media.MediaPlayer;

public class Sfx {

    public static void play(String s) {
        Media sound = new Media(new File(s).toURI().toString());
        MediaPlayer sfx = new MediaPlayer(sound);
        sfx.play();
    }

}
