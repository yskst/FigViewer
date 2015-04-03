package figView.lib;

import java.awt.image.BufferedImage;

public abstract class filter {

	public static filter getFilter(String type){
		filter f = null;
		if(type.equals("smooth")){
			f = new SmoothingFilter();
		}else if(type.equals("gaussian")){
			f = new GaussianFilter();
		}

		return f;
	}

	public BufferedImage filtering(BufferedImage src) {
		int w = src.getWidth();
		int h = src.getHeight();
		BufferedImage dst = new BufferedImage(w, h, src.getType());

		for (int i = 0; i < w; i++) {
			for (int j = 0; j < h; j++) {
				dst.setRGB(i, j, filterPixel(src, i, j));
			}
		}
		return dst;
	}

	// internally used variable and functions.------------------------
	protected final int FILTER_SIZE = 9;
	protected double filter[] = new double[FILTER_SIZE];

	private final int getFilterSize() {
		return FILTER_SIZE;
	}

	// The argument is Relative coordinate from target pixel.
	private final double getFilterValue(int x, int y) {
		x += 1;
		y += 1;

		int width = (int) Math.sqrt(FILTER_SIZE);
		int i = y * width + x;

		return filter[i];
	}

	private int filterPixel(BufferedImage src, int x, int y){
		double r = 0, g = 0, b = 0 ;
		int w = src.getWidth();
		int h = src.getHeight();

		for(int i = -1; i <= 1; i++){
			if(x+i < 0 || x+i >= w) continue;
			for(int j = -1; j <= 1; j++){
				if(y + j < 0 || y+j >= h) continue;
				int temp = src.getRGB(x+i, y+j);
				double fv = getFilterValue(i, j);

				r += fv * figUtil.getR(temp);
				g += fv * figUtil.getG(temp);
				b += fv * figUtil.getB(temp);
			}
		}

		if(r < 0) r = 0;
		else if(r > 254) r = 254;

		if(g < 0) g = 0;
		else if(g > 254) g = 254;

		if(b < 0) b = 0;
		else if(b > 254) b = 254;

		return figUtil.synthesizeColor((int)r, (int)g, (int)b);
	}


}

class SmoothingFilter extends filter {
	SmoothingFilter() {
		double temp = 1.0 / 9.0;
		for (int i = 0; i < FILTER_SIZE; i++) {
			filter[i] = temp;
		}
	}
}

class GaussianFilter extends filter {
	GaussianFilter() {
		filter[0] = filter[2] = filter[6] = filter[8] = 1.0 / 16.0;
		filter[1] = filter[3] = filter[5] = filter[7] = 2.0 / 16.0;
		filter[4] = 4.0 / 16.0;
	}
}