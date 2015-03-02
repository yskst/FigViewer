package figView;

import javax.swing.JFileChooser;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MyMenu extends JMenuBar {
	MyMenu(){
		super();
		FileMenu filemenu = new FileMenu();
		add(filemenu);
		setVisible(true);
	}
}

class FileMenu extends JMenu{
	private JFileChooser fileChooser = null;

	FileMenu(){
		super("File");
		fileChooser = new JFileChooser();

		JMenuItem item_open = new JMenuItem("Open");
		JMenuItem item_exit = new JMenuItem("Exit");
		add(item_open);
		add(item_exit);
		setVisible(true);
	}
}