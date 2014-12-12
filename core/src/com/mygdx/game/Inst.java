package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class Inst extends Image {

	public Inst(Texture texture){
		super(texture);
		addListener(new InstInput(this));
	}
	
	@Override
	public void act(float delta){
		super.act(delta);
		this.setX(this.getX()+1);
		this.setY(this.getY()+1);
	}
	
}

