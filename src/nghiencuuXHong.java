import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;

public class nghiencuuXHong {

    public static void nghiencuuTBD() {
        System.setProperty("webdriver.chrome.driver", "lib/chromedriver.exe");
        WebDriver webDriver = new ChromeDriver();

        String baseUrl = "https://tbd.edu.vn/";
        String expectedTitle = "Nghiên cứu";

        webDriver.get(baseUrl);

        WebElement htmlBtn = webDriver.findElement(By.xpath("//button[@href='#mobileMenuHV']"));
        htmlBtn.click();

        WebElement htmlLink = webDriver.findElement(By.xpath("//*[@id='mobileMenuHV']/div[2]/div[4]/a"));
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
