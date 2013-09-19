package br.com.limaogames.framework.interfaces;

import java.util.List;

/**
 * Interface para prover funcionalidades para manipulação dos eventos de entrada.
 * 
 * @author André <br />
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
	 * @author André <br />
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
     * @author André <br />
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
     * Verifica se determinada tecla (código passado por parâmetro) do teclado está sendo pressionada.
     * 
     * @param keyCode - Inteiro do código da tecla a ser verificada.
     * @return Boolean <b>true</b> se tecla está sendo pressionada ou <b>false</b> caso contrário.
     */
    public boolean isKeyPressed(int keyCode);

    /**
     * Verifica se o toque identificado por parâmetro está ativo.
     * 
     * @param pointer - Inteiro identificador do toque na lista de eventos.
     * @return Boolean <b>true</b> caso toque esteja ativo ou <b>false</b> caso contrário.
     */
    public boolean isTouchDown(int pointer);

    /**
     * Retorna a coordenada x do evento identificado por parâmetro.
     * 
     * @param pointer - Inteiro identificador do evento.
     * @return Inteiro resultado da coordenada x.
     */
    public int getTouchX(int pointer);

    /**
     * Retorna coordenada y do evento identificado por parâmetro.
     * 
     * @param pointer - Inteiro identificador do evento.
     * @return Inteiro resultado da coordenada y.
     */
    public int getTouchY(int pointer);

    /**
     * Retorna variação do ângulo do acelerômetro no eixo x.
     * 
     * @return Float da variação do ângulo do acelerômetro no eixo x.
     */
    public float getAccelX();

    /**
     * Retorna variação do ângulo do acelerômetro no eixo y.
     * 
     * @return Float da variação do ângulo do acelerômetro no eixo y.
     */
    public float getAccelY();

    /**
     * Retorna variação do ângulo do acelerômetro no eixo z.
     * 
     * @return Float da variação do ângulo do acelerômetro no eixo z.
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
