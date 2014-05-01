package de.timweb.jpad.listener;

import java.awt.AWTException;
import java.awt.MouseInfo;
import java.awt.Point;
import java.awt.Robot;
import java.awt.event.InputEvent;
import java.awt.event.KeyEvent;

import de.timweb.jpad.core.Gamepad;
import de.timweb.jpad.core.GamepadListener;
import de.timweb.jpad.core.Gamepad.Button;
import de.timweb.jpad.core.Gamepad.Stick;

public class RobotListener implements GamepadListener {

	private boolean	mouseLeftDown	= false;
	private boolean	mouseRightDown	= false;

	private double	moveX			= 0;
	private double	moveY			= 0;

	private Robot	robot;

	public RobotListener() {
		try {
			robot = new Robot();
		} catch (AWTException e) {
			throw new RuntimeException(e);
		}
	}


	@Override
	public void stickChanged(final Stick stick) {
	}

	@Override
	public void buttonPressed(final Button button) {
	}


	@Override
	public void tick(final Gamepad gamepad, final double delta) {
		moveMouse(gamepad, delta);
		clickMouse(gamepad);
		wasd(gamepad);
	}


	private void wasd(final Gamepad gamepad) {
		float x = gamepad.getStickLeft().getValueX();
		float y = gamepad.getStickLeft().getValueY();

		if (x < -0.5) {
			robot.keyPress(KeyEvent.VK_A);
		} else if (x > 0.5) {
			robot.keyPress(KeyEvent.VK_D);
		} else {
			robot.keyRelease(KeyEvent.VK_A);
			robot.keyRelease(KeyEvent.VK_D);
		}
		if (y < -0.5) {
			robot.keyPress(KeyEvent.VK_W);
		} else if (y > 0.5) {
			robot.keyPress(KeyEvent.VK_S);
		} else {
			robot.keyRelease(KeyEvent.VK_W);
			robot.keyRelease(KeyEvent.VK_S);
		}
	}


	private void clickMouse(final Gamepad gamepad) {
		if (gamepad.isPressed(5) && !mouseLeftDown) {// R1 = left click
			robot.mousePress(InputEvent.BUTTON1_DOWN_MASK);
			mouseLeftDown = true;
			System.out.println("Left Mouse Clicked");
		}
		if (!gamepad.isPressed(5) && mouseLeftDown) {
			robot.mouseRelease(InputEvent.BUTTON1_DOWN_MASK);
			mouseLeftDown = false;
			System.out.println("Left Mouse Released");
		}
	}


	private void moveMouse(final Gamepad gamepad, final double delta) {
		final int MAX_SPEED = 1800;

		Point mouse = MouseInfo.getPointerInfo().getLocation();

		float x = gamepad.getStickRight().getValueX();
		float y = gamepad.getStickRight().getValueY();

		if (Math.abs(x) > 0.25) {
			moveX += (delta * x * x * x * x * x * MAX_SPEED);
		}
		if (Math.abs(y) > 0.25) {
			moveY += (delta * y * y * y * y * y * MAX_SPEED);
		}

		if (Math.abs(moveX) > 1 || Math.abs(moveY) > 1) {


			System.out.println((int) (mouse.x + moveX) + " : " + (int) (mouse.y + moveY));
			robot.mouseMove((int) (mouse.x + moveX), (int) (mouse.y + moveY));

			if (Math.abs(moveX) > 1)
				moveX = 0;
			if (Math.abs(moveY) > 1)
				moveY = 0;
		}
	}
}
