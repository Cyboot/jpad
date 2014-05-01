package de.timweb.jpad.core;

public interface GamepadListener {

	public void stickChanged(Gamepad.Stick stick);

	public void buttonPressed(Gamepad.Button button);

	public void tick(Gamepad gamepad, double delta);
}
