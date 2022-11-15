import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.WebElement;

public class DaotaoDTuan {

    public static void CheckDaotaoTBD() {
        System.setProperty("webdriver.chrome.driver", "lib/chromedriver.exe");
        WebDriver webDriver = new ChromeDriver();

        String baseUrl = "https://tbd.edu.vn/";
        String expectedTitle = "Đào tạo";

        webDriver.get(baseUrl);

        WebElement htmlLink = webDriver.findElement(By.xpath("//a[@href='https://tbd.edu.vn/dao-tao/']"));
        htmlLink.click();

        WebElement linkTitle = webDriver.findElement(By.className("titleMai3nPage"));

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
