// RumbleDemo.java

import javax.swing.JOptionPane;

import ch.aplu.xboxcontroller.XboxController;
import ch.aplu.xboxcontroller.XboxControllerAdapter;

public class RumbleDemo {
	private XboxController	xc;
	private int				leftVibrate		= 0;
	private int				rightVibrate	= 0;

	public RumbleDemo() {
		xc = new XboxController("dll/xboxcontroller64", 1, 50, 50);

		if (!xc.isConnected()) {
			JOptionPane.showMessageDialog(null, "Xbox controller not connected.", "Fatal error",
					JOptionPane.ERROR_MESSAGE);
			xc.release();
			return;
		}

		xc.addXboxControllerListener(new XboxControllerAdapter() {
			@Override
			public void leftTrigger(final double value) {
				System.out.println("left: " + value);
				leftVibrate = (int) (65535 * value * value);
				xc.vibrate(leftVibrate, rightVibrate);
			}

			@Override
			public void rightTrigger(final double value) {
				System.out.println("right: " + value);
				rightVibrate = (int) (65535 * value * value);
				xc.vibrate(leftVibrate, rightVibrate);
			}
		});

		JOptionPane.showMessageDialog(null, "Xbox controller connected.\n"
				+ "Press left or right trigger, Ok to quit.",
				"XboxControllerRumble V1.0 (www.aplu.ch)", JOptionPane.PLAIN_MESSAGE);

		xc.release();
		System.exit(0);
	}

	public static void main(final String[] args) {
		new RumbleDemo();
	}
}
