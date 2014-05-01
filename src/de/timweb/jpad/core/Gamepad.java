package de.timweb.jpad.core;

import java.util.Arrays;

import org.lwjgl.input.Controller;

public class Gamepad {
	public static final String	LEFT_STICK	= "Left Stick";
	public static final String	RIGHT_STICK	= "Right Stick";

	private String				name;
	private Stick				stickLeft	= new Stick(LEFT_STICK);
	private Stick				stickRight	= new Stick(RIGHT_STICK);
	private Button[]			buttons;

	public Gamepad() {
		this("DefaultGamepad");
	}

	public Gamepad(final String name) {
		this.name = name;

		buttons = new Button[20];
		for (int i = 0; i < buttons.length; i++) {
			buttons[i] = new Button(i);
		}
	}

	void update(final Controller controller) {
		stickLeft.valueX = controller.getAxisValue(1);
		stickLeft.valueY = controller.getAxisValue(0);
		stickRight.valueX = controller.getAxisValue(3);
		stickRight.valueY = controller.getAxisValue(2);

		for (int i = 0; i < controller.getButtonCount(); i++) {
			buttons[i].name = controller.getButtonName(i);
			buttons[i].value = controller.isButtonPressed(i);
		}
	}

	public boolean isPressed(final int buttonIndex) {
		return buttons[buttonIndex].value;
	}

	public Stick getStickLeft() {
		return stickLeft;
	}

	public Stick getStickRight() {
		return stickRight;
	}

	public String getName() {
		return name;
	}

	@Override
	public String toString() {
		return stickLeft.toString() + ", " + stickRight.toString() + ", " + Arrays.toString(buttons);
	}

	public static class Stick {
		String	name;
		float	valueX;
		float	valueY;

		public Stick(final String name) {
			this.name = name;
		}

		public String getName() {
			return name;
		}

		public float getValueX() {
			return valueX;
		}

		public float getValueY() {
			return valueY;
		}

		@Override
		public String toString() {
			return "[" + name + ", x=" + valueX + ", y=" + valueY + "]";
		}

	}

	public static class Button {
		int		index;
		String	name;
		boolean	value;

		public Button(final int index) {
			this.index = index;
		}

		public int getIndex() {
			return index;
		}

		public String getName() {
			return name;
		}

		public boolean isValue() {
			return value;
		}

		@Override
		public String toString() {
			String x = "-";
			if (value)
				x = "#";

			return "[" + index + "] " + x;
		}
	}

}
