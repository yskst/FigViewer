package figView.lib;

import java.awt.image.BufferedImage;

public class figUtil {

	// parse color into RGB value.
	public static int getR(int color){ return color & 0xff; }
	public static int getG(int color){ return (color >> 8) & 0xff; }
	public static int getB(int color){ return (color >> 16) & 0xff; }

	// The each pixel value must be under 255.
	public static int synthesizeColor(int r, int g, int b){ return r | (g << 8) | (b << 16); }

	private static int reversePixel(int color){
		int r = 255 - getR(color);
		int g = 255 - getG(color);
		int b = 255 - getB(color);

		int newColor = synthesizeColor(r,g,b);

		return newColor;
	}

	// reverse color with safety.
	public static BufferedImage reverse(BufferedImage f){
		int w = f.getWidth();
		int h = f.getHeight();
		int t = f.getType();
		BufferedImage bi = new BufferedImage(w, h, t);

		int c;
		for(int i = 0; i < w; i++){
			for(int j = 0; j < h; j++){
				c = f.getRGB(i, j);
				c = reversePixel(c);
				bi.setRGB(i, j, c);
			}
		}
		return bi;
	}
}



