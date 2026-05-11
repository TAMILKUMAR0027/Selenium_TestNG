package AutoIT;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;

public class downloadFile {

	public static void main(String[] args) {

		String downloadFilePath = System.getProperty("user.dir") + File.separator + "downloads";

		EdgeOptions opt = new EdgeOptions();

		Map<String, Object> prefs = new HashMap<>();

		prefs.put("download.default_directory", downloadFilePath);
		prefs.put("download.prompt_for_download", false);
		
		opt.setExperimentalOption("prefs", prefs);

		WebDriver driver = new EdgeDriver(opt);

		driver.manage().window().maximize();

		driver.get("https://demoqa.com/upload-download");

		driver.findElement(By.id("downloadButton")).click();

		System.out.println("File Downloaded");

		driver.quit();
	}
}