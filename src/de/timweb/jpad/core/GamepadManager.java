package de.timweb.jpad.core;

import java.util.ArrayList;
import java.util.List;

import org.lwjgl.LWJGLException;
import org.lwjgl.input.Controller;
import org.lwjgl.input.Controllers;

public class GamepadManager {
	private static boolean					isInit		= false;
	private static String					gamepadName;

	private static Gamepad					gamepad;
	private static List<GamepadListener>	listeners	= new ArrayList<>();


	private static void checkInit() {
		if (isInit)
			return;

		try {
			Controllers.create();
			isInit = true;
		} catch (LWJGLException e) {
			throw new RuntimeException(e);
		}
	}

	public static void listController() {
		checkInit();
		int controllerCount = Controllers.getControllerCount();
		System.out.println("Found " + controllerCount + " controller");
		for (int i = 0; i < controllerCount; i++) {
			System.out.println("Found: " + Controllers.getController(i).getName());
		}
	}

	public static void start() {
		checkInit();

		if (gamepadName != null)
			gamepad = new Gamepad(gamepadName);
		else {
			gamepad = new Gamepad();
		}
		new ListenerThread().start();
	}

	private static class ListenerThread extends Thread {
		public static final int	SLEEP	= 25;

		@Override
		public void run() {
			System.out.println("starting ListenerThread");

			// TODO exact delta time
			while (true) {
				Controllers.poll();

				for (int i = 0; i < Controllers.getControllerCount(); i++) {
					Controller controller = Controllers.getController(i);

					if (controller.getName().toLowerCase().contains(gamepadName.toLowerCase())) {
						updateValues(controller);
					}
				}

				// call the listeners
				for (GamepadListener listener : listeners) {
					listener.tick(gamepad, SLEEP / 1000.);
				}

				try {
					Thread.sleep(SLEEP);
				} catch (InterruptedException e) {
				}
			}
		}

		private void updateValues(final Controller controller) {
			gamepad.update(controller);
		}
	}

	public static void addListener(final GamepadListener listener) {
		listeners.add(listener);
	}

	public static void setTargetGamepad(final String gamepadName) {
		GamepadManager.gamepadName = gamepadName;
	}
}
