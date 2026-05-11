package AutoIT;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class autoIdDemo {
	public static void main(String[]args) throws IOException, InterruptedException {
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://pdf2doc.com/");
		driver.findElement(By.xpath("//label[@id='uploadBtn']")).click();
		Runtime.getRuntime().exec("C:\\Users\\tamil\\Downloads\\OpenFile.exe");
	    Thread.sleep(10000);
		driver.quit();
	}
}
