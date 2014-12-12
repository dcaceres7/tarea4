package com.mygdx.game;
import java.util.ArrayList;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class PersonajeAnimado2 extends Actor{
	PersonajeAnimado3 p;
	ArrayList<Image> imag;
	int dibujo_actual=0;
	static int contadorColision=0,contadorVelocidad=0;

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

	public static void setContadorColision(int contadorColision) {
		PersonajeAnimado2.contadorColision = contadorColision;
	}
	public static void setContadorVelocidad(int contadorVelocidad){
		PersonajeAnimado2.contadorVelocidad=contadorVelocidad;
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
		 
	  Rectangle r1=new Rectangle(this.getX(), this.getY(), 100, 100);
	  Rectangle r2=new Rectangle(p.getX(), p.getY(), 100, 100);
		if(r1.overlaps(r2)){
		 System.out.println("Colision!");
		 contadorColision+=1;
		}else
	     contadorVelocidad+=1;
		if(contadorVelocidad>1000)
		this.setX(this.getX()-delta*280);
  }
  
  public void draw(Batch batch,float parentAlpha){
	  super.draw(batch, parentAlpha);
	  imag.get(dibujo_actual).setY(this.getY());
	  imag.get(dibujo_actual).setX(this.getX());
	  imag.get(dibujo_actual).draw(batch, parentAlpha);
  }
  
}
