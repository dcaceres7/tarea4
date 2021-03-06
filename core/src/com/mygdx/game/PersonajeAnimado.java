package com.mygdx.game;
import java.util.ArrayList;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class PersonajeAnimado extends Actor{
	ArrayList<Image> images;
	int dibujo_actual=0;
	float llamadas_act=0;
	
  public PersonajeAnimado(){
	super();
	
	images=new ArrayList<Image>();
	
	images.add(new Image(new Texture("croc01.png")));
	images.add(new Image(new Texture("croc02.png")));
	images.add(new Image(new Texture("croc03.png")));
	images.add(new Image(new Texture("croc04.png")));
	images.add(new Image(new Texture("croc05.png")));
	images.add(new Image(new Texture("croc06.png")));
	
  }
  
  public void act(float delta){
	  super.act(delta);
	  //System.out.println(delta);
	  llamadas_act+=delta;
	  if(llamadas_act>0.1f){
	  dibujo_actual++;
	  llamadas_act=0;
	  }
	  if(dibujo_actual>=images.size()){
		  dibujo_actual=0;
	  }
	  
	  this.setX(this.getX()+2);
	  
  }
  
  public void draw(Batch batch,float parentAlpha){
	  super.draw(batch, parentAlpha);
	  images.get(dibujo_actual).setX(this.getX());
	  images.get(dibujo_actual).draw(batch, parentAlpha);
  }

}
