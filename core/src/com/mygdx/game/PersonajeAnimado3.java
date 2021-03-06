package com.mygdx.game;
import java.util.ArrayList;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class PersonajeAnimado3 extends Actor{
	ArrayList<Image> imag;
	int dibujo_actual=0;
	float llamadas_act=0;
	float velocidad_y=0;
	float aceleracion_y=0;
	
  public PersonajeAnimado3(){
	super();
	
	imag=new ArrayList<Image>();
	
	imag.add(new Image(new Texture("run01.png")));
	imag.add(new Image(new Texture("run02.png")));
	imag.add(new Image(new Texture("run03.png")));
	imag.add(new Image(new Texture("run04.png")));
	this.setY(70);
  }
  
  public void act(float delta){
	  super.act(delta);
	  //System.out.println(delta);
	  llamadas_act+=delta;
	  if(llamadas_act>0.1f){
	  dibujo_actual++;
	  llamadas_act=0;
	  }
	  if(dibujo_actual==imag.size()){
		  dibujo_actual=0;
	  }
	  //this.setX(this.getX()+2);
	  //this.setY(this.getY()+1);
	  //llamadas_act++;
	  
	  velocidad_y+=aceleracion_y;
	  this.setY(this.getY()+velocidad_y);
	  //Gravedad
	  aceleracion_y-=0.15;
	  //caigo en el piso
	  if(this.getY()<=70){
		  velocidad_y=0;
		  aceleracion_y=0;
		  this.setY(70);
	  }
	  super.act(delta);
  }
  
  //if(=70 o <300)
  public void saltar(){
	  if(this.getY()==70||this.getY()<300){
		  aceleracion_y =2.5f;
		  }
	  //aceleracion_y=2;
  }
  
  public void draw(Batch batch,float parentAlpha){
	  super.draw(batch, parentAlpha);
	  imag.get(dibujo_actual).setX(this.getX());
	  imag.get(dibujo_actual).setY(this.getY());
	  imag.get(dibujo_actual).draw(batch, parentAlpha);
	  
	  
  }
}
