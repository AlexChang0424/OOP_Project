package core;

import javafx.scene.image.Image;
import libs.Sprite;

public class Bullet extends SpaceShip {

    public int bulletspeed = 5;
    public int bulletY = shipY-20;
    public int bulletX = shipX+35;

    public Bullet()  {
        super.imgPath = "/core/bullet.png";
        super.setImage(new Image(imgPath));
    }

    public void shoot(int shipX){
        bulletY = shipY-20;
        bulletX = shipX+35;
    }

}
