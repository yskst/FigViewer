package figView;


import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MyMenu extends JMenuBar {
	MyMenu(ActionListener al){
		super();
		FileMenu filemenu = new FileMenu(al);
		add(filemenu);
		setVisible(true);
	}
}

class FileMenu extends JMenu{
	FileMenu(ActionListener al){
		super("File");

		JMenuItem item_open = new JMenuItem("Open");
		JMenuItem item_exit = new JMenuItem("Exit");
		add(item_open);
		add(item_exit);
		
		item_open.addActionListener(al);
		item_exit.addActionListener(al);
		setVisible(true);
	}
}