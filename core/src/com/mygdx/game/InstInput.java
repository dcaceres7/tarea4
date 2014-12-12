package com.mygdx.game;

import com.badlogic.gdx.scenes.scene2d.InputEvent;
import com.badlogic.gdx.scenes.scene2d.InputListener;

public class InstInput extends InputListener{
	Inst en;
	
	InstInput(Inst en){
		super();
		this.en=en;
	}
	
	@Override
	public boolean touchDown(InputEvent event, float x, float y, int pointer,
			int button) {
		// TODO Auto-generated method stub
           en.remove();
		return super.touchDown(event, x, y, pointer, button);
	}
}