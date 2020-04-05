package core;

import javafx.scene.image.Image;
import libs.Configs;
import libs.Sprite;

import java.util.Random;

public class Alien extends Sprite {

    public int alienX;
    public int alienY = -400;
    public int speed;
    public int hit;
    public int original;
    public int ran = new Random().nextInt(10);

    public Alien()  {
        super.imgPath = "/core/alien1.png";
        super.setImage(new Image(imgPath));
    }

    public void Alienstats(){
        speed = 2 + ran;
        alienX = new Random().nextInt(400);
        hit = original;
    }

}