package com.sorrer.utils;

import com.badlogic.gdx.assets.AssetDescriptor;
import com.badlogic.gdx.assets.AssetManager;
import com.badlogic.gdx.assets.loaders.resolvers.InternalFileHandleResolver;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGeneratorLoader;

public class Assets {
	public static final AssetManager manager = new AssetManager();
	public static final AssetManager freeTypeManager = new AssetManager();
	
	public static final AssetDescriptor<FreeTypeFontGenerator> dialog = new AssetDescriptor<FreeTypeFontGenerator>("", FreeTypeFontGenerator.class);
	
	public static void load(){
		
		freeTypeManager.setLoader(FreeTypeFontGenerator.class, new FreeTypeFontGeneratorLoader(new InternalFileHandleResolver()));
		freeTypeManager.load(dialog);
	}
	
	public static void dipose(){
		
	}
}
