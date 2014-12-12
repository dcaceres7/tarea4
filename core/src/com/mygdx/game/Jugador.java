package com.mygdx.game;

public class Jugador extends PersonajeAnimado3
{
	float gravedad;
	int piso;
	public Jugador() {
		super();
		this.setY(0);
		this.setX(425);
		gravedad=200f;
		piso=70;
	}
	
	@Override
	public void act(float delta) {
		super.act(delta);
		aceleracion_y-=gravedad*delta;
		if(getY()<=piso)
		{
			velocidad_y=0;
			aceleracion_y=0;
		}
	}
	@Override
	public void saltar()
	{
		if(getY()==piso)
			aceleracion_y=60f;
	}
}
