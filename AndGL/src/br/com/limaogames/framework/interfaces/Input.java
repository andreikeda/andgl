package br.com.limaogames.framework.interfaces;

import java.util.List;

/**
 * Interface para prover funcionalidades para manipula��o dos eventos de entrada.
 * 
 * @author Andr� <br />
 * <b>Email:</b> andreikeda@limaogames.com.br <br />
 * created on: 31/07/2013
 * @version 1.0
 * @see KeyEvent
 * @see TouchEvent
 */
public interface Input {
	/**
	 * Classe para definir eventos do teclado.
	 * 
	 * @author Andr� <br />
	 * <b>Email:</b> andreikeda@limaogames.com.br <br />
	 * created on: 31/07/2013
	 * @version 1.0
	 * @see
	 */
    public static class KeyEvent {
        public static final int KEY_DOWN = 0;
        public static final int KEY_UP = 1;

        public int type;
        public int keyCode;
        public char keyChar;

        @Override
		public String toString() {
            StringBuilder builder = new StringBuilder();
            if (type == KEY_DOWN)
                builder.append("key down, ");
            else
                builder.append("key up, ");
            builder.append(keyCode);
            builder.append(",");
            builder.append(keyChar);
            return builder.toString();
        }
    }

    /**
     * Classe para definir eventos de toque.
     * 
     * @author Andr� <br />
     * <b>Email:</b> andreikeda@limaogames.com.br <br />
     * created on: 31/07/2013
     * @version 1.0
     * @see
     */
    public static class TouchEvent {
        public static final int TOUCH_DOWN = 0;
        public static final int TOUCH_UP = 1;
        public static final int TOUCH_DRAGGED = 2;

        public int type;
        public int x, y;
        public int pointer;

        @Override
		public String toString() {
            StringBuilder builder = new StringBuilder();
            if (type == TOUCH_DOWN)
                builder.append("touch down, ");
            else if (type == TOUCH_DRAGGED)
                builder.append("touch dragged, ");
            else
                builder.append("touch up, ");
            builder.append(pointer);
            builder.append(",");
            builder.append(x);
            builder.append(",");
            builder.append(y);
            return builder.toString();
        }
    }

    /**
     * Verifica se determinada tecla (c�digo passado por par�metro) do teclado est� sendo pressionada.
     * 
     * @param keyCode - Inteiro do c�digo da tecla a ser verificada.
     * @return Boolean <b>true</b> se tecla est� sendo pressionada ou <b>false</b> caso contr�rio.
     */
    public boolean isKeyPressed(int keyCode);

    /**
     * Verifica se o toque identificado por par�metro est� ativo.
     * 
     * @param pointer - Inteiro identificador do toque na lista de eventos.
     * @return Boolean <b>true</b> caso toque esteja ativo ou <b>false</b> caso contr�rio.
     */
    public boolean isTouchDown(int pointer);

    /**
     * Retorna a coordenada x do evento identificado por par�metro.
     * 
     * @param pointer - Inteiro identificador do evento.
     * @return Inteiro resultado da coordenada x.
     */
    public int getTouchX(int pointer);

    /**
     * Retorna coordenada y do evento identificado por par�metro.
     * 
     * @param pointer - Inteiro identificador do evento.
     * @return Inteiro resultado da coordenada y.
     */
    public int getTouchY(int pointer);

    /**
     * Retorna varia��o do �ngulo do aceler�metro no eixo x.
     * 
     * @return Float da varia��o do �ngulo do aceler�metro no eixo x.
     */
    public float getAccelX();

    /**
     * Retorna varia��o do �ngulo do aceler�metro no eixo y.
     * 
     * @return Float da varia��o do �ngulo do aceler�metro no eixo y.
     */
    public float getAccelY();

    /**
     * Retorna varia��o do �ngulo do aceler�metro no eixo z.
     * 
     * @return Float da varia��o do �ngulo do aceler�metro no eixo z.
     */
    public float getAccelZ();

    /**
     * Retorna lista de eventos do teclado.
     * 
     * @return {@link List} de {@link KeyEvent}.
     */
    public List<KeyEvent> getKeyEvents();

    /**
     * Retorna lista de eventos de toque.
     * 
     * @return {@link List} de {@link TouchEvent}.
     */
    public List<TouchEvent> getTouchEvents();
}
