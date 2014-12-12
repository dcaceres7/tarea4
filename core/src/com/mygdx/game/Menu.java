package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class Menu extends Image{
	Texture img;
	MenuInput listen;
	Menu (Texture text){
		super(text);
		listen = new MenuInput(this);
		addListener(listen);
		img = text;
	}
	
	@Override
	public void act(float delta) {
		// TODO Auto-generated method stub
		super.act(delta);
		this.setWidth(640);
		this.setHeight(520);
		
	}
	
	public boolean finish(){
		return listen.getClic();
	}
}
