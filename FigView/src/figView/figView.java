package figView;

import javax.swing.JFrame;


public class figView extends JFrame {
	private figurePanel fp = null;

	public figView(){
		super("Figure View");
		setSize(640, 720);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		MyMenu m = new MyMenu();
		setJMenuBar(m);

		fp = new figurePanel();
		add(fp);

		setVisible(true);
	}

	public static void main(String[] args) {
		// TODO 自動生成されたメソッド・スタブ
		figView v = new figView();
	}
}
