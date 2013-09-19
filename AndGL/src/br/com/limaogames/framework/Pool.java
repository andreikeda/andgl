package br.com.limaogames.framework;

import java.util.ArrayList;
import java.util.List;

import br.com.limaogames.framework.interfaces.PoolObjectFactory;

/**
 * Classe para manter no buffer as imagens a fim de n�o sobrecarregar o dispositivo.
 * 
 * @author Andr� <br />
 * <b>Email:</b> andreikeda@limaogames.com.br <br />
 * created on: 31/07/2013
 * @version 1.0
 * @see
 */
public class Pool<T> {

    private final List<T> freeObjects;
    private final PoolObjectFactory<T> factory;
    private final int maxSize;

    /**
     * Construtor
     * 
     * @param factory - Interface para criar objeto.
     * @param maxSize - Quantidade m�xima de objetos que poder�o ser adicionados.
     */
    public Pool(PoolObjectFactory<T> factory, int maxSize) {
        this.factory = factory;
        this.maxSize = maxSize;
        this.freeObjects = new ArrayList<T>(maxSize);
    }

    /**
     * M�todo para criar um novo objeto na "piscina de objetos". Caso n�o haja espa�o suficiente, o �ltimo objeto � substitu�do pelo novo.
     * 
     * @return T - Objeto sem defini��o.
     */
    public T newObject() {
        T object = null;

        if (freeObjects.size() == 0)
            object = factory.createObject();
        else
            object = freeObjects.remove(freeObjects.size() - 1);

        return object;
    }

    /**
     * Objeto � adicionar a lista de objetos "fora da piscina".
     *  
     * @param object - Objeto sem defini��o.
     */
    public void free(T object) {
        if (freeObjects.size() < maxSize)
            freeObjects.add(object);
    }
}
