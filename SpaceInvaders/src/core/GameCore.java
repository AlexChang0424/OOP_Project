package core;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.paint.Color;
import libs.Configs;
import libs.CoreFunc;
import libs.GameText;

import javax.swing.*;
import java.util.ArrayList;
import java.util.Random;

public class GameCore implements CoreFunc {

    // Main Game variables should be here
    Background background = new Background();
    Alien aliens[] = new Alien[10];
    SpaceShip ship = new SpaceShip();
    Bullet bullet= new Bullet();

    GameText text = new GameText(Color.ORANGE,Color.ORANGE);
    int textX = 10;
    int textY = 50;
    int fontSize = 30;
    int total = -7;
    int score = -7;
    int level =1;

    @Override
    public void init(GraphicsContext gc) {
        // initialize objects (initial position, initial size, etc)
        background.resize(Configs.appWidth, Configs.appHeight);
        background.render(gc,0,0);

        for(int i=0;i<8;i++){
            aliens[i] = new Alien();
            aliens[i].Alienstats();
            aliens[i].resize(0.2);
            aliens[i].render(gc , aliens[i].alienX, aliens[i].alienY);
        }


        ship.resize(0.2 );
        ship.render(gc, ship.shipX, ship.shipY);

        text.setText(gc,"Score : " + total, fontSize,textX,textY);
        text.setText(gc,"Level : " + level, fontSize,textX,textY+50);
    }

    @Override
    public void animate(GraphicsContext gc, int time, ArrayList input) {
        // any animations and keyboard controls should be here

        background.render(gc,0,0);
        ship.render(gc, ship.shipX, ship.shipY);

        text.setText(gc,"Score : " + total, fontSize,textX,textY);
        text.setText(gc,"Level : " + level, fontSize,textX,textY+40);
        int levelpass = 0;
        switch(level){
            case 1: bullet.bulletspeed = 2;
                    for(int a=0;a<8;a++){
                        aliens[a].original=1;
                    }
                    levelpass=game(gc,input,5);
                    if(levelpass==1){
                        level++;
                    }
                    break;

            case 2: bullet.bulletspeed = 4;
                    for(int a=0;a<8;a++){
                        aliens[a].original=2;
                    }
                    levelpass=game(gc,input,10);
                    if(levelpass==1){
                        level++;
                    }
                    break;

            case 3: bullet.bulletspeed = 6;
                    for(int a=0;a<8;a++){
                        aliens[a].original=3;
                    }
                    levelpass=game(gc,input,15);
                    if(levelpass==1){
                        level++;
                    }
                    break;

            case 4: bullet.bulletspeed = 8;
                    for(int i=0;i<8;i++) {
                        aliens[i].speed = 4 + aliens[i].ran;
                    }
                    levelpass=game(gc,input,20);
                    if(levelpass==1){
                        level++;
                    }
                    break;

            case 5: levelpass=game(gc,input,30);
                    if(levelpass==1){
                        level++;
                    }
                    break;

            case 6: bullet.bulletspeed = 10;
                    for(int a=0;a<8;a++){
                        aliens[a].original=5;
                    }
                    for(int i=0;i<8;i++) {
                        aliens[i].speed = 6 + aliens[i].ran;
                    }
                    game(gc,input,1000);
                    break;

            default:    System.exit(1);
                        break;

        }

    }

    public int game(GraphicsContext gc, ArrayList input, int wave){

        int num = new Random().nextInt(7)+1;

        if(bullet.bulletY<50){
            bullet.shoot(ship.shipX);
        }

        if (input.contains("LEFT") && ship.shipX>0) {
            ship.shipX -= 5;
        }
        else if (input.contains("RIGHT") && ship.shipX<Configs.appWidth-75){
            ship.shipX += 5;
        }
        for(int i=0;i<num;i++) {
            if (aliens[i].alienY >= Configs.appHeight) {
                aliens[i].alienY = -200;
                aliens[i].alienX = new Random().nextInt(430);
            }
        }

        for(int i=0;i<8;i++){
            if (ship.collide(aliens[i])) {
                JOptionPane.showMessageDialog(null, "GAME OVER, YOUR SCORE : "+ total);
                System.exit(0);
            }
            if (!bullet.collide(aliens[i])) {
                aliens[i].render(gc, aliens[i].alienX, aliens[i].alienY += aliens[i].speed);
                bullet.render(gc, bullet.bulletX, bullet.bulletY -= bullet.bulletspeed);
            }
            else {
                aliens[i].hit--;
                bullet.shoot(ship.shipX);
            }
            if (aliens[i].hit == 0) {
                aliens[i].hit = aliens[i].original;
                aliens[i].alienY = -500;
                score++;
                total++;
            }

        }
        if(score == wave){
            score = 0;
            return 1;
        }
        return 0;
    }

}
