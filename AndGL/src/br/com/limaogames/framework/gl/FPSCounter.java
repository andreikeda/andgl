package br.com.limaogames.framework.gl;

import android.util.Log;

/**
 * Classe utilit�rio para verificar FPS (frame per second) a fim de melhorar, caso necess�rio, a efici�ncia do jogo.
 * 
 * @author Andr� <br />
 * <b>Email:</b> andreikeda@limaogames.com.br <br />
 * created on: 31/07/2013
 * @version 1.0
 * @see
 */
public class FPSCounter {
    long startTime = System.nanoTime();
    int frames = 0;
    
    /**
     * Envia log para o console informando o valor FPS.
     */
    public void logFrame() {
        frames++;
        if(System.nanoTime() - startTime >= 1000000000) {
            Log.d("FPSCounter", "fps: " + frames);
            frames = 0;
            startTime = System.nanoTime();
        }
    }
}
