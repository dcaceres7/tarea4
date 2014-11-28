package com.mygdx.game;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class Plataforma extends Image{
	
  public Plataforma(){
	super(new Texture("fondo.png"));
	this.setX(1);
	this.setY(1);
}
  @Override
  public void act(float delta){
	 super.act(delta);
	 this.setX(this.getX()-delta*5);

  }
}
