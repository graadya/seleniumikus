package steps;

import io.cucumber.java.After;
import io.cucumber.java.Before;
import io.cucumber.java.ParameterType;
import io.cucumber.java.ru.И;
import io.cucumber.java.ru.Пусть;
import io.cucumber.java.ru.Тогда;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import java.util.List;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class Steps {

  protected WebDriver driver;

  @Before
  public void setAll() {
    System.setProperty("webdriver.chrome.driver", "C:\\chromedrive\\chromedriver.exe");
    driver = new ChromeDriver();
  }


  @Пусть("открыт ресурс на авито")
  public void openWebsite() {
    driver.navigate().to("https://www.avito.ru");
  }

  @ParameterType(".*")
  public TypeOfProduct product(String product) {
    System.out.println(product);
    return TypeOfProduct.getByValue(product);
  }

  @И("в выпадающем списке категорий выбрана {product}")
  public void listOfCategories(TypeOfProduct product) {
    Select productSelector = new Select(driver.findElement(By.xpath("//select[@name='category_id']")));
    System.out.println(product.value);
    productSelector.selectByVisibleText(product.getValue());
    System.out.println(product);
  }

  @И("в поле поиска введено значение {word}")
  public void typeOfProduct(String product) {
    driver.findElement(By.xpath("//input[@id='search']")).sendKeys(product);
  }

  @Тогда("кликнуть по выпадающему списку региона")
  public void listOfCities() {
    driver.findElement(By.xpath("//div[@class='main-text-2PaZG']")).click();
  }

  @Тогда("в поле регион введено значение {word}")
  public void inputCity(String city) {
    driver.findElement(By.xpath("//input[@data-marker='popup-location/region/input']")).sendKeys(city);
  }

  @И("нажата кнопка показать объявления")
  public void showSome() {
//    driver.manage().timeouts().implicitlyWait(2, TimeUnit.SECONDS);
    driver.findElement(By.xpath("//button[@data-marker='popup-location/save-button']")).click();
  }

  @Тогда("открылась страница результаты по запросу {word}")
  public void openPage(String text) {
    WebElement search = driver.findElement(By.xpath("//*"));
    if (search != null && search.equals(text)) {
      System.out.println("Открыта другая страница");
      driver.close();
    }
  }

  @И("активирован чекбокс только с фотографией")
  public void activeCheckBox() {
//    driver.manage().timeouts().implicitlyWait(1, TimeUnit.SECONDS);
    WebElement checkbox = driver.findElement(By.xpath("//label[2]/span"));
    checkbox.click();
  }

  @И("в выпадающем списке сортировка выбрано значение {word}")
  public void chosenExpensive(String price) {
    Select sort = new Select(driver.findElement(By.xpath("//div[2]/select")));
    sort.selectByVisibleText(price);
  }

  @И("в консоль выведено значение названия и цены {int} первых товаров")
  public void viewOfGoodsInconsole(int num) {
//
    WebElement listOfPrinters = driver.findElement(By.xpath("//div[@data-marker='catalog-serp']"));
    List<WebElement> results = listOfPrinters.findElements(By.cssSelector("div.iva-item-body-NPl6W"));
    for (int i = 0; i < num; i++) {
      System.out.println(results.get(i).findElement(By.cssSelector("span.price-text-1HrJ_")).getText() + " " + results.get(i).findElement(By.cssSelector("span.title-root-395AQ")).getText());
    }
  }

  @After
  public void Stop() {
    driver.close();
  }

}
