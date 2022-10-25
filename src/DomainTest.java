import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DomainTest {
    private static WebDriver webDriver;
    public static void setUp(){
        System.setProperty("webdriver.chrome.driver","lib/chromedriver.exe");
        webDriver = new ChromeDriver();
    }
    public static boolean validateTitle(String expectedTitle){
		String actualTitle = webDriver.getTitle();
		if(actualTitle.contentEquals(expectedTitle)){
			return true;
		}
		else{
			return false;
		}
	}
    public static void name() {
        System.out.println("Good luck");

    }
}
