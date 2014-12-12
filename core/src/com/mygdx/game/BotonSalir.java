package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class BotonSalir extends Image{
	Texture img;
	BotonSalirInput listen;
	BotonSalir (Texture text){
		super(text);
		this.setX(335);
		this.setY(130);
		listen = new BotonSalirInput(this);
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
