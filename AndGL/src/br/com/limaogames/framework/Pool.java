package br.com.limaogames.framework;

import java.util.ArrayList;
import java.util.List;

import br.com.limaogames.framework.interfaces.PoolObjectFactory;

/**
 * Classe para manter no buffer as imagens a fim de não sobrecarregar o dispositivo.
 * 
 * @author André <br />
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
     * @param maxSize - Quantidade máxima de objetos que poderão ser adicionados.
     */
    public Pool(PoolObjectFactory<T> factory, int maxSize) {
        this.factory = factory;
        this.maxSize = maxSize;
        this.freeObjects = new ArrayList<T>(maxSize);
    }

    /**
     * Método para criar um novo objeto na "piscina de objetos". Caso não haja espaço suficiente, o último objeto é substituído pelo novo.
     * 
     * @return T - Objeto sem definição.
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
     * Objeto é adicionar a lista de objetos "fora da piscina".
     *  
     * @param object - Objeto sem definição.
     */
    public void free(T object) {
        if (freeObjects.size() < maxSize)
            freeObjects.add(object);
    }
}
