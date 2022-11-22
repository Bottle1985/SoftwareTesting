import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DomainTest {
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
		webDriver.get("https://tbd.edu.vn/tra-cuu-ho-so/");
		webDriver.manage().window().maximize();
		
		if (validateTitle("Tra cứu hồ sơ - Đại học Thái Bình Dương"))
			System.out.println("The expected heading is same as actual heading --- Pass");
		else
			System.out.println("The expected heading doesn't match the actual heading --- Fail");
	}
	
	public static void name() {
		System.out.println("Good luck");
		setUp();
		headingText();
	}
}
