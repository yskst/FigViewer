package figView.lib;

import java.awt.image.BufferedImage;
import java.awt.image.RenderedImage;
import java.io.File;

import javax.imageio.ImageIO;

public class figIO {
	
	private static String name2Type(String filename){
		// Get suffix.
		int n = filename.lastIndexOf(".");
		if(n == -1) return null;
		return filename.substring(n + 1);
	}
	
	public static BufferedImage ReadFile(String filename){
		File f = new File(filename);
		return ReadFile(f);
	}

	public static BufferedImage ReadFile(File f){
		try{
			return ImageIO.read(f);
		}catch(Exception e){
			e.printStackTrace();
			System.err.println("Failed to read " + f.getName());
			return null;
		}
	}
	
	public static void SaveFile(File f, RenderedImage ri){
		String type = name2Type(f.getName());
		try{
			ImageIO.write(ri, type, f);
		}catch(Exception e){
			e.printStackTrace();
			System.err.println("Failed to write " + f.getName());
		}
	}
}
