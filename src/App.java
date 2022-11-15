import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class App {
    private static WebDriver webDriver;

    public static void setUp() {
        System.setProperty("webdriver.chrome.driver", "lib/chromedriver.exe");
        webDriver = new ChromeDriver();
    }

    public static boolean validateTitle(String expectedTitle) {
        String actualTitle = webDriver.getTitle();
        if (actualTitle.contentEquals(expectedTitle)) {
            return true;
        } else {
            return false;
        }
    }

    public static void headingText() {
        webDriver.get("https://phptravels.com/demo/");
        webDriver.manage().window().maximize();
        String expectedHeading = "APPLICATION TEST DRIVE";

        // Storing the text of the heading in a string
        String heading = webDriver.findElement(By.xpath("//div[@class='text']//h2")).getText();
        if (expectedHeading.equalsIgnoreCase(heading))
            System.out.println("The expected heading is same as actual heading --- " + heading);
        else
            System.out.println("The expected heading doesn't match the actual heading --- " + heading);
    }

    public static void main(String[] args) throws Exception {
        System.out.println("Hello, World!");
        // declaration and instantiation of objects/variables
        // System.setProperty("webdriver.gecko.driver","C:\\geckodriver.exe");
        System.setProperty("webdriver.chrome.driver", "lib/chromedriver.exe");

        WebDriver driver = new ChromeDriver();
        // WebDriver driver = new FirefoxDriver();
        // comment the above 2 lines and uncomment below 2 lines to use Chrome
        // System.setProperty("webdriver.chrome.driver","G:\\chromedriver.exe");
        // WebDriver driver = new ChromeDriver();

        String baseUrl = "https://tbd.edu.vn/";
        String expectedTitle = "Đại Học Thái Bình Dương - TBD";
        String actualTitle = "";

        // launch Fire fox and direct it to the Base URL
        driver.get(baseUrl);

        // get the actual value of the title
        actualTitle = driver.getTitle();
        /*
         * compare the actual title of the page with the expected one and print
         * the result as "Passed" or "Failed"
         */
        if (actualTitle.contentEquals(expectedTitle)) {
            System.out.println("Test Passed!");
        } else {
            System.out.println("Test Failed");
        }
        // Bottle for element
        // Get element with tag name 'div'
        WebElement element = driver.findElement(By.tagName("div"));
        // System.out.println("Boong" + element.getText());
        // Get all the elements available with tag name 'p'
        List<WebElement> elements = element.findElements(By.tagName("p"));
        for (WebElement e : elements) {
            System.out.println("Bottle" + e.getText());
        }

        // Bottle end for element

        // Bottle button click
        WebElement m = driver.findElement(By.className("alink"));
        m.click();
        String expectedAboutTitle = "Về TBD - Đại Học Thái Bình Dương - TBD";
        String actualAboutTitle = "";
        actualAboutTitle = driver.getTitle();
        if (actualAboutTitle.contentEquals(expectedAboutTitle)) {
            System.out.println("Test Button About Passed!");
        } else {
            System.out.println("Test Button About Failed");
        }
        // Bottle end click
        // Bottle test paragraph content
        // setUp();
        // headingText();

        // close Fire fox
        driver.close();
        DomainTest.name();
        CheckTBD.CheckTitleTBD();
        DaotaoDTuan.CheckDaotaoTBD();
    }

}
