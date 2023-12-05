package Reportes;
import com.aventstack.extentreports.ExtentReports;

public class ExtentFactory {

    public static ExtentReports getInstance() {
        ExtentReports extent = new ExtentReports();
        extent.setSystemInfo("Evironment", "Production");
        extent.setSystemInfo("Selenium Version", "4.15.0");
        extent.setSystemInfo("Browser", "Chrome");
        extent.setSystemInfo("Automatizador", "Julio Born");
        return extent;
    }
}
