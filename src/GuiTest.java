import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BoxLayout;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;
import javax.swing.SwingUtilities;
import javax.swing.border.LineBorder;


@SuppressWarnings("serial")
public class GuiTest extends JFrame {
	private static final Color	GREY_BRIGHT	= new Color(245, 245, 245);
	private static final Color	BLUE_BRIGHT	= new Color(180, 205, 230);
	private static final Color	BLUE_DARK	= new Color(206, 221, 237);

	private JMenuBar			menubar;
	private JToolBar			toolbar;

	public GuiTest() {
		addMenu();

		// addToolbar();
		addCenter();

		addStatusbar();

		makeVisible();

		new Thread() {
			@Override
			public void run() {
				while (true) {
					setColor();
					try {
						Thread.sleep(250);
					} catch (InterruptedException e) {
						e.printStackTrace();
					}
				}
			}

			private void setColor() {
				// final Color dark = new Color(180, 205, 230);
				final Color dark = new Color(206, 221, 237);

				SwingUtilities.invokeLater(new Runnable() {

					@Override
					public void run() {
						menubar.setBackground(dark);
						// toolbar.setBackground(dark);
					}
				});
			};

		}.start();
	}

	private void addCenter() {
		JPanel panel = new JPanel();
		panel.setLayout(new BoxLayout(panel, BoxLayout.X_AXIS));

		JPanel innerLeftPannel = new JPanel() {
			@Override
			protected void paintComponent(Graphics g) {
				// g.setColor(BLUE_DARK);
				//
				// int width = 50;
				// int x1 = 5;
				// int y1 = 5;
				// int x2 = 5 + width + 20;
				// int y2 = 5;
				// g.fillRect(x1, y1, width, width);
				// g.fillRect(x2, y2, width, width);
			}
		};
		innerLeftPannel.setLayout(new GridLayout(5, 4, 5, 5));

		for (int i = 0; i < 20; i++) {
			JLabel label = new JLabel(i + "", SwingConstants.CENTER);
			label.setBackground(BLUE_DARK);
			label.setOpaque(true);
			innerLeftPannel.add(label);
		}

		innerLeftPannel.setBorder(LineBorder.createGrayLineBorder());

		JPanel innerRightPannel = new JPanel();
		innerRightPannel.setBorder(LineBorder.createGrayLineBorder());

		panel.add(innerLeftPannel);
		panel.add(innerRightPannel);


		add(panel, BorderLayout.CENTER);
	}

	private void addStatusbar() {
		JLabel statusbar = new JLabel("Statusbar");
		statusbar.setBorder(LineBorder.createGrayLineBorder());
		statusbar.setBackground(BLUE_BRIGHT);
		statusbar.setOpaque(true);

		add(statusbar, BorderLayout.SOUTH);
	}

	private void addToolbar() {
		toolbar = new JToolBar(JToolBar.VERTICAL);
		toolbar.setFloatable(false);
		toolbar.add(new JButton("Toolbar1"));
		toolbar.add(new JButton("Toolbar2"));

		add(toolbar, BorderLayout.WEST);
	}

	private void addMenu() {
		menubar = new JMenuBar();
		menubar.setBackground(BLUE_BRIGHT);

		JMenu file = new JMenu("File");
		JMenuItem load = new JMenuItem("Load");
		JMenuItem save = new JMenuItem("Save");
		JMenuItem exit = new JMenuItem("Exit");
		file.add(load);
		file.add(save);
		file.add(exit);

		JMenu info = new JMenu("Info");
		JMenuItem about = new JMenuItem("About");
		info.add(about);

		menubar.add(file);
		menubar.add(info);
		setJMenuBar(menubar);
	}

	private void makeVisible() {
		getContentPane().setBackground(GREY_BRIGHT);
		setSize(640, 480);
		setTitle("GuiTest");
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setVisible(true);
		setFocusable(true);
		addKeyListener(new KeyListener() {
			@Override
			public void keyTyped(KeyEvent ke) {
			}

			@Override
			public void keyReleased(KeyEvent ke) {
			}

			@Override
			public void keyPressed(KeyEvent ke) {
				if (ke.getKeyCode() == KeyEvent.VK_ESCAPE)
					GuiTest.this.dispose();
			}
		});
	}

	public static void main(String[] args) {
		new GuiTest();
	}
}
