package br.com.limaogames.framework.interfaces;

import java.util.List;

import br.com.limaogames.framework.interfaces.Input.TouchEvent;

import android.view.View.OnTouchListener;

/**
 * Interface para controlar os eventos de toque no display.
 * 
 * @author André <br />
 * <b>Email:</b> andreikeda@limaogames.com.br <br />
 * created on: 31/07/2013
 * @version 1.0
 * @see OnTouchListener
 */
public interface TouchHandler extends OnTouchListener {
	/**
	 * Retorna <b>true</b> se pointer diferente de 0. Caso contrário, retorna <b>false</b>.
	 * @param pointer
	 * @return Boolean <b>true</b> caso toque esteja ativo ou <b>false</b> caso contrário. 
	 */
    public boolean isTouchDown(int pointer);
    
    /**
     * Retorna coordenada x do ponto registrado com o identificador do parâmetro.
     * 
     * @param pointer - Inteiro que identifica o ponto.
     * @return Inteiro da coordenada x.
     */
    public int getTouchX(int pointer);
    
    /**
     * Retorna coordenada y do ponto registrado com o identificador do parâmetro.
     * 
     * @param pointer - Inteiro que identifica o ponto.
     * @return Inteiro da coordenada y.
     */
    public int getTouchY(int pointer);
    
    /**
     * Retorna lista de eventos enviados pelo toque do usuário.
     * 
     * @return {@link List} de objetos de {@link TouchEvent}.
     */
    public List<TouchEvent> getTouchEvents();
}
