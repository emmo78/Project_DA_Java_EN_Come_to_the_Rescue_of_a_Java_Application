package com.hemebiotech.control;

/**
 * Controller
 * 
 * This is a singleton, only one instance possible.
 * 
 * @author olivi
 *
 */

public final class AnalyticsController {
	/**
	 * instance is private to exercise access control by get ()
	 */
	private static AnalyticsController instance;

	private AnalyticsController() {
	}

	/**
	 * Getter Static to get it without instantiating it
	 * @return the only one AnalyticsController()
	 */
	public static AnalyticsController getInstance() {
		if (instance == null) {
			instance = new AnalyticsController();
		}
		return instance;
	}
	
	public void run() {}
	
}