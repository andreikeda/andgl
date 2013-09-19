package br.com.limaogames.framework.gl;

import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.nio.IntBuffer;
import java.nio.ShortBuffer;

import javax.microedition.khronos.opengles.GL10;

import br.com.limaogames.framework.impl.GLGraphics;

/**
 * Classe intermedi�ria para utiliza��o de funcionalidades de openGL.
 * 
 * @author Andr� <br />
 * <b>Email:</b> andreikeda@limaogames.com.br <br />
 * created on: 31/07/2013
 * @version 1.0
 * @see
 */
public class Vertices {
	final GLGraphics glGraphics;
	final boolean hasColor;
	final boolean hasTexCoords;
	final int vertexSize;
	final IntBuffer vertices;
	final int[] tmpBuffer;
	final ShortBuffer indices;

	/**
	 * Construtor da classe.
	 * 
	 * @param glGraphics
	 * @param maxVertices - Inteiro do m�ximo de vertices permitidos.
	 * @param maxIndices - Inteiro do m�ximo de �ndices permitidos.
	 * @param hasColor - Boolean de cor.
	 * @param hasTexCoords - Boolean de coordenadas relativas.
	 */
	public Vertices(GLGraphics glGraphics, int maxVertices, int maxIndices, boolean hasColor, boolean hasTexCoords) {
		this.glGraphics = glGraphics;
		this.hasColor = hasColor;
		this.hasTexCoords = hasTexCoords;
		this.vertexSize = (2 + (hasColor?4:0) + (hasTexCoords?2:0)) * 4;
		this.tmpBuffer = new int[maxVertices * vertexSize / 4];

		ByteBuffer buffer = ByteBuffer.allocateDirect(maxVertices * vertexSize);
		buffer.order(ByteOrder.nativeOrder());
		vertices = buffer.asIntBuffer();

		if(maxIndices > 0) {
			buffer = ByteBuffer.allocateDirect(maxIndices * Short.SIZE / 8);
			buffer.order(ByteOrder.nativeOrder());
			indices = buffer.asShortBuffer();
		} else {
			indices = null;
		}            
	}

	/**
	 * Limpa os valores definidos para texturiza��o e recria utilizando os valores passados por par�metro.
	 * 
	 * @param vertices - Vetor de float com coordenadas.
	 * @param offset - Inteiro do offset do primeiro elemento do vetor de coordenadas.
	 * @param length - Inteiro do tamanho do buffer.
	 */
	public void setVertices(float[] vertices, int offset, int length) {
		this.vertices.clear();
		int len = offset + length;
		for(int i=offset, j=0; i < len; i++, j++) 
			tmpBuffer[j] = Float.floatToRawIntBits(vertices[i]);
		this.vertices.put(tmpBuffer, 0, length);
		this.vertices.flip();
	}

	/**
	 * Limpa os �ndices definidos para texturiza��o e recria utilizando os valores passados por par�metro.
	 * 
	 * @param indices - Vetor de short com novos �ndices.
	 * @param offset - Inteiro do offset do primeiro elemento do vetor de �ndices.
	 * @param length - Inteiro do tamanho do buffer.
	 */
	public void setIndices(short[] indices, int offset, int length) {
		this.indices.clear();
		this.indices.put(indices, offset, length);
		this.indices.flip();
	}

	/**
	 * Vincula o objeto para utilizar o m�todo {@code draw()}.
	 */
	public void bind() {
		GL10 gl = glGraphics.getGL();

		gl.glEnableClientState(GL10.GL_VERTEX_ARRAY);
		vertices.position(0);
		gl.glVertexPointer(2, GL10.GL_FLOAT, vertexSize, vertices);

		if(hasColor) {
			gl.glEnableClientState(GL10.GL_COLOR_ARRAY);
			vertices.position(2);
			gl.glColorPointer(4, GL10.GL_FLOAT, vertexSize, vertices);
		}

		if(hasTexCoords) {
			gl.glEnableClientState(GL10.GL_TEXTURE_COORD_ARRAY);
			vertices.position(hasColor?6:2);
			gl.glTexCoordPointer(2, GL10.GL_FLOAT, vertexSize, vertices);
		}
	}

	/**
	 * Desenha o item pr�-definido.
	 * 
	 * @param primitiveType - Inteiro do tipo primitivo a ser desenhado.
	 * @param offset - Inteiro do offset do elemento.
	 * @param numVertices - Inteiro do n�mero de v�rtices da figura.
	 */
	public void draw(int primitiveType, int offset, int numVertices) {        
		GL10 gl = glGraphics.getGL();

		if(indices!=null) {
			indices.position(offset);
			gl.glDrawElements(primitiveType, numVertices, GL10.GL_UNSIGNED_SHORT, indices);
		} else {
			gl.glDrawArrays(primitiveType, offset, numVertices);
		}        
	}

	/**
	 * Desvincula o objeto liberando espa�o no buffer e limpando os vetores de coordenadas e �ndice.
	 */
	public void unbind() {
		GL10 gl = glGraphics.getGL();
		if(hasTexCoords)
			gl.glDisableClientState(GL10.GL_TEXTURE_COORD_ARRAY);

		if(hasColor)
			gl.glDisableClientState(GL10.GL_COLOR_ARRAY);
	}
}
