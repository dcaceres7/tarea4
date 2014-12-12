package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class Instrucciones extends Image{
	Texture img;
	InstruccionesInput listen;
	Instrucciones (Texture text){
		super(text);
		this.setX(190);
		this.setY(198);
		listen = new InstruccionesInput(this);
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
	
	public void changeClic(){
		listen.changeClic();
	}
}
