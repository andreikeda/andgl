package br.com.limaogames.framework.gl;

/**
 * Classe para prover suporte ao desenho de caracteres.
 * 
 * @author André <br />
 * <b>Email:</b> andreikeda@limaogames.com.br <br />
 * created on: 31/07/2013
 * @version 1.0
 * @see
 */
public class Font {
    public final Texture texture;
    public final float glyphWidth;
    public final float glyphHeight;
    public final TextureRegion[] glyphs = new TextureRegion[96];
    
    /**
     * Construtor da classe.
     * 
     * @param texture - Objeto de {@link Texture} contendo os caracteres a serem utilizados.
     * @param offsetX - Inteiro do alinhamento da texture no eixo "x".
     * @param offsetY - Inteiro do alinhamento da textura no eixo "y".
     * @param glyphsPerRow - Inteiro com o número de glifos por linha.
     * @param glyphWidth - Float com a largura do glifo.
     * @param glyphHeight - Float com a altura do glifo.
     */
    public Font(Texture texture, 
                int offsetX, int offsetY,
                int glyphsPerRow, float glyphWidth, float glyphHeight) {        
        this.texture = texture;
        this.glyphWidth = glyphWidth;
        this.glyphHeight = glyphHeight;
        int x = offsetX;
        int y = offsetY;
        for(int i = 0; i < 96; i++) {
            glyphs[i] = new TextureRegion(texture, x, y, glyphWidth, glyphHeight);
            x += glyphWidth;
            if(x == offsetX + glyphsPerRow * glyphWidth) {
                x = offsetX;
                y += glyphHeight;
            }
        }        
    }
    
    /**
     * Método desenha uma cadeia de caracteres no display utilizando o vetor de glifos montado na construção da classe.
     * 
     * @param batcher - Objeto de {@link SpriteBatcher}.
     * @param text - Cadeia de caracteres contendo o que deve ser escrito.
     * @param x - Float com o valor métrico "x" de onde será desenhado o texto.
     * @param y - Float com o valor métrico "y" de onde será desenhado o texto.
     */
    public void drawText(SpriteBatcher batcher, String text, float x, float y) {
        int len = text.length();
        for(int i = 0; i < len; i++) {
            int c = text.charAt(i) - ' ';
            if(c < 0 || c > glyphs.length - 1) 
                continue;
            
            TextureRegion glyph = glyphs[c];
            batcher.drawSprite(x, y, glyphWidth, glyphHeight, glyph);
            x += glyphWidth;
        }
    }
    
    /**
     * Método desenha uma cadeia de caracteres no display utilizando o vetor de glifos montado na construção da classe.
     * 
     * @param batcher - Objeto de {@link SpriteBatcher}.
     * @param text - Cadeia de caracteres contendo o que deve ser escrito.
     * @param x - Float com o valor métrico "x" de onde será desenhado o texto.
     * @param y - Float com o valor métrico "y" de onde será desenhado o texto.
     */
    public void drawText(SpriteBatcher batcher, String text, float x, float y, float width, float height) {
        int len = text.length();
        for(int i = 0; i < len; i++) {
            int c = text.charAt(i) - ' ';
            if(c < 0 || c > glyphs.length - 1) 
                continue;
            
            TextureRegion glyph = glyphs[c];
            batcher.drawSprite(x, y, width, height, glyph);
            x += width;
        }
    }
}
