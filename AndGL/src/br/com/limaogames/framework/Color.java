package br.com.limaogames.framework;

/**
 * Classe para manipulação de elementos relacionados as cores.
 * 
 * @author André <br />
 * <b>Email:</b> andreikeda@limaogames.com.br <br />
 * created on: 31/07/2013
 * @version 1.0
 * @see
 */
public class Color {
	
	/**
	 * Método converte cor retornando um inteiro que a representa.
	 * 
	 * @param r - Quantidade de vermelho.
	 * @param g - Quantidade de verde.
	 * @param b - Quantidade de azul.
	 * @param a - Alpha da imagem.
	 * @return Inteiro convertido que representa a cor.
	 */
    public static int convert (int r, int g, int b, int a) {
        return ((a & 0xff) << 24) |
               ((r & 0xff) << 16) |
               ((g & 0xff) << 8) |
               ((b & 0xff));               
    }
}
