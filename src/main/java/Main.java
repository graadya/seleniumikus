import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.concurrent.TimeUnit;

public class Main {
  public static void main(String[] args) {
    System.setProperty("webdriver.chrome.driver", "C:\\chromedrive\\chromedriver.exe");
    WebDriver driver = new ChromeDriver();
    driver.manage().window().maximize();
    driver.manage().timeouts().implicitlyWait(10, TimeUnit.SECONDS);
    driver.manage().timeouts().pageLoadTimeout(10, TimeUnit.SECONDS);
    driver.navigate().to("https://www.avito.ru/");
    Select productSelector = new Select(driver.findElement(By.xpath("//select[@name='category_id']")));
    productSelector.selectByValue("99");
   // driver.manage().timeouts().implicitlyWait(5, TimeUnit.SECONDS);
    driver.findElement(By.xpath("//input[@id='search']")).sendKeys("Принтер");
    driver.findElement(By.xpath("//div[@class='main-text-2PaZG']")).click();
    driver.findElement(By.xpath("//input[@class=\"suggest-input-3p8yi\"]")).sendKeys("Владивосток");
    WebElement listsOfCityies = (WebElement) driver.findElement(By.xpath("//li[@class=\"suggest-suggest-1wwEm text-text-1PdBw text-size-m-4mxHN\"]"));
    List<WebElement> list = listsOfCityies.findElements(By.xpath("//ul[@class=\"suggest-suggests-bMAdj\"]"));
    for (int i = 0; i < list.size(); i++) {
      if(list.contains("Владивосток")){
        listsOfCityies.click();
      }
    }
    driver.close();

  }
}
