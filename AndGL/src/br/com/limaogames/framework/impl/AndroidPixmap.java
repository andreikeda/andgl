package br.com.limaogames.framework.impl;

import android.graphics.Bitmap;
import br.com.limaogames.framework.interfaces.Pixmap;
import br.com.limaogames.framework.interfaces.Graphics.PixmapFormat;

/**
 * Classe para prover a funcionalidade para manipulação de objetos do tipo {@link Pixmap}.
 * 
 * @author André <br />
 * <b>Email:</b> andreikeda@limaogames.com.br <br />
 * created on: 31/07/2013
 * @version 1.0
 * @see Pixmap
 */
public class AndroidPixmap implements Pixmap {
    Bitmap bitmap;
    PixmapFormat format;
    
    /**
     * Construtor da classe.
     * 
     * @param bitmap - {@link Bitmap} a ser armazenado.
     * @param format - <b>enum</b> {@link PixmapFormat}.
     */
    public AndroidPixmap(Bitmap bitmap, PixmapFormat format) {
        this.bitmap = bitmap;
        this.format = format;
    }

    @Override
    public int getWidth() {
        return bitmap.getWidth();
    }

    @Override
    public int getHeight() {
        return bitmap.getHeight();
    }

    @Override
    public PixmapFormat getFormat() {
        return format;
    }

    @Override
    public void dispose() {
        bitmap.recycle();
    }      
}
