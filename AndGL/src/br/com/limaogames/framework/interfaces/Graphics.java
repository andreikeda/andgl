package br.com.limaogames.framework.interfaces;

/**
 * Interface para prover funcionalidades para manipulação de objetos gráficos.
 * 
 * @author André <br />
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
     * Cria uma nova instância de {@link Pixmap} carregando a imagem pelo caminho passado por parâmetro.
     * 
     * @param fileName - Caminho onde se localiza a imagem a ser carregada.
     * @param format - <b>enum</b> {@link PixmapFormat}.
     * @return Nova instância de {@link Pixmap}.
     */
    public Pixmap newPixmap(String fileName, PixmapFormat format);

    /**
     * Limpa a {@link Screen} com a cor passada por parâmetro.
     * 
     * @param color - Inteiro que representa a cor.
     */
    public void clear(int color);

    /**
     * Desenha um pixel no ponto com as coordenadas passadas por parâmetro e com a cor definida também por parâmetro.
     *  
     * @param x - Inteiro que indica o valor no eixo x onde o pixel deve ser desenhado.
     * @param y - Inteiro que indica o valor no eixo y onde o pixel deve ser desenhado.
     * @param color - Inteiro que representa a cor do pixel que será desenhado.
     */
    public void drawPixel(int x, int y, int color);

    /**
     * Desenha linha reta.
     * 
     * @param x - Inteiro que indica o valor no eixo x onde a linha começa.
     * @param y - Inteiro que indica o valor no eixo y onde a linha começa.
     * @param x2 - Inteiro que indica o valor no eixo x onde a linha termina.
     * @param y2 - Inteiro que indica o valor no eixo y onde a linha termina.
     * @param color - Inteiro que representa a cor da linha.
     */
    public void drawLine(int x, int y, int x2, int y2, int color);

    /**
     * Desenha retângulo.
     * 
     * @param x - Inteiro que indica o valor no eixo x onde o retângulo será desenhado.
     * @param y - Inteiro que indica o valor no eixo y onde o retângulo será desenhado.
     * @param width - Inteiro que indica a largura do retângulo que será desenhado.
     * @param height - Inteiro que indica a altura do retângulo que será desenhado.
     * @param color - Inteiro que indica a cor do retângulo.
     */
    public void drawRect(int x, int y, int width, int height, int color);

    /**
     * Desenha a instância do objeto {@link Pixmap} passado por parâmetro.
     * 
     * @param pixmap - Instância de {@link Pixmap} que será desenhada.
     * @param x - Inteiro que indica o valor no eixo x onde a instância de {@link Pixmap} que será desenhada.
     * @param y - Inteiro que indica o valor no eixo y onde a instância de {@link Pixmap} que será desenhada.
     * @param srcX - Inteiro que indica o ponto x onde a imagem começa.
     * @param srcY - Inteiro que indica o ponto y onde a imagem começa.
     * @param srcWidth - Inteiro que indica a largura da instância de {@link Pixmap} que será desenhada.
     * @param srcHeight - Inteiro que indica a altura da instância de {@link Pixmap} que será desenhada.
     */
    public void drawPixmap(Pixmap pixmap, int x, int y, int srcX, int srcY,
            int srcWidth, int srcHeight);

    /**
     * Desenha instância do objeto {@link Pixmap} passado por parâmetro.
     * 
     * @param pixmap - Instância de {@link Pixmap} que será desenhada.
     * @param x - Inteiro que indica o valor no eixo x onde a instância de {@link Pixmap} será desenhada.
     * @param y - Inteiro que indica o valor no eixo y onde a instância de {@link Pixmap} será desenhada.
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
