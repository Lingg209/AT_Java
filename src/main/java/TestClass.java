import io.github.bonigarcia.wdm.WebDriverManager;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.Assert;
import org.testng.annotations.*;
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
        chromeDriver.get("https://www.swim.com/");
        sleep(6000);
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

