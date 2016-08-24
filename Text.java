package com.sorrer.utils;

import com.badlogic.gdx.graphics.Color;
import com.badlogic.gdx.graphics.g2d.BitmapFont;
import com.badlogic.gdx.graphics.g2d.GlyphLayout;
import com.badlogic.gdx.graphics.g2d.SpriteBatch;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator;
import com.badlogic.gdx.graphics.g2d.freetype.FreeTypeFontGenerator.FreeTypeFontParameter;

public class Text {
	GlyphLayout layout;
	BitmapFont font;
	boolean isFreetype;
	
	FreeTypeFontGenerator generator;
	FreeTypeFontParameter params;
	
	public Text(BitmapFont bFont){
		isFreetype = false;
		this.font = bFont;
		layout = new GlyphLayout();
		layout.setText(font, "null");
	}
	
	public Text(FreeTypeFontGenerator ftfg){
		isFreetype = true;
		this.generator = ftfg;
		params = new FreeTypeFontParameter();
		this.font = this.generator.generateFont(params);
		layout = new GlyphLayout();
		layout.setText(font, "null");
		
	}
	
	public Text(FreeTypeFontGenerator ftfg, FreeTypeFontParameter params){
		isFreetype = true;
		this.generator = ftfg;
		this.params = params;
		this.font = this.generator.generateFont(params);
		layout = new GlyphLayout();
		layout.setText(font, "null");
		
	}
	
	/**
	 * Use to update freetype font
	 */
	public void update(){
		this.font = generator.generateFont(params);
	}
	
	public void setColor(Color color){
		if(isFreetype){
			params.color = color;
			return;
		}
		font.setColor(color);
	}
	
	public void setFontSize(float fontSize){
		if(isFreetype){
			params.size = (int)fontSize;
			return;
		}
		font.getData().setScale(fontSize);	
	}
	
	public void setParams(FreeTypeFontParameter params){
		if(!isFreetype) return;
		this.params = params;
	}
	
	public void draw(String text, SpriteBatch batch, float x, float y){
		layout.setText(font, text);
		font.draw(batch, layout, x, y);
	}
	
	public float getStringLength(String text){
		layout.setText(font, text);
		return layout.width;
	}
	
	public float getStringHeight(String text){
		layout.setText(font, text);
		return layout.height;
	}
	
	public void dispose(){
		generator.dispose();
		font.dispose();
	}
	
	
}
