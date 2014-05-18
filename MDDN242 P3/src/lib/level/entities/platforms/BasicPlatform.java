package lib.level.entities.platforms;

import lib.Style;
import lib.level.Level;
import processing.core.PGraphics;

public class BasicPlatform extends AbstractPlatform {

	private Style style;

	public BasicPlatform(Level level, float x, float y, float width, float height) {
		this(level, x, y, width, height, new Style());
	}
	
	public BasicPlatform(Level level, float x, float y, float width, float height, Style style) {
		super(level, x, y, width, height);
		this.style = style;
	}
	
	public BasicPlatform(Level level, float x, float y, float z, float width, float height, float depth) {
		this(level, x, y, z, width, height, depth, new Style());
	}
	
	public BasicPlatform(Level level, float x, float y, float z, float width, float height, float depth, Style style) {
		super(level, x, y, z, width, height, depth);
		this.style = style;
	}

	@Override
	public void update(float delta) {
		
	}

	@Override
	public void draw(PGraphics g, float delta) {
		if(getLevel().is3D()){
			draw3D(g, delta);
		}
		else{
			draw2D(g, delta);
		}
	}
	
	private void draw2D(PGraphics g, float delta) {
		style.apply(g);
		g.rect(0, 0, getWidth(), getHeight());
	}
	
	private void draw3D(PGraphics g, float delta) {
		style.apply(g);
		g.box(getWidth(), getHeight(), getDepth());
	}
}