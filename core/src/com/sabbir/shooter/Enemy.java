package com.sabbir.shooter;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Sprite;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;

import java.util.Random;

/**
 * Created by sakib on 12/12/14.
 */
public class Enemy {
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
    }

    private int createRandomPosition() {
        Random random = new Random();
        int randomNumber = random.nextInt(ShooterGame.SCREEN_WIDTH -animatedSprite.getWidth() + 1);
        return randomNumber + animatedSprite.getWidth()/2;
    }

    public void draw(SpriteBatch batch) {
        animatedSprite.draw(batch);
    }
}
