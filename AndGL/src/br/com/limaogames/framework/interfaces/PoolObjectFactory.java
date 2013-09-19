package br.com.limaogames.framework.interfaces;

/**
 * Interface para administrar conjuntos de objetos distintos a fim de manter a performance da aplicação satisfatória.
 * 
 * @author André <br />
 * <b>Email:</b> andreikeda@limaogames.com.br <br />
 * created on: 31/07/2013
 * @version 1.0
 * @see 
 */
public interface PoolObjectFactory<T> {
	/**
	 * Cria instância de objeto indefinido.
	 * 
	 * @return Objeto indefinido.
	 */
	public T createObject();
}
