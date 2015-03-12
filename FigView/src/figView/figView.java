package figView;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.UIManager;

import figView.lib.figUtil;


public class figView extends JFrame implements ActionListener{
	private File f = null;
	private figurePanel fp = null;
	private JFileChooser fileChooser = null;

	public figView(){
		super("Figure View");
		setSize(640, 720);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		try {
			UIManager.setLookAndFeel("com.sun.java.swing.plaf.windows.WindowsLookAndFeel");
		} catch (Exception e) {
			System.err.println(e.getMessage());
		}

		MyMenu m = new MyMenu(this);
		setJMenuBar(m);

		fileChooser = new JFileChooser();

		fp = new figurePanel();
		add(fp);

		setVisible(true);
	}

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		figView v = new figView();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		String cmd = e.getActionCommand();
		System.err.print(cmd + " called.\n");
		if(cmd.equals("Open")){
			int  r = fileChooser.showOpenDialog(this);
			if(r == JFileChooser.APPROVE_OPTION){
				f = fileChooser.getSelectedFile();
				System.err.println(f.getName() + " opened.");
				fp.loadFile(f);
				fp.repaint();
			}
		}else if(cmd.equals("Save")){
			fp.saveFile(f);
		}else if(cmd.equals("Exit")){
			System.exit(0);
		}else if(cmd.equals("reverse") && fp != null){
			BufferedImage bi = fp.getImg();
			bi = figUtil.reverse(bi);
			fp.setImg(bi);
			fp.repaint();
		}
	}
}
