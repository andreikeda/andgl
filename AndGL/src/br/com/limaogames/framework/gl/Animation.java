package br.com.limaogames.framework.gl;

/**
 * Classe para prover suporte a elementos animados.
 * 
 * @author André <br />
 * <b>Email:</b> andreikeda@limaogames.com.br <br />
 * created on: 31/07/2013
 * @version 1.0
 * @see
 */
public class Animation {
	public static final int ANIMATION_LOOPING 		= 0;
	public static final int ANIMATION_NONLOOPING 	= 1;
	public static final int ANIMATION_EXCLUDE		= 2;

	final TextureRegion[] keyFrames;
	final float frameDuration;

	/**
	 * Construtor da classe.
	 * 
	 * @param frameDuration - Float com o intervalo de troca de frames.
	 * @param keyFrames - Lista com as imagens para animação.
	 */
	public Animation(float frameDuration, TextureRegion ... keyFrames) {
		this.frameDuration = frameDuration;
		this.keyFrames = keyFrames;
	}

	/**
	 * Retorna objeto de {@link TextureRegion}.
	 * 
	 * @param stateTime - Float com o deltaTime da aplicação.
	 * @param mode - <b>ANIMATION_LOOPING</b> para animação com loop; <br> - <b>ANIMATION_NONLOOPING</b> para animação sem loop; <br> - <b>ANIMATION_EXCLUDE</b> para excluir objeto após o ciclo da animação.
	 * @return Objeto de {@link TextureRegion}.
	 */
	public TextureRegion getKeyFrame(float stateTime, int mode) {
		int frameNumber = (int)(stateTime / frameDuration);

		if (mode == ANIMATION_EXCLUDE) {
			if (frameNumber == (keyFrames.length - 1))
				return null;
			else
				frameNumber = Math.min(keyFrames.length-1, frameNumber); 
		}
		else {
			if(mode == ANIMATION_NONLOOPING) {
				frameNumber = Math.min(keyFrames.length-1, frameNumber);            
			}
			else {
				frameNumber = frameNumber % keyFrames.length;
			}
		}
		return keyFrames[frameNumber];
	}
}
