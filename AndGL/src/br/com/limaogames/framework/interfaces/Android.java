package br.com.limaogames.framework.interfaces;

import android.app.Dialog;
import android.content.Context;
import android.content.Intent;

/**
 * 
 * @author André <br />
 * <b>Email:</b> andreikeda@limaogames.com.br <br />
 * created on: 09/08/2013
 * @version 1.0
 * @see 
 */
public interface Android {
    
    /**
     * Retorna o {@link Context} do jogo.
     * 
     * @return {@link Context}.
     */
    public Context getGameContext();
    
    /**
     * Retorna String de acordo com o identificador do recurso passado por parâmetro.
     * 
     * @param resId - Inteiro representativo do recurso a ser carregado.
     * @return String definida pelo identificador do recurso.
     */
    public String getGameResourceString(int resId);
    
    /**
     * Retorna String formatada de acordo com o identificador do recurso passado por parâmetro.
     * 
     * @param resId - Inteiro representativo do recurso a ser carregado.
     * @param formatArgs - String conjunto de variáveis para formatação do recurso a ser carregado.
     * @return String formatada definida pelo identificador do recurso.
     */
    public String getGameResourceFormattedString(int resId, Object... formatArgs);
	
    /**
     * Abre uma caixa de mensagem com o layout definido por parâmetro.
     * 
     * @param layoutId - Inteiro representativo do recurso a ser utilizado.
     * @see Dialog
     */
	public void openDialog(int layoutId);
	
	/**
	 * Executa {@link Intent}.
	 * 
	 * @param it - {@link Intent} a ser executada.
	 */
	public void openIntent(Intent it);

}
