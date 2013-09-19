package br.com.limaogames.framework.impl;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

import br.com.limaogames.framework.interfaces.FileIO;

import android.content.res.AssetManager;
import android.os.Environment;

/**
 * Classe para prover a funcionalidade para manipulação de arquivos.
 * 
 * @author André <br />
 * <b>Email:</b> andreikeda@limaogames.com.br <br />
 * created on: 31/07/2013
 * @version 1.0
 * @see FileIO
 */
public class AndroidFileIO implements FileIO {
    AssetManager assets;
    String externalStoragePath;

    /**
     * Construtor da classe.
     * 
     * @param assets - Objeto de {@link AssetManager}.
     */
    public AndroidFileIO(AssetManager assets) {
        this.assets = assets;
        this.externalStoragePath = Environment.getExternalStorageDirectory()
                .getAbsolutePath() + File.separator;
    }

    @Override
    public InputStream readAsset(String fileName) throws IOException {
        return assets.open(fileName);
    }

    @Override
    public InputStream readFile(String fileName) throws IOException {
        return new FileInputStream(externalStoragePath + fileName);
    }

    @Override
    public OutputStream writeFile(String fileName) throws IOException {
        return new FileOutputStream(externalStoragePath + fileName);
    }
}
