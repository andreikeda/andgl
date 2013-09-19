package br.com.limaogames.framework.math;

import android.annotation.SuppressLint;
import android.util.FloatMath;

/**
 * Classe para criação de vetores geométricos.
 * 
 * @author André <br />
 * <b>Email:</b> andreikeda@limaogames.com.br <br />
 * created on: 31/07/2013
 * @version 1.0
 * @see
 */
@SuppressLint("FloatMath")
public class Vector2 {
    public static float TO_RADIANS = (1 / 180.0f) * (float)Math.PI;
    public static float TO_DEGREES = (1 / (float)Math.PI) * 180;
    public float x, y;
    
    /**
     * Construtor da classe.
     */
    public Vector2() {    
    }       
    
    /**
     * Construtor da classe.
     * 
     * @param x - Float coordenada x.
     * @param y - Float coordenada y.
     */
    public Vector2(float x, float y) {
        this.x = x;
        this.y = y;
    }
    
    /**
     * Construtor da classe a partir de outro objeto de {@link Vector2}.
     * 
     * @param other - Objeto de {@link Vector2}.
     */
    public Vector2(Vector2 other) {
        this.x = other.x;
        this.y = other.y;
    }
    
    /**
     * Cria uma nova instância de {@link Vector2}.
     * 
     * @return Objeto de {@link Vector2}.
     */
    public Vector2 cpy() {
        return new Vector2(x, y);
    }       
    
    /**
     * Define a instância de {@link Vector2} com os valores passados por parâmetro.
     * 
     * @param x - Float coordenada x.
     * @param y - Float coordenada y.
     * @return Objeto de {@link Vector2}.
     */
    public Vector2 set(float x, float y) {
        this.x = x;
        this.y = y;
        return this;
    }
    
    /**
     * Define a instância de {@link Vector2} a partir de outra instância de {@link Vector2}.
     * 
     * @param other - Objeto de {@link Vector2}.
     * @return Objeto de {@link Vector2}.
     */
    public Vector2 set(Vector2 other) {
        this.x = other.x;
        this.y = other.y;
        return this;
    }
    
    /**
     * Soma valores passados por parâmetro na instância de {@link Vector2}.
     * 
     * @param x - Float incremento da coordenada x.
     * @param y - Float incremento da coordenada y.
     * @return Objeto de {@link Vector2}.
     */
    public Vector2 add(float x, float y) {
        this.x += x;
        this.y += y;
        return this;
    }
    
    /**
     * Soma um objeto de {@link Vector2} na instância de {@link Vector2}.
     * 
     * @param other - Objeto de {@link Vector2}.
     * @return Objeto de {@link Vector2}.
     */
    public Vector2 add(Vector2 other) {
        this.x += other.x;
        this.y += other.y;
        return this;
    }
    
    /**
     * Subtrai valores passados por parâmetro na instância de {@link Vector2}.
     * 
     * @param x - Float decremento da coordenada x.
     * @param y - Float decremento da coordenada y.
     * @return Objeto de {@link Vector2}.
     */
    public Vector2 sub(float x, float y) {
        this.x -= x;
        this.y -= y;
        return this;
    }
    
    /**
     * Subtrai um objeto de {@link Vector2} na instância de {@link Vector2}.
     * 
     * @param other - Objeto de {@link Vector2}.
     * @return Objeto de {@link Vector2}.
     */
    public Vector2 sub(Vector2 other) {
        this.x -= other.x;
        this.y -= other.y;
        return this;
    }
    
    /**
     * Multiplica coordenadas da instância de {@link Vector2} por um valor escalar.
     * 
     * @param scalar - Float multiplicador escalar.
     * @return Objeto de {@link Vector2}.
     */
    public Vector2 mul(float scalar) {
        this.x *= scalar;
        this.y *= scalar;
        return this;
    }
    
    /**
     * Retorna tamanho da instância de {@link Vector2}.
     * 
     * @return Float tamanho da instância de {@link Vector2}.
     */
    public float len() {               
        return FloatMath.sqrt(x*x + y*y);
    }
    
    /**
     * 
     * @return
     */
    public Vector2 nor() {
        float len = len();
        if(len!=0) {
            this.x /= len;
            this.y /= len;
        }
        return this;
    }       

    /**
     * Retorna o ângulo em graus.
     * 
     * @return Float ângulo em graus.
     */
    public float angle() {
        float angle = (float)Math.atan2(y, x) * TO_DEGREES;
        if(angle < 0)
            angle += 360;
        return angle;
    }       
    
    /**
     * Rotaciona instância de {@link Vector2} de acordo com o parâmetro.
     * 
     * @param angle - Float ângulo de rotação em graus.
     * @return Objeto de {@link Vector2}.
     */
    public Vector2 rotate(float angle) {
        float rad = angle * TO_RADIANS;
        float cos = FloatMath.cos(rad);
        float sin = FloatMath.sin(rad);
        
        float newX = this.x * cos - this.y * sin;
        float newY = this.x * sin + this.y * cos;
        
        this.x = newX;
        this.y = newY;
        
        return this;
    }

    /**
     * Calcula distância entre duas instâncias de {@link Vector2}.
     * 
     * @param other - Objeto de {@link Vector2}.
     * @return Float distância entre duas instâncias de {@link Vector2}.
     */
    public float dist(Vector2 other) {
        float distX = this.x - other.x;
        float distY = this.y - other.y;        
        return FloatMath.sqrt(distX*distX + distY*distY);
    }   

    /**
     * Calcula distância entre um ponto definido por parâmetro e a instância de {@link Vector2}.
     * 
     * @param x - Float coordenada x.
     * @param y - Float coordenada y.
     * @return Float distância entre instância de {@link Vector2} e ponto definido por parâmetro.
     */
    public float dist(float x, float y) {
        float distX = this.x - x;
        float distY = this.y - y;        
        return FloatMath.sqrt(distX*distX + distY*distY);
    }   

    /**
     * Calcula o quadrado da distância entre duas instâncias de {@link Vector2}.
     * 
     * @param other - Objeto de {@link Vector2}.
     * @return Float distância entre duas instâncias de {@link Vector2}.
     */
    public float distSquared(Vector2 other) {
        float distX = this.x - other.x;
        float distY = this.y - other.y;        
        return distX*distX + distY*distY;
    }

    /**
     * Calcula distância entre um ponto definido por parâmetro e a instância de {@link Vector2}.
     * 
     * @param x - Float coordenada x.
     * @param y - Float coordenada y.
     * @return Float distância entre instância de {@link Vector2} e ponto definido por parâmetro.
     */
    public float distSquared(float x, float y) {
        float distX = this.x - x;
        float distY = this.y - y;        
        return distX*distX + distY*distY;
    }       
}