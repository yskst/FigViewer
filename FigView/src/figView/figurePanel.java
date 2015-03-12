package figView;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.swing.JPanel;

import figView.lib.figIO;

public class figurePanel extends JPanel {
	private BufferedImage img = null;

	public figurePanel(){
		super();
	}

	public figurePanel(String filename){
		super();
		loadFile(filename);
	}

	public void loadFile(String filename){
		File f = new File(filename);
		loadFile(f);
	}

	public void loadFile(File f){
		img = figIO.ReadFile(f);
	}

	public void saveFile(File f){
		figIO.SaveFile(f, img);
	}
	
	// Getter
	public BufferedImage getImg(){ return img; }

	// Setter
	public void setImg(BufferedImage b){ img = b; }

	protected void paintComponent(Graphics g){
		if(img != null){
			g.drawImage(img, 0, 0, getSize().width, getSize().height, this);
		}
	}
}
