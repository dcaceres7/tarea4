package com.mygdx.game;
import java.util.ArrayList;

import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.graphics.g2d.Batch;
import com.badlogic.gdx.math.Rectangle;
import com.badlogic.gdx.scenes.scene2d.Actor;
import com.badlogic.gdx.scenes.scene2d.ui.Image;

public class PersonajeAnimado5 extends Actor{
	ArrayList<Image> imag;
	int dibujo_actual=0;
	float llamadas_act=0; 
	PersonajeAnimado3 p;
	Over img;
	static int contadorColi=0,contadorVelocidad=0;

public PersonajeAnimado5(PersonajeAnimado3 p){
	super();
	this.p=p;
	imag=new ArrayList<Image>();
	
	imag.add(new Image(new Texture("volador01.png")));
	imag.add(new Image(new Texture("volador02.png")));
	imag.add(new Image(new Texture("volador03.png")));
	  this.setX(800);
	  this.setY(250);
  }

public static void setContadorColi(int contadorColi) {
		PersonajeAnimado5.contadorColi = contadorColi;
	}
public static void setContadorVelocidades(int contadorVelocidad){
	PersonajeAnimado5.contadorVelocidad=contadorVelocidad;
}
  public void act(float delta){
	  super.act(delta);
	  this.setX(this.getX()-delta*180);
	  //System.out.println(delta);
	  llamadas_act+=delta;
	  if(llamadas_act>0.1f){
	  dibujo_actual++;
	  llamadas_act=0;
	  }
	  if(dibujo_actual>=imag.size()){
		  dibujo_actual=0;
	  }

	  //this.setX(this.getX()-1);
	  //llamadas_act++;
	//choque de imagenes
			Rectangle r1=new Rectangle(this.getX(), this.getY(), 100, 100);
			Rectangle r2=new Rectangle(p.getX(), p.getY(), 100, 100);
			
			if(r1.overlaps(r2)){
			System.out.println("Colision!");
			contadorColi+=1;
			//imag.add((new Image(new Texture("over.png"))));
	        }else
	   	     contadorVelocidad+=1;
			if(contadorVelocidad>1800)
				this.setX(this.getX()-delta*220);
  }
  public void draw(Batch batch,float parentAlpha){
	  super.draw(batch, parentAlpha);
	  imag.get(dibujo_actual).setY(this.getY());
      imag.get(dibujo_actual).setX(this.getX());
	  imag.get(dibujo_actual).draw(batch, parentAlpha);
  }

}
