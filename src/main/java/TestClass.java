import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;

import static org.testng.Assert.assertEquals;


public class TestClass {
    ChromeDriver chromeDriver;
    @BeforeMethod
   public void Setup(){
       System.out.println("Setup Method");
        WebDriverManager.chromedriver().setup();
        chromeDriver = new ChromeDriver();
   }

    @Test
    public void Run(){
        //body Test scripts
        chromeDriver.get("https://auto.fresher.dev/lessons/lession7/index.html");

        WebElement button;
        button = chromeDriver.findElement(By.className("btn-success"));

        //findElement: when condition is just only
        Actions action = new Actions(chromeDriver);

        //move to element
        action.moveToElement(button);

        //right click
        action.contextClick(button).build().perform();

        //left click
        action.click(button).build().perform();


        //double click
        action.doubleClick(button).build().perform();

        //Drag drop
        action.dragAndDrop(button, button).build().perform();

        //send key
        WebElement textBox;
        textBox = chromeDriver.findElement(By.id("txtInput1"));
        textBox.clear();
        action.sendKeys(textBox, "abc").build().perform();



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

