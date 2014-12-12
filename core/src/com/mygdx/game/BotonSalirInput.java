package com.mygdx.game;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;

public class BotonSalirInput extends InputListener{
	BotonSalir ini;
	boolean clic = false;
	public BotonSalirInput(BotonSalir i) {
		super();
		ini = i;
	}
	
	public boolean touchDown(InputEvent event, float x, float y, int pointer,
			int button) {
		// TODO Auto-generated method stub
		//System.out.println("Touch Down");
		//Desaparecer
		//ini.remove();
		clic = true;
		System.exit(0);
		return super.touchDown(event, x, y, pointer, button);
	}
	
	public boolean getClic(){
		return clic;
	}
}