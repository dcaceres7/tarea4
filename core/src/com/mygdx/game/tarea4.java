package com.mygdx.game;

import com.badlogic.gdx.ApplicationAdapter;
import com.badlogic.gdx.Files.FileType;
import com.badlogic.gdx.Gdx;
import com.badlogic.gdx.graphics.GL20;
import com.badlogic.gdx.scenes.scene2d.Stage;
import com.badlogic.gdx.audio.Music;

public class tarea4 extends ApplicationAdapter {
	Music music;
	Stage stage;
	
	@Override
	public void create () {
		stage = new Stage();
		Gdx.input.setInputProcessor(stage);
		
		music = Gdx.audio.newMusic(Gdx.files.getFileHandle("It's my world.mp3", FileType.Internal));
		music.setLooping(true);
		music.play();
		
		//personaje animado
		stage.addActor(new PersonajeAnimado());
		stage.addActor(new PersonajeAnimado2());
		stage.addActor(new PersonajeAnimado3());
		stage.addActor(new PersonajeAnimado4());
		stage.addActor(new PersonajeAnimado5());
	}

	@Override
	public void render () {
		Gdx.gl.glClearColor(1, 0, 1, 1);
		Gdx.gl.glClear(GL20.GL_COLOR_BUFFER_BIT);
		stage.draw();
		stage.act();
	}
}
