package de.timweb.jpad.listener;

import de.timweb.jpad.core.Gamepad;
import de.timweb.jpad.core.GamepadListener;
import de.timweb.jpad.core.Gamepad.Button;
import de.timweb.jpad.core.Gamepad.Stick;

public class DummyListener implements GamepadListener {

	@Override
	public void stickChanged(final Stick stick) {
	}

	@Override
	public void buttonPressed(final Button button) {
	}

	@Override
	public void tick(final Gamepad gamepad, final double delta) {
		System.out.println(gamepad);
	}

}
