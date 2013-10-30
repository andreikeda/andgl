package br.com.limaogames.framework.impl;

import javax.microedition.khronos.egl.EGLConfig;
import javax.microedition.khronos.opengles.GL10;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.pm.ActivityInfo;
import android.opengl.GLSurfaceView;
import android.opengl.GLSurfaceView.Renderer;
import android.os.Bundle;
import android.os.PowerManager;
import android.os.PowerManager.WakeLock;
import android.view.Window;
import android.view.WindowManager;
import br.com.limaogames.framework.Screen;
import br.com.limaogames.framework.helper.GLGameState;
import br.com.limaogames.framework.interfaces.Audio;
import br.com.limaogames.framework.interfaces.FileIO;
import br.com.limaogames.framework.interfaces.Game;
import br.com.limaogames.framework.interfaces.Graphics;
import br.com.limaogames.framework.interfaces.Input;
import br.com.limaogames.framework.util.Display;

/**
 * Classe abstrata para criação da {@link Activity} principal ("core" do jogo) utilizando openGL.
 * 
 * @author André <br />
 * <b>Email:</b> andreikeda@limaogames.com.br <br />
 * created on: 31/07/2013
 * @version 1.0
 * @see
 */
public abstract class GLGame extends Activity implements Game, Renderer {
    
    GLSurfaceView glView;    
    GLGraphics glGraphics;
    Audio audio;
    Input input;
    FileIO fileIO;
    Screen screen;
    public GLGameState state = GLGameState.Initialized;
    Object stateChanged = new Object();
    long startTime = System.nanoTime();
    WakeLock wakeLock;
    
    @SuppressWarnings("deprecation")
	@Override 
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                             WindowManager.LayoutParams.FLAG_FULLSCREEN);
        glView = new GLSurfaceView(this);
        glView.setRenderer(this);
        setContentView(glView);
        
        Display.setWindow(this);
        glGraphics = new GLGraphics(glView);
        fileIO = new AndroidFileIO(getAssets());
        audio = new AndroidAudio(this);
//        input = new AndroidInput(this, glView, Display.scaleX, Display.scaleY);
        input = new AndroidInput(this, glView, 1, 1);
        PowerManager powerManager = (PowerManager) getSystemService(Context.POWER_SERVICE);
        wakeLock = powerManager.newWakeLock(PowerManager.FULL_WAKE_LOCK, "GLGame");        
    }
    
    @Override
	public void onResume() {
        super.onResume();
        glView.onResume();
        wakeLock.acquire();
    }
    
    @Override
    public void onSurfaceCreated(GL10 gl, EGLConfig config) {        
        glGraphics.setGL(gl);
        
        synchronized(stateChanged) {
            if(state == GLGameState.Initialized)
                screen = getStartScreen();
            state = GLGameState.Running;
            screen.resume();
            startTime = System.nanoTime();
        }        
    }
    
    @Override
    public void onSurfaceChanged(GL10 gl, int width, int height) {
    	gl.glViewport(0, 0, width, height);
    }

    @Override
    public void onDrawFrame(GL10 gl) {                
        GLGameState state = null;
        
        synchronized(stateChanged) {
            state = this.state;
        }
        
        if(state == GLGameState.Running) {
            float deltaTime = (System.nanoTime()-startTime) / 1000000000.0f;
            startTime = System.nanoTime();
            
            screen.update(deltaTime);
            screen.present(deltaTime);
        }
        
        if(state == GLGameState.Paused) {
            screen.pause();            
            synchronized(stateChanged) {
                this.state = GLGameState.Idle;
                stateChanged.notifyAll();
            }
        }
        
        if(state == GLGameState.Finished) {
            screen.pause();
            screen.dispose();
            synchronized(stateChanged) {
                this.state = GLGameState.Idle;
                stateChanged.notifyAll();
            }            
        }
    }   
    
    @Override 
    public void onPause() {        
        synchronized(stateChanged) {
            if(isFinishing())            
                state = GLGameState.Finished;
            else
                state = GLGameState.Paused;
            while(true) {
                try {
                    stateChanged.wait();
                    break;
                } catch(InterruptedException e) {         
                }
            }
        }
        wakeLock.release();
        glView.onPause();  
        super.onPause();
    }    
    
    @Override
    public Input getInput() {
        return input;
    }

    @Override
    public FileIO getFileIO() {
        return fileIO;
    }

    @Override
    public Graphics getGraphics() {
        throw new IllegalStateException("We are using OpenGL!");
    }
    
    @Override
    public GLGraphics getGLGraphics() {
    	return glGraphics;
    }

    @Override
    public Audio getAudio() {
        return audio;
    }

    @Override
    public void setScreen(Screen screen) {
        if (screen == null)
            throw new IllegalArgumentException("Screen must not be null");

        this.screen.pause();
        this.screen.dispose();
        screen.resume();
        screen.update(0);
        this.screen = screen;
    }

    @Override
    public Screen getCurrentScreen() {
        return screen;
    }
    
    @Override
    public Context getGameContext() {
    	return this;
    }
    
    @Override
    public String getGameResourceString(int resId) {
    	return getResources().getString(resId);
    }
    
    @Override
    public String getGameResourceFormattedString(int resId, Object... formatArgs) {
    	return getResources().getString(resId, formatArgs);
    }
    
    @Override
    public void openIntent(Intent it) {
    	startActivity(it);
    }
    
    @Override
    public void openDialog(int layoutId) {
    }
    
    @Override
    public void loginFacebook(String fbAppId, String permissions) {
    	
    }
}
