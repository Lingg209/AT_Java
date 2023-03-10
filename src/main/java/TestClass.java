import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptException;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.*;

import java.util.List;

import static org.testng.Assert.assertEquals;


public class TestClass {
    ChromeDriver chromeDriver;
    String input = "q&a123.456";
    String expect = "123.456";

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
        sleep(3000);

        WebElement button = chromeDriver.findElement(By.id("btnExample1"));
        button.click();
        WebElement lbStatusButton = chromeDriver.findElement(By.id("lbStatusButton"));
        String lbStatusButtonValue = lbStatusButton.getText();
        Assert.assertEquals(lbStatusButtonValue,"Click on Button 1");

        WebElement textInput = chromeDriver.findElement(By.id("txtInput1"));
        String textInputValue = textInput.getAttribute("value");
        Assert.assertEquals(textInputValue,"Default value of input");
        textInput.clear();
        textInput.sendKeys("New value of input");
        String textInputNewValue = textInput.getAttribute("value");
        Assert.assertEquals(textInputNewValue,"New value of input");

        /*WebElement button;
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
*/

    }

    @Test
    public void Run2_disableField()
    {
        chromeDriver.get("https://auto.fresher.dev/lessons/lession7/index.html");
        sleep(3000);

        WebElement disabled = chromeDriver.findElement(By.id("txtInput2"));

        removeAttribute(disabled,"disabled");
        disabled.clear();
        disabled.sendKeys("New value of input disable");
        setAttribute(disabled,"disabled");

        String disableValue = disabled.getAttribute("value");
        Assert.assertEquals(disableValue,"New value of input disable");
    }

    @Test
    public void Run3_number(){
        chromeDriver.get("https://auto.fresher.dev/lessons/lession7/index.html");
        sleep(3000);

        WebElement number = chromeDriver.findElement(By.id("txtInput3"));
        number.clear();
        number.sendKeys(input);
        sleep(300);
        input = number.getAttribute("value");
        Assert.assertEquals(input,expect);

    }
    public void removeAttribute( WebElement element ,String attr){
        ((JavascriptExecutor) chromeDriver).executeScript("arguments[0].removeAttribute('"+ attr +"')",element);
    }
    public void setAttribute( WebElement element, String attr){
        ((JavascriptExecutor) chromeDriver).executeScript("arguments[0].setAttribute('"+ attr +"','')",element);
    }

   @AfterMethod
   public void CleanUp() {
       System.out.println("After Method");
       //Cleanup Data
      chromeDriver.quit();
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

