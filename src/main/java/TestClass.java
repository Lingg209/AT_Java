import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;

import static org.testng.Assert.assertEquals;


public class TestClass {
    ChromeDriver chromeDriver;
    @BeforeMethod
   public void Setup(){
       System.out.println("Before Method");
        // Setup data

        WebDriverManager.chromedriver().setup();
        chromeDriver = new ChromeDriver();
   }

    @Test
    public void Run(){
        //body Test scripts
        chromeDriver.get("https://auto.fresher.dev/lessons/lession7/index.html");
        WebElement loginButton;
        loginButton = chromeDriver.findElement(By.className("btn-success"));
        //findElement: when condition is just only
        List<WebElement> buttons = chromeDriver.findElements(By.className("btn-success"));
        for(int i = 0; i < buttons.size(); i++)
        {
            buttons.get(i).click();
            sleep(3000);
        }
        //findElements: when we want to get many element has same condition filter
    }


   @AfterMethod
   public void CleanUp() {
       System.out.println("After Method");
       //Cleanup Data
      // chromeDriver.quit();
   }

   private void sleep(int time){
        try{
            Thread.sleep(time);
            }
        catch(Exception ex){
            System.out.print(ex.getMessage());
        }
   }
}

