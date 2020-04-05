package core;

import javafx.scene.image.Image;
import libs.Sprite;

public class Background extends Sprite {

    public Background()  {
        super.imgPath = "/core/spacebck.png";
        super.setImage(new Image(imgPath));
    }

}
