package core;

import javafx.scene.canvas.GraphicsContext;
import libs.Configs;
import libs.Sprite;
import javafx.scene.image.Image;

import java.util.Random;


public class SpaceShip extends Sprite {

    public int shipX = 190;
    public int shipY = 620;

    public SpaceShip()  {
        super.imgPath = "/core/spaceship.png";
        super.setImage(new Image(imgPath));
    }

}
