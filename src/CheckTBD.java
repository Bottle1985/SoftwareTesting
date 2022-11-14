import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;

public class CheckTBD {

    public static void CheckTitleTBD() {
        System.setProperty("webdriver.chrome.driver", "lib/chromedriver.exe");
        WebDriver webDriver = new ChromeDriver();

        String baseUrl = "https://tbd.edu.vn/";
        String expectedTitle = "Về TBD";

        webDriver.get(baseUrl);

        WebElement htmlLink = webDriver.findElement(By.xpath("//a[@href='https://tbd.edu.vn/ve-tbd/']"));
        htmlLink.click();

        WebElement linkTitle = webDriver.findElement(By.className("titleMainPage"));

        String actualTitle = linkTitle.getText();

        System.out.println(actualTitle);

        if (actualTitle.contentEquals(expectedTitle)) {
            System.out.println("Test Link Passed!");
        } else {
            System.out.println("Test Link Failed");
        }

        webDriver.close();
    }
}
