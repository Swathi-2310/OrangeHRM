package reports;

import com.aventstack.extentreports.ExtentTest;

public final class ExtentLogger {

	private ExtentLogger() {
	}

	private static final ThreadLocal<ExtentTest> TEST = new ThreadLocal<>();

	public static void setTest(ExtentTest test) {
		TEST.set(test);
	}

	public static ExtentTest getTest() {
		return TEST.get();
	}

	public static void remove() {
		TEST.remove();
	}

	public static void pass(String message) {
		getTest().pass(message);
	}

	public static void fail(String message) {
		getTest().fail(message);
	}

	public static void info(String message) {
		getTest().info(message);
	}

	public static void skip(String message) {
		getTest().skip(message);
	}
}
