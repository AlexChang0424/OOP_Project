package libs;

import javafx.geometry.Rectangle2D;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

import javafx.scene.media.AudioClip;
import java.nio.file.Paths;

public class Sprite extends ImageView {

    int xpos;
    int ypos;

    public String imgPath;
    Configs config = new Configs();

    public void render(GraphicsContext gc, int x, int y) {
        gc.drawImage(this.getImage(), x, y);
        this.ypos = y;
        this.xpos = x;
    }

    public void resize(double factor) {
        double newdim = this.getImage().getHeight() * factor;
        this.setImage(new Image(this.imgPath, newdim, newdim, true, false));
    }

    public void resize(int width, int height) {
        Image tmp = new Image(this.imgPath);
        this.setImage(new Image(this.imgPath, width, height, false, true));
    }

    public Rectangle2D getBoundary() {
        return new Rectangle2D(this.xpos, this.ypos, this.getImage().getWidth(), this.getImage().getHeight());
    }

    public boolean collide(Sprite sprite) {
        return (this.getBoundary().intersects(sprite.getBoundary()));
    }


}
