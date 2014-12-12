package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Files.FileType;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.graphics.Texture;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.audio.Music;

public class tarea4 extends ApplicationAdapter implements InputProcessor {
	Music music,music2;
	Stage stage,menu,gover;
	PersonajeAnimado3 personaje;
	PersonajeAnimado2 ebomba;
	PersonajeAnimado5 evolador;
	int frame;
	Over iOver;
	Menu inicio;
	Inst ins;
	BotonIniciar iniciar;
	Instrucciones iniciarI;
	BotonSalir salir;
	Texture bi,bs,i,m,in,over,biniciar;
	int cont = 0;
	boolean confirmar=true;
	@Override
	public void create () {
		cont=0;
		stage = new Stage();
		gover=new Stage();
		menu =new Stage();
		
		iOver=new Over();
		gover.addActor(iOver);
		
		m = new Texture("menu.png");
		inicio=new Menu(m);
		menu.addActor(inicio);
		
		Jugador m = new Jugador();
		menu.addActor(m);
		
		bi=new Texture("juego.png");
		iniciar=new BotonIniciar(bi);
		menu.addActor(iniciar);
		System.out.println(ebomba.contadorColision+evolador.contadorColi);
		
		i=new Texture("Instrucciones.png");
		iniciarI=new Instrucciones(i);
		menu.addActor(iniciarI);
		
		bs=new Texture("BotonExit.png");
		salir=new BotonSalir(bs);
		menu.addActor(salir);
		
		
		
		personaje = new PersonajeAnimado3();
		//menu.addActor(personaje);
		
		Gdx.input.setInputProcessor(menu);
		music = Gdx.audio.newMusic(Gdx.files.getFileHandle("It's my world.mp3", FileType.Internal));
		music.setLooping(true);
		music.play();

		music2 = Gdx.audio.newMusic(Gdx.files.getFileHandle("musica2.ogg", FileType.Internal));
		music2.setLooping(true);
		
		//personaje animado
		stage.addActor(new Plataforma());
		//stage.addActor(new PersonajeAnimado());
		//stage.addActor(new PersonajeAnimado2());
		//stage.addActor(new PersonajeAnimado4());
		//stage.addActor(new PersonajeAnimado5());
		stage.addActor(personaje);
		
		
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(0,0,0,0);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		if(cont==0){
			menu.draw();
			menu.act();
		}
		
		if(iniciar.finish()){
			music.stop();
			music2.play();
			Gdx.input.setInputProcessor(this);
			stage.draw();
			stage.act();
			confirmar=false;
			int tcontador=(ebomba.contadorColision+evolador.contadorColi);
			if(tcontador>154){
				Gdx.input.setInputProcessor(gover);
				gover.draw();
				gover.act();
				ebomba.setContadorColision(0);
				ebomba.setContadorVelocidad(0);
				evolador.setContadorColi(0);
				evolador.setContadorVelocidades(0);
				confirmar=true;
			}
			if(confirmar){
				confirmar = false;
				tcontador = 0;
				create();
				menu.act();
				menu.draw();
				Gdx.input.setInputProcessor(menu);
			}
		}
		
		if(inicio.finish()){
			cont++;
			//Gdx.input.setInputProcessor(this);
			menu.draw();
			menu.act();
			
		}
		
		
		if(frame%200==0)
	     agregarElemento();
		frame++;
	    
		if(iniciarI.finish()){
			iniciarI.changeClic();
			in=new Texture("ins.png");
			ins=new Inst(in); 
			menu.addActor(ins);
		}
		
	}
	
	public void agregarElemento(){
		PersonajeAnimado2 p2=new PersonajeAnimado2(personaje);
		PersonajeAnimado5 p5=new PersonajeAnimado5(personaje);
		stage.addActor(p2);
		stage.addActor(p5);
		p2.setX(1305);
		p5.setX(925);
		
	}

	@Override
	public boolean keyDown(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyUp(int keycode) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean keyTyped(char character) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDown(int screenX, int screenY, int pointer, int button) {
		personaje.saltar();
		return false;
	}

	@Override
	public boolean touchUp(int screenX, int screenY, int pointer, int button) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean touchDragged(int screenX, int screenY, int pointer) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean mouseMoved(int screenX, int screenY) {
		// TODO Auto-generated method stub
		return false;
	}

	@Override
	public boolean scrolled(int amount) {
		// TODO Auto-generated method stub
		return false;
	}
}
