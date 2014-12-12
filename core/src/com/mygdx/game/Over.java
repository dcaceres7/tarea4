package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class Over extends Image{
	Over (){
		super(new Texture("over.png"));
		this.setX(1);
		this.setY(1);
	}
	
	public void act(float delta){
		super.act(delta);
		this.setY(0);
		this.setX(0);
		this.setSize(650, 480);
	}
}