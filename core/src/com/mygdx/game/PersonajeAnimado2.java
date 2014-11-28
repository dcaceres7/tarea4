package com.mygdx.game;
import java.util.ArrayList;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class PersonajeAnimado2 extends Actor{
	PersonajeAnimado3 p;
	ArrayList<Image> imag;
	int dibujo_actual=0;
	float llamadas_act=0;
	
  public PersonajeAnimado2(PersonajeAnimado3 p){
	super();
	this.p=p;
	imag=new ArrayList<Image>();
	
	imag.add(new Image(new Texture("bomba01.png")));
	imag.add(new Image(new Texture("bomba02.png")));
	imag.add(new Image(new Texture("bomba03.png")));
	
	  this.setX(800);
	  this.setY(100);
  }
  
  @Override
  public void act(float delta){
	  super.act(delta);
	  this.setX(this.getX()-delta*200);
	  
	  //System.out.println(delta);
	  llamadas_act+=delta;
	  if(llamadas_act>0.1f){
	  dibujo_actual++;
	  llamadas_act=0;
	  }
	  if(dibujo_actual>=imag.size()){
		  dibujo_actual=0;
	  }
		 
			if(this.getX()<p.getX()+50
			&& this.getX()+50>p.getX()
			&& this.getY()<p.getY()+50
			&& this.getY()+50>p.getY()){
		System.out.println("Colision!");
		imag.add(new Image(new Texture ("over.png")));
			}
	  
	  
//	  this.setX(this.getX()+2);
//	  this.setY(this.getY()+2);
	  //llamadas_act++;
  }
  
  public void draw(Batch batch,float parentAlpha){
	  super.draw(batch, parentAlpha);
	  imag.get(dibujo_actual).setY(this.getY());
	  imag.get(dibujo_actual).setX(this.getX());
	  imag.get(dibujo_actual).draw(batch, parentAlpha);
  }
}
