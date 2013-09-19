package br.com.limaogames.framework.gl;

import java.io.IOException;
import java.io.InputStream;

import javax.microedition.khronos.opengles.GL10;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.opengl.GLUtils;
import br.com.limaogames.framework.impl.GLGame;
import br.com.limaogames.framework.impl.GLGraphics;
import br.com.limaogames.framework.interfaces.FileIO;

/**
 * 
 * 
 * @author André <br />
 * <b>Email:</b> andreikeda@limaogames.com.br <br />
 * created on: 31/07/2013
 * @version 1.0
 * @see
 */
public class Texture {
    GLGraphics glGraphics;
    FileIO fileIO;
    String fileName;
    int textureId;
    int minFilter;
    int magFilter;   
    public int width;
    public int height;
    
    /**
     * Construtor da classe.
     * 
     * @param glGame - Objeto de {@link GLGame}.
     * @param fileName - Cadeia de caracteres com o nome da textura a ser carregada.
     */
    public Texture(GLGame glGame, String fileName) {
        this.glGraphics = glGame.getGLGraphics();
        this.fileIO = glGame.getFileIO();
        this.fileName = fileName;
        load();
    }
    
    /**
     * Carrega no buffer a textura através do nome definido no construtor da classe.
     * 
     * @throws RuntimeException - Imagem não pôde ser carregada.
     */
    private void load() {
        GL10 gl = glGraphics.getGL();
        int[] textureIds = new int[1];
        gl.glGenTextures(1, textureIds, 0);
        textureId = textureIds[0];
        
        InputStream in = null;
        try {
            in = fileIO.readAsset(fileName);
            Bitmap bitmap = BitmapFactory.decodeStream(in);
            gl.glBindTexture(GL10.GL_TEXTURE_2D, textureId);
            GLUtils.texImage2D(GL10.GL_TEXTURE_2D, 0, bitmap, 0);
            setFilters(GL10.GL_NEAREST, GL10.GL_NEAREST);            
            gl.glBindTexture(GL10.GL_TEXTURE_2D, 0);
            width = bitmap.getWidth();
            height = bitmap.getHeight();
            bitmap.recycle();
        } catch(IOException e) {
            throw new RuntimeException("Couldn't load texture '" + fileName +"'", e);
        } finally {
            if(in != null)
                try { in.close(); } catch (IOException e) { }
        }
    }
    
    /**
     * Recarrega no buffer a textura através do nome definido no construtor da classe e vincula a textura ao objeto para poder ser manipulada.
     */
    public void reload() {
        load();
        bind();
        setFilters(minFilter, magFilter);        
        glGraphics.getGL().glBindTexture(GL10.GL_TEXTURE_2D, 0);
    }
    
    /**
     * Atribui os filtros na textura.
     * 
     * @param minFilter - see (http://www.opengl.org/sdk/docs/man/xhtml/glTexParameter.xml) for more details
     * @param magFilter - see (http://www.opengl.org/sdk/docs/man/xhtml/glTexParameter.xml) for more details
     */
    public void setFilters(int minFilter, int magFilter) {
        this.minFilter = minFilter;
        this.magFilter = magFilter;
        GL10 gl = glGraphics.getGL();
        gl.glTexParameterf(GL10.GL_TEXTURE_2D, GL10.GL_TEXTURE_MIN_FILTER, minFilter);
        gl.glTexParameterf(GL10.GL_TEXTURE_2D, GL10.GL_TEXTURE_MAG_FILTER, magFilter);
    }    
    
    /**
     * Vincula textura para ser manipulada.
     */
    public void bind() {
        GL10 gl = glGraphics.getGL();
        gl.glBindTexture(GL10.GL_TEXTURE_2D, textureId);
    }
    
    /**
     * Desvincula textura e libera memória do buffer. Guarda referência do id da textura para caso seja necessário utilizá-la novamente.
     */
    public void dispose() {
        GL10 gl = glGraphics.getGL();
        gl.glBindTexture(GL10.GL_TEXTURE_2D, textureId);
        int[] textureIds = { textureId };
        gl.glDeleteTextures(1, textureIds, 0);
    }
}