import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.SystemColor;

import javax.swing.AbstractListModel;
import javax.swing.Box;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSlider;
import javax.swing.JTable;
import javax.swing.JToolBar;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EtchedBorder;
import javax.swing.table.DefaultTableModel;

public class SwingTest {

	private JFrame		frmJpadV;
	private JPanel		leftPanel;
	private JPanel		gamepadPanel;
	private JPanel		profilPanel;
	private JList		list;
	private JLabel		lblNewLabel;
	private JPanel		rightpanel;
	private JScrollPane	scrollPane;
	private JTable		table;
	private JPanel		panel;
	private JPanel		panel_1;
	private JSlider		slider;
	private JLabel		label_0;
	private JLabel		label_1;
	private JLabel		label_2;
	private JLabel		label_3;
	private JLabel		label_4;
	private JLabel		label_5;
	private JLabel		label_6;
	private JLabel		label_7;
	private JLabel		label_8;
	private JLabel		label_9;
	private JLabel		label_10;
	private JLabel		label_11;
	private JLabel		label_12;
	private JLabel		label_13;
	private JLabel		label_14;
	private JToolBar	toolBar;
	private JButton		New;
	private JButton		btnLoad;
	private JButton		btnSave;
	private JButton		button;
	private JMenuBar	menuBar;
	private JMenu		mnFile;
	private JMenu		mnInfo;
	private JMenuItem	mntmLoadProfile;
	private JMenuItem	mntmNewMenuItem;
	private JMenuItem	mntmAbout;
	private JPanel		panel_2;
	private JPanel		panel_3;
	private Component	glue;
	private JPanel		panel_4;
	private JLabel		lblLeftStick;
	private JLabel		lblRightStick;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			@Override
			public void run() {
				try {
					SwingTest window = new SwingTest();
					window.frmJpadV.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public SwingTest() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	@SuppressWarnings({ "rawtypes", "unchecked", "serial" })
	private void initialize() {
		try {
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
			// UIManager.setLookAndFeel(
			// "com.sun.java.swing.plaf.nimbus.NimbusLookAndFeel" );
		} catch (Exception e) {
			e.printStackTrace();
		}

		frmJpadV = new JFrame();
		frmJpadV.setTitle("JPad v0.1");
		frmJpadV.setBounds(100, 100, 640, 540);
		frmJpadV.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmJpadV.getContentPane().setLayout(new GridLayout(0, 2, 0, 0));

		leftPanel = new JPanel();
		frmJpadV.getContentPane().add(leftPanel);
		leftPanel.setLayout(new GridLayout(2, 1, 0, 0));

		gamepadPanel = new JPanel();
		gamepadPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		leftPanel.add(gamepadPanel);
		gamepadPanel.setLayout(new GridLayout(0, 1, 0, 0));

		panel = new JPanel();
		gamepadPanel.add(panel);
		panel.setLayout(new BorderLayout(0, 0));

		slider = new JSlider();
		slider.setEnabled(false);
		slider.setValue(60);
		slider.setPaintLabels(true);
		panel.add(slider, BorderLayout.SOUTH);

		panel_2 = new JPanel();
		panel.add(panel_2, BorderLayout.CENTER);
		panel_2.setLayout(new GridLayout(0, 3, 0, 0));

		panel_3 = new JPanel();
		panel_3.setBackground(SystemColor.inactiveCaption);
		panel_2.add(panel_3);

		lblLeftStick = new JLabel("Left Stick");
		panel_3.add(lblLeftStick);

		glue = Box.createGlue();
		panel_2.add(glue);

		panel_4 = new JPanel();
		panel_4.setBackground(SystemColor.inactiveCaption);
		panel_2.add(panel_4);

		lblRightStick = new JLabel("Right Stick");
		panel_4.add(lblRightStick);

		panel_1 = new JPanel();
		gamepadPanel.add(panel_1);
		panel_1.setLayout(new GridLayout(3, 8, 16, 5));

		label_0 = new JLabel("0", SwingConstants.CENTER);
		panel_1.add(label_0);

		label_1 = new JLabel("1", SwingConstants.CENTER);
		panel_1.add(label_1);

		label_2 = new JLabel("2", SwingConstants.CENTER);
		panel_1.add(label_2);

		label_3 = new JLabel("3", SwingConstants.CENTER);
		panel_1.add(label_3);

		label_4 = new JLabel("4", SwingConstants.CENTER);
		panel_1.add(label_4);

		label_5 = new JLabel("5", SwingConstants.CENTER);
		panel_1.add(label_5);

		label_6 = new JLabel("6", SwingConstants.CENTER);
		panel_1.add(label_6);

		label_7 = new JLabel("7", SwingConstants.CENTER);
		label_7.setOpaque(true);
		label_7.setBackground(UIManager.getColor("FormattedTextField.selectionBackground"));
		panel_1.add(label_7);

		label_8 = new JLabel("8", SwingConstants.CENTER);
		panel_1.add(label_8);

		label_9 = new JLabel("9", SwingConstants.CENTER);
		panel_1.add(label_9);

		label_10 = new JLabel("10", SwingConstants.CENTER);
		panel_1.add(label_10);

		label_11 = new JLabel("11", SwingConstants.CENTER);
		panel_1.add(label_11);

		label_12 = new JLabel("12", SwingConstants.CENTER);
		panel_1.add(label_12);

		label_13 = new JLabel("13", SwingConstants.CENTER);
		panel_1.add(label_13);

		label_14 = new JLabel("14", SwingConstants.CENTER);
		panel_1.add(label_14);

		profilPanel = new JPanel();
		profilPanel.setBorder(new EtchedBorder(EtchedBorder.LOWERED, null, null));
		leftPanel.add(profilPanel);
		profilPanel.setLayout(new BorderLayout(0, 0));

		toolBar = new JToolBar();
		toolBar.setLayout(new GridLayout(0, 5));
		toolBar.setFloatable(false);
		profilPanel.add(toolBar, BorderLayout.NORTH);

		lblNewLabel = new JLabel("Profiles");
		toolBar.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 13));

		New = new JButton(new ImageIcon(SwingTest.class.getResource("/new.png")));
		New.setMargin(new Insets(0, 0, 0, 0));
		New.setBorder(null);
		toolBar.add(New);

		btnLoad = new JButton(new ImageIcon(SwingTest.class.getResource("/load.png")));
		btnLoad.setMargin(new Insets(0, 0, 0, 0));
		btnLoad.setBorder(null);
		toolBar.add(btnLoad);

		btnSave = new JButton(new ImageIcon(SwingTest.class.getResource("/save.png")));
		btnSave.setMargin(new Insets(0, 0, 0, 0));
		btnSave.setBorder(null);
		toolBar.add(btnSave);

		button = new JButton(new ImageIcon(SwingTest.class.getResource("/delete.png")));
		button.setMargin(new Insets(0, 0, 0, 0));
		button.setBorder(null);
		toolBar.add(button);

		list = new JList();
		list.setModel(new AbstractListModel() {
			String[]	values	= new String[] { "XBOX (Default)", "PS3 (Default)" };

			@Override
			public int getSize() {
				return values.length;
			}

			@Override
			public Object getElementAt(int index) {
				return values[index];
			}
		});
		list.setVisibleRowCount(4);
		profilPanel.add(list, BorderLayout.CENTER);

		rightpanel = new JPanel();
		frmJpadV.getContentPane().add(rightpanel);
		rightpanel.setLayout(new BorderLayout(0, 0));

		scrollPane = new JScrollPane();
		rightpanel.add(scrollPane);

		table = new JTable();
		table.setModel(new DefaultTableModel(new Object[][] { { "Button 1", null }, { null, null },
				{ null, null }, { null, null }, { null, null }, { null, null }, { null, null },
				{ null, null }, { null, null }, { null, null }, { null, null }, { null, null },
				{ null, null }, { null, null }, { null, null }, { null, null }, { null, null },
				{ null, null }, { null, null }, { null, null }, { null, null }, { null, null },
				{ null, null }, { null, null }, { null, null }, }, new String[] { "Gamepad",
				"Simulation" }) {
			boolean[]	columnEditables	= new boolean[] { false, true };

			@Override
			public boolean isCellEditable(int row, int column) {
				return columnEditables[column];
			}
		});
		scrollPane.setViewportView(table);

		menuBar = new JMenuBar();
		frmJpadV.setJMenuBar(menuBar);

		mnFile = new JMenu("File");
		menuBar.add(mnFile);

		mntmLoadProfile = new JMenuItem("Load Profile");
		mntmLoadProfile.setIcon(new ImageIcon(SwingTest.class.getResource("/load.png")));
		mnFile.add(mntmLoadProfile);

		mntmNewMenuItem = new JMenuItem("Save Profile");
		mntmNewMenuItem.setIcon(new ImageIcon(SwingTest.class.getResource("/save.png")));
		mnFile.add(mntmNewMenuItem);

		mnInfo = new JMenu("Info");
		menuBar.add(mnInfo);

		mntmAbout = new JMenuItem("About");
		mnInfo.add(mntmAbout);
	}
}
