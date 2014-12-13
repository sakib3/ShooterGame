package com.sabbir.shooter;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.math.Vector2;

import java.util.Random;

/**
 * Created by sakib on 12/12/14.
 */
public class Enemy {
    private static final float ENEMY_SPEED = 250 ;
    private  Texture enemyTexture;
    private AnimatedSprite animatedSprite;
    public Enemy(Texture enemyTexture) {
        this.enemyTexture = enemyTexture;
        spawn();
    }

    private void spawn() {
        Sprite enemySprite = new Sprite(enemyTexture);
        this.animatedSprite = new AnimatedSprite(enemySprite);
        int xPosition = createRandomPosition();
        animatedSprite.setPosition(xPosition,ShooterGame.SCREEN_HEIGHT-animatedSprite.getHight());
        animatedSprite.setVelocity(new Vector2(ENEMY_SPEED,0));
    }

    private int createRandomPosition() {
        Random random = new Random();
        int randomNumber = random.nextInt(ShooterGame.SCREEN_WIDTH -animatedSprite.getWidth() + 1);
        return randomNumber + animatedSprite.getWidth()/2;
    }

    public void draw(SpriteBatch batch) {
        animatedSprite.draw(batch);
    }

    public void update() {
        animatedSprite.move();
    }
}
