package figView;


import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class MyMenu extends JMenuBar {
	MyMenu(ActionListener al){
		super();
		FileMenu fm = new FileMenu(al);
		EditMenu em = new EditMenu(al);
		add(fm);
		add(em);
		setVisible(true);
	}
}

class FileMenu extends JMenu{
	FileMenu(ActionListener al){
		super("File");

		JMenuItem item_open = new JMenuItem("Open");
		JMenuItem item_save = new JMenuItem("Save");
		JMenuItem item_asave = new JMenuItem("Save to Another File");
		JMenuItem item_exit = new JMenuItem("Exit");
		add(item_open);
		add(item_save);
		add(item_asave);
		add(item_exit);

		item_open.addActionListener(al);
		item_save.addActionListener(al);
		item_asave.addActionListener(al);
		item_exit.addActionListener(al);
		setVisible(true);
	}
}


class EditMenu extends JMenu{
	EditMenu(ActionListener al){
		super("Edit");
		JMenuItem item_reverse = new JMenuItem("reverse");
		add(item_reverse);

		JMenu filter = new JMenu("Filter");
		JMenuItem smooth = new JMenuItem("smooth");
		JMenuItem gauss = new JMenuItem("gaussian");
		filter.add(smooth);
		filter.add(gauss);
		add(filter);

		item_reverse.addActionListener(al);
		smooth.addActionListener(al);
		gauss.addActionListener(al);
		setVisible(true);
	}
}