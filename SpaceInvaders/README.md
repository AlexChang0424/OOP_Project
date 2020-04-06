# OOP Project SpaceInvaders

This is a classic retro spaceship shooter game where you control a spaceship through space.
Your main objective in the game is to stay alive as long as possible by avoiding and shooting down aliens while they traversing down the screen.As you defeat more aliens,they will become faster, will require more hits to kill them but you will also shoot faster in the process.
 You have only one life and if you collide with the alien you are dead and a pop-up window will appear telling you your final score and the game ends there.

# The controls :

Bullet firing is automated and you just have to control the Spaceship using the 'LEFT' (<---) and 'RIGHT' (--->)  arrow keys to move left and right.


# Developers of this project :

This project is developed and maintained by Khor Ji Jun(19000582) and Chang Kwong Ming(18001074).

## The various classes used to make this project :
* `Alien.java` - attributes belonging to the alien is stored here.(Eg. alienX position,alienY position,alien's speed,its hitpoint)
* `Background.java` - contains the code to get background picture.
* `Spaceship.java` - contains attributes of the spaceship(Eg. shipX position, shipY position)
* `Bullet.java` - has attributes of bullet used(Eg. firing position x and y, bulletspeed)
* `GameCore.java` - consists of all the codes to make the game and implements CoreFunc.java
* `Configs.java` - has all the information about the application(Eg. appheight, appwidth, name)
* `CoreFunc.java` - consist of codes for the interface
* `GameText.java` - a class used to print out all text used on the application window
* `Sprite.java`- it is a class used to make the objects appear on the application window.Every other object used in the game extends Sprite class


