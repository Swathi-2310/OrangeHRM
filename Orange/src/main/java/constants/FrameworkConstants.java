package constants;

public final class FrameworkConstants {
	
	private FrameworkConstants() {}

	private static final String RESOURCEPATH = System.getProperty("user.dir")+"/src/test/resources";
	private static final String CONFIGFILEPATH = RESOURCEPATH+"/config/config.properties";
	private static final String EXCELPATH = RESOURCEPATH+"/data/loginData.xlsx";
	private static final String EXTENTREPORTPATH = RESOURCEPATH+"/report.html";
	private static final int EXPLICITWAIT = 10;

	public static String getConfigFilePath() {
		return CONFIGFILEPATH;
	}
	
	public static int getExplicitWait() {
		return EXPLICITWAIT;
	}
	
	public static String getExcelFilePath() {
		return EXCELPATH;
	}
	public static String getExtentReportPath() {
		return EXTENTREPORTPATH;
	}
}
