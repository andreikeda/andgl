package br.com.limaogames.framework.impl;

import android.media.SoundPool;
import br.com.limaogames.framework.interfaces.Sound;

/**
 * Classe para prover a funcionalidade para manipulação de sons.
 * 
 * @author André <br />
 * <b>Email:</b> andreikeda@limaogames.com.br <br />
 * created on: 31/07/2013
 * @version 1.0
 * @see Sound
 */
public class AndroidSound implements Sound {
    int soundId;
    SoundPool soundPool;
    
    /**
     * Construtor da classe.
     * 
     * @param soundPool - {@link SoundPool} "piscina" onde os sons ficarão armazenados.
     * @param soundId - Inteiro do identificador do som.
     */
    public AndroidSound(SoundPool soundPool,int soundId) {
        this.soundId = soundId;
        this.soundPool = soundPool;
    }

    @Override
    public void play(float volume) {
        soundPool.play(soundId, volume, volume, 0, 0, 1);
    }

    @Override
    public void dispose() {
        soundPool.unload(soundId);
    }

}
