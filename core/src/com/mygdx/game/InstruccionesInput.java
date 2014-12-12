package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;

public class InstruccionesInput extends InputListener{
	Instrucciones ini;
	boolean clic = false;
	Texture img;
	public InstruccionesInput(Instrucciones i) {
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
		return super.touchDown(event, x, y, pointer, button);
	}
	
	public boolean getClic(){
		return clic;
	}
	
	public void changeClic(){
		clic = false;
	}
}