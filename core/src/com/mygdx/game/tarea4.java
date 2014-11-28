package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Files.FileType;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.InputProcessor;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.audio.Music;

public class tarea4 extends ApplicationAdapter implements InputProcessor {
	Music music;
	Stage stage;
	PersonajeAnimado3 personaje;
	int frame;
	
	@Override
	public void create () {
		stage = new Stage();
		Gdx.input.setInputProcessor(this);
		personaje = new PersonajeAnimado3();
		
		music = Gdx.audio.newMusic(Gdx.files.getFileHandle("It's my world.mp3", FileType.Internal));
		music.setLooping(true);
		music.play();
		
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
		stage.draw();
		stage.act();
		if(frame%200==0)
	     agregarElemento();
		frame++;
			
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
