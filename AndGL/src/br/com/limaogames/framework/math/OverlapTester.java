package br.com.limaogames.framework.math;

import br.com.limaogames.framework.util.Display;

/**
 * Classe utilit�rio para verificar a sobreposi��o de objetos.
 * 
 * @author Andr� <br />
 * <b>Email:</b> andreikeda@limaogames.com.br <br />
 * created on: 31/07/2013
 * @version 1.0
 * @see Circle
 * @see Rectangle
 * @see Vector2
 */
public class OverlapTester {
	
	/**
	 * Verifica se duas inst�ncias distintas de {@link Circle} est�o sobrepostas.
	 * 
	 * @param c1 - Inst�ncia de {@link Circle} 1.
	 * @param c2 - Inst�ncia de {@link Circle} 2.
	 * @return Boolean <b>true</b> se inst�ncias est�o sobrepostas ou <b>false</b> caso contr�rio.
	 */
    public static boolean overlapCircles(Circle c1, Circle c2) {
        float distance = c1.center.distSquared(c2.center);
        float radiusSum = c1.radius + c2.radius;
        return distance <= radiusSum * radiusSum;
    }
    
    /**
     * Verifica se duas inst�ncia distintas de {@link Rectangle} est�o sobrepostas.
     * 
     * @param r1 - Inst�ncia de {@link Rectangle} 1.
     * @param r2 - Inst�ncia de {@link Rectangle} 2.
     * @return Boolean <b>true</b> se inst�ncias est�o sobrepostas ou <b>false</b> caso contr�rio.
     */
    public static boolean overlapRectangles(Rectangle r1, Rectangle r2) {
        if(r1.lowerLeft.x < r2.lowerLeft.x + r2.width &&
           r1.lowerLeft.x + r1.width > r2.lowerLeft.x &&
           r1.lowerLeft.y < r2.lowerLeft.y + r2.height &&
           r1.lowerLeft.y + r1.height > r2.lowerLeft.y)
            return true;
        else
            return false;
    }
    
    /**
     * Verifica se inst�ncia de {@link Circle} e inst�ncia de {@link Rectangle} est�o sobrepostas.
     *  
     * @param c - Inst�ncia de {@link Circle}.
     * @param r - Inst�ncia de {@link Rectangle}.
     * @return Boolean <b>true</b> se inst�ncias est�o sobrepostas ou <b>false</b> caso contr�rio.
     */
    public static boolean overlapCircleRectangle(Circle c, Rectangle r) {
        float closestX = c.center.x;
        float closestY = c.center.y;
        
        if(c.center.x < r.lowerLeft.x) {
            closestX = r.lowerLeft.x; 
        } 
        else if(c.center.x > r.lowerLeft.x + r.width) {
            closestX = r.lowerLeft.x + r.width;
        }
          
        if(c.center.y < r.lowerLeft.y) {
            closestY = r.lowerLeft.y;
        } 
        else if(c.center.y > r.lowerLeft.y + r.height) {
            closestY = r.lowerLeft.y + r.height;
        }
        
        return c.center.distSquared(closestX, closestY) < c.radius * c.radius;           
    }
    
    /**
     * Verifica se inst�ncia determinada por {@link Vector2} est� sobreposta � inst�ncia de {@link Circle}. 
     *  
     * @param c - Inst�ncia de {@link Circle}.
     * @param p - Inst�ncia de {@link Vector2}.
     * @return Boolean <b>true</b> se inst�ncias est�o sobrepostas ou <b>false</b> caso contr�rio.
     */
    public static boolean pointInCircle(Circle c, Vector2 p) {
        return c.center.distSquared(p) < c.radius * c.radius;
    }
    
    /**
     * Verifica se ponto determinado por par�metro est� sobreposta � inst�ncia de {@link Circle}.
     * 
     * @param c - Inst�ncia de {@link Circle}.
     * @param x - Float coordenada x do p�nto.
     * @param y - Float coordenada y do ponto.
     * @return Boolean <b>true</b> se inst�ncias est�o sobrepostas ou <b>false</b> caso contr�rio.
     */
    public static boolean pointInCircle(Circle c, float x, float y) {
        return c.center.distSquared(x, y) < c.radius * c.radius;
    }
    
    /**
     * Verifica se inst�ncia determinada por {@link Vector2} est� sobreposta � inst�ncia de {@link Circle}.
     * 
     * @param r - Inst�ncia de {@link Rectangle}.
     * @param p - Inst�ncia de {@link Vector2}.
     * @return Boolean <b>true</b> se inst�ncias est�o sobrepostas ou <b>false</b> caso contr�rio.
     */
    public static boolean pointInRectangle(Rectangle r, Vector2 p) {
        return r.lowerLeft.x <= p.x && r.lowerLeft.x + r.width >= p.x &&
               r.lowerLeft.y <= p.y && r.lowerLeft.y + r.height >= p.y;
    }
    
    /**
     * Verifica se ponto determinado por par�metro est� sobreposta � inst�ncia de {@link Rectangle}.
     * 
     * @param r - Inst�ncia de {@link Rectangle}.
     * @param x - Float coordenada x de ponto.
     * @param y - Float coordenada y de ponto.
     * @return Boolean <b>true</b> se inst�ncias est�o sobrepostas ou <b>false</b> caso contr�rio.
     */
    public static boolean pointInRectangle(Rectangle r, float x, float y) {
    	float newY = Display.height - y;
        return r.lowerLeft.x <= x && r.lowerLeft.x + r.width >= x &&
               r.lowerLeft.y <= newY && r.lowerLeft.y + r.height >= newY;
    }
}