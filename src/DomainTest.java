import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
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
		String baseUrl = "https://tbd.edu.vn/tra-cuu-ho-so/";	
		webDriver.get(baseUrl);
		webDriver.manage().window().maximize();
		
		if (validateTitle("Tra cứu hồ sơ - Đại học Thái Bình Dương"))
			System.out.println("The expected heading is same as actual heading --- Pass");
		else
			System.out.println("The expected heading doesn't match the actual heading --- Fail");
	}
	public static void searchProfile()
	{
		String baseUrl = "https://tbd.edu.vn/tra-cuu-ho-so/";					
        webDriver.get(baseUrl);	
		// Get the WebElement corresponding to the search field	
        WebElement search = webDriver.findElement(By.name("keyTBD"));							
		
        search.sendKeys("225282478");					
        System.out.println("Text Field Set");					
         
        // Deleting values in the text box		
        //search.clear();			
        //System.out.println("Text Field Cleared");					

        // Find the submit button		
        WebElement searchButton = webDriver.findElement(By.xpath("/html/body/div[2]/div[1]/div[2]/div[2]/form/button"));							
		// Using click method to submit form		
        searchButton.click();			
        System.out.println("Login Done with Click");					
        		
        
				
        //System.out.println("Login Done with Submit");		
	}
	public static void name() {
		System.out.println("Good luck");
		setUp();
		headingText();
		searchProfile();
	}
}
