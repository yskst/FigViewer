package figView.lib;

import java.awt.image.BufferedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class figIO {
	public static BufferedImage ReadFile(String filename){
		File f = new File(filename);
		return ReadFile(f);
	}

	public static BufferedImage ReadFile(File f){
		try{
			return ImageIO.read(f);
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}
}
