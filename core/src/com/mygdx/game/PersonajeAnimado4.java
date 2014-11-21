package com.mygdx.game;
import java.util.ArrayList;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class PersonajeAnimado4 extends Actor{
	ArrayList<Image> imag;
	int dibujo_actual=0;
	float llamadas_act=0;
	
  public PersonajeAnimado4(){
	super();
	
	imag=new ArrayList<Image>();
	
	imag.add(new Image(new Texture("perder01.png")));
	imag.add(new Image(new Texture("perder02.png")));
	imag.add(new Image(new Texture("perder03.png")));
	imag.add(new Image(new Texture("perder04.png")));
	imag.add(new Image(new Texture("perder05.png")));
	
  }
  
  public void act(float delta){
	  super.act(delta);
	  //System.out.println(delta);
	  llamadas_act+=delta;
	  if(llamadas_act>0.1f){
	  dibujo_actual++;
	  llamadas_act=0;
	  }
	  if(dibujo_actual>=imag.size()){
		  dibujo_actual=0;
	  }
	  
	  this.setX(this.getX()+1);
  }
  
  public void draw(Batch batch,float parentAlpha){
	  super.draw(batch, parentAlpha);
	  imag.get(dibujo_actual).setX(this.getX());
	  //imag.get(dibujo_actual).setY(this.getY());
	  imag.get(dibujo_actual).draw(batch, parentAlpha);
  }
}
