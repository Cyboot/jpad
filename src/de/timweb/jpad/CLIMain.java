package de.timweb.jpad;

import de.timweb.jpad.core.GamepadManager;
import de.timweb.jpad.listener.RobotListener;

public class CLIMain {
	public static void main(final String[] args) {
		GamepadManager.listController();
		GamepadManager.setTargetGamepad("ps3");
		GamepadManager.addListener(new RobotListener());
		// GamepadManager.addListener(new DummyListener());
		GamepadManager.start();
	}
}
