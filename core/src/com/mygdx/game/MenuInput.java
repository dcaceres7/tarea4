package com.mygdx.game;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;

public class MenuInput extends InputListener{
	Menu ini;
	boolean clic = false;
	public MenuInput(Menu i) {
		super();
		ini = i;
	}
	
	public boolean touchDown(InputEvent event, float x, float y, int pointer,
			int button) {
		// TODO Auto-generated method stub
		//System.out.println("Touch Down");
		//Desaparecer
		ini.remove();
		clic = true;
		return super.touchDown(event, x, y, pointer, button);
	}
	
	public boolean getClic(){
		return clic;
	}
}
