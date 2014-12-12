package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class BotonIniciar extends Image{
	Texture img;
	BotonIniciarInput listen;
	BotonIniciar (Texture text){
		super(text);
		this.setX(100);
		this.setY(250);
		listen = new BotonIniciarInput(this);
		addListener(listen);
		img = text;
	}
	
	@Override
	public void act(float delta) {
		// TODO Auto-generated method stub
		super.act(delta);
	}
	
	public boolean finish(){
		return listen.getClic();
	}
}
