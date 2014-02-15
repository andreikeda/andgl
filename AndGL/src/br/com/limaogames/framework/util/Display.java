package br.com.limaogames.framework.util;

import br.com.limaogames.framework.R;
import br.com.limaogames.framework.interfaces.Input.TouchEvent;
import android.app.Activity;
import android.content.res.Resources.NotFoundException;
import android.util.DisplayMetrics;

/**
 * Class to set display variables and cover events bounds.
 * 
 * @author Andr� Ikeda<br />
 * Email: andreikeda87@gmail.com
 *
 */
public class Display {
	
	public static float dpi;
	public static float width;
	public static float height;
	public static float scaleX, scaleY;
	
	/**
	 * This method convets dp unit to equivalent device specific value in pixels. 
	 * 
	 * @param dp A value in dp(Device independent pixels) unit. Which we need to convert into pixels
	 * @return A float value to represent Pixels equivalent to dp according to device
	 */
	public static int convertDpToPixel(float dp){
	    int px = (int) (dp * (dpi / 160f) + 0.5f);
	    return px;
	}
	
	/**
	 * This method converts device specific pixels to device independent pixels.
	 * 
	 * @param px A value in px (pixels) unit. Which we need to convert into db
	 * @return A float value to represent db equivalent to px value
	 */
	public static float convertPixelsToDp(float px){
	    float dp = px / (dpi / 160f);
	    return dp;
	}
	
	/**
	 * Method to verify if the event that occurs is in object's bounds.
	 * 
	 * @param event - Event.
	 * @param x - Object x position.
	 * @param y - Object y position.
	 * @param width - Object width.
	 * @param height - Object height.
	 * @return <b>true</b> if event occurred in Object bounds and <b>false</b> otherwise.
	 * 
	 * @see TouchEvent
	 */
	public static boolean inBounds(TouchEvent event, int x, int y, int width, int height) {
		x = (int) (Display.width - x - width / 2);
		y = (int) (Display.height - y - height / 2);
		if (event.x > x && event.x < x + width - 1 && event.y > y && event.y < y + height - 1)
			return true;
		return false;
	}
	
	/**
	 * Method to verify if the event that occurs is in object's bounds.
	 * 
	 * @param event - Event.
	 * @param x - Object x position.
	 * @param y - Object y position.
	 * @param width - Object width.
	 * @param height - Object height.
	 * @return <b>true</b> if event occurred in Object bounds and <b>false</b> otherwise.
	 * 
	 * @see TouchEvent
	 */
	public static boolean inBounds(TouchEvent event, float x, float y, int width, int height) {
		x = Display.width - x - width / 2;
		y = Display.height - y - height / 2;
		if (event.x > x && event.x < x + width - 1 && event.y > y && event.y < y + height - 1)
			return true;
		return false;
	}
	
	/**
	 * Method to verify if the event that occurs is in object's bounds.
	 * 
	 * @param event - Event.
	 * @param x - Object x position.
	 * @param y - Object y position.
	 * @param width - Object width.
	 * @param height - Object height.
	 * @return <b>true</b> if event occurred in Object bounds and <b>false</b> otherwise.
	 * 
	 * @see TouchEvent
	 */
	public static boolean inBounds(TouchEvent event, float x, float y, float width, float height) {
		x = Display.width - x - width / 2;
		y = Display.height - y - height / 2;
		if (event.x > x && event.x < x + width - 1 && event.y > y && event.y < y + height - 1)
			return true;
		return false;
	}
	
	/**
	 * Retorna a nova altura para o objeto utilizando como altura padr�o o valor pr�-estabelecido por <b>DEFAULT_HEIGHT</b> e a altura do dispositivo.
	 * 
	 * @param oldHeight - Float altura padr�o da imagem.
	 * @return Float com a nova altura (proporcional) da imagem.
	 */
	public static float getResizedImageHeight(float oldHeight) {
		return oldHeight * scaleY;
	}
	
	/**
	 * Retorna a nova largura para o objeto utilizando como largura padr�o o valor pr�-estabelecido por <b>DEFAULT_WIDTH</b> e a largura do dispositivo.
	 * 
	 * @param oldWidth - Float largura padr�o da imagem.
	 * @return Float com a nova largura (proporcional) da imagem.
	 */
	public static float getResizedImageWidth(float oldWidth) {
		return oldWidth * scaleX;
	}
	
	/**
	 * Method to set display settings. 
	 * 
	 * @param activity - Start activity used to set display settings.
	 * 
	 * @see Activity
	 */
	public static void setWindow(Activity activity) {
		DisplayMetrics metrics = new DisplayMetrics();
		activity.getWindowManager().getDefaultDisplay().getMetrics(metrics);
		dpi		= metrics.density;

		try {
			if (activity.getResources().getBoolean(R.bool.isTablet)) {
				height	= metrics.heightPixels * dpi;
				width	= metrics.widthPixels * dpi;
			}
			else {
				height	= metrics.widthPixels * dpi;
				width	= metrics.heightPixels * dpi;
			}
		} catch (NotFoundException e) {
			height	= metrics.heightPixels * dpi;
			width	= metrics.widthPixels * dpi;
			e.printStackTrace();
		}
		
		scaleX = width / DEFAULT_WIDTH;
		scaleY = height / DEFAULT_HEIGHT;
	}
	
	/**
	 * 
	 * @param oldHeight
	 * @return
	 */
	public static float transformToDefaultHeight(float oldHeight) {
		return DEFAULT_HEIGHT * oldHeight / height;
	}
	
	/**
	 * 
	 * @param oldWidth
	 * @return
	 */
	public static float transformToDefaultWidth(float oldWidth) {
		return DEFAULT_WIDTH * oldWidth / width;
	}
	
	private final static float DEFAULT_HEIGHT	= 320;
	private final static float DEFAULT_WIDTH	= 480;

}
