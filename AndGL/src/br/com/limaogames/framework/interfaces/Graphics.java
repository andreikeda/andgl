package br.com.limaogames.framework.interfaces;

/**
 * Interface para prover funcionalidades para manipula��o de objetos gr�ficos.
 * 
 * @author Andr� <br />
 * <b>Email:</b> andreikeda@limaogames.com.br <br />
 * created on: 31/07/2013
 * @version 1.0
 * @see Pixmap
 */
public interface Graphics {
    public static enum PixmapFormat {
        ARGB8888, ARGB4444, RGB565
    }

    /**
     * Cria uma nova inst�ncia de {@link Pixmap} carregando a imagem pelo caminho passado por par�metro.
     * 
     * @param fileName - Caminho onde se localiza a imagem a ser carregada.
     * @param format - <b>enum</b> {@link PixmapFormat}.
     * @return Nova inst�ncia de {@link Pixmap}.
     */
    public Pixmap newPixmap(String fileName, PixmapFormat format);

    /**
     * Limpa a {@link Screen} com a cor passada por par�metro.
     * 
     * @param color - Inteiro que representa a cor.
     */
    public void clear(int color);

    /**
     * Desenha um pixel no ponto com as coordenadas passadas por par�metro e com a cor definida tamb�m por par�metro.
     *  
     * @param x - Inteiro que indica o valor no eixo x onde o pixel deve ser desenhado.
     * @param y - Inteiro que indica o valor no eixo y onde o pixel deve ser desenhado.
     * @param color - Inteiro que representa a cor do pixel que ser� desenhado.
     */
    public void drawPixel(int x, int y, int color);

    /**
     * Desenha linha reta.
     * 
     * @param x - Inteiro que indica o valor no eixo x onde a linha come�a.
     * @param y - Inteiro que indica o valor no eixo y onde a linha come�a.
     * @param x2 - Inteiro que indica o valor no eixo x onde a linha termina.
     * @param y2 - Inteiro que indica o valor no eixo y onde a linha termina.
     * @param color - Inteiro que representa a cor da linha.
     */
    public void drawLine(int x, int y, int x2, int y2, int color);

    /**
     * Desenha ret�ngulo.
     * 
     * @param x - Inteiro que indica o valor no eixo x onde o ret�ngulo ser� desenhado.
     * @param y - Inteiro que indica o valor no eixo y onde o ret�ngulo ser� desenhado.
     * @param width - Inteiro que indica a largura do ret�ngulo que ser� desenhado.
     * @param height - Inteiro que indica a altura do ret�ngulo que ser� desenhado.
     * @param color - Inteiro que indica a cor do ret�ngulo.
     */
    public void drawRect(int x, int y, int width, int height, int color);

    /**
     * Desenha a inst�ncia do objeto {@link Pixmap} passado por par�metro.
     * 
     * @param pixmap - Inst�ncia de {@link Pixmap} que ser� desenhada.
     * @param x - Inteiro que indica o valor no eixo x onde a inst�ncia de {@link Pixmap} que ser� desenhada.
     * @param y - Inteiro que indica o valor no eixo y onde a inst�ncia de {@link Pixmap} que ser� desenhada.
     * @param srcX - Inteiro que indica o ponto x onde a imagem come�a.
     * @param srcY - Inteiro que indica o ponto y onde a imagem come�a.
     * @param srcWidth - Inteiro que indica a largura da inst�ncia de {@link Pixmap} que ser� desenhada.
     * @param srcHeight - Inteiro que indica a altura da inst�ncia de {@link Pixmap} que ser� desenhada.
     */
    public void drawPixmap(Pixmap pixmap, int x, int y, int srcX, int srcY,
            int srcWidth, int srcHeight);

    /**
     * Desenha inst�ncia do objeto {@link Pixmap} passado por par�metro.
     * 
     * @param pixmap - Inst�ncia de {@link Pixmap} que ser� desenhada.
     * @param x - Inteiro que indica o valor no eixo x onde a inst�ncia de {@link Pixmap} ser� desenhada.
     * @param y - Inteiro que indica o valor no eixo y onde a inst�ncia de {@link Pixmap} ser� desenhada.
     */
    public void drawPixmap(Pixmap pixmap, int x, int y);

    /**
     * Retorna largura da imagem.
     * 
     * @return Inteiro que indica a largura da imagem.
     */
    public int getWidth();

    /**
     * Retorna altura da imagem.
     * 
     * @return Inteiro que indica a altura da imagem.
     */
    public int getHeight();
}
