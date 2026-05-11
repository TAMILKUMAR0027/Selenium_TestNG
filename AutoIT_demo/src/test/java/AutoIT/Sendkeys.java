package AutoIT;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Sendkeys {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://demoqa.com/upload-download");
		driver.findElement(By.xpath("//input[@id='uploadFile']")).sendKeys("E:\\8. Online Movie Ticket Booking.pdf");
		System.out.println(driver.findElement(By.xpath("//p[@id='uploadedFilePath']")).getText());
		driver.quit();
	}

}
