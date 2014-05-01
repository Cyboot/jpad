package de.timweb.jpad;

import de.timweb.jpad.core.GamepadManager;
import de.timweb.jpad.listener.DummyListener;

public class CLIMain {
	public static void main(final String[] args) {
		GamepadManager.listController();
		GamepadManager.setTargetGamepad("xbox");
		// GamepadManager.addListener(new RobotListener());
		GamepadManager.addListener(new DummyListener());
		GamepadManager.start();
	}
}
