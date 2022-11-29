import java.time.Duration;



import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;

public class DomainTest {
	private static WebDriver webDriver;

	public static void setUp() {
		// System.setProperty("webdriver.chrome.driver", "lib/chromedriver.exe");
		// webDriver = new ChromeDriver();
		// Implementation of SetProperty Method
		System.setProperty("webdriver.edge.driver","lib/msedgedriver.exe");
		// Creating new Object driver Of Webdriver
		webDriver = new EdgeDriver();
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
		//String baseUrl = "https://tbd.edu.vn/tra-cuu-ho-so/";
		String baseUrl = "http://daotao.tbd.edu.vn/";	
		webDriver.get(baseUrl);
		webDriver.manage().window().maximize();
		
		if (validateTitle("Tra cứu hồ sơ - Đại học Thái Bình Dương"))
			System.out.println("The expected heading is same as actual heading --- Pass");
		else
			System.out.println("The expected heading doesn't match the actual heading --- Fail");
	}
	public static void searchProfile()
	{
		//String baseUrl = "https://tbd.edu.vn/tra-cuu-ho-so/";
		String baseUrl = "http://daotao.tbd.edu.vn/";					
        					
        webDriver.get(baseUrl);	
		// Get the WebElement corresponding to the search field	
        WebElement userName = webDriver.findElement(By.name("LoginControl1$txtusername"));							
		userName.sendKeys("225282478");					
        System.out.println("Text Field Set");					
         
        // Deleting values in the text box		
        //search.clear();			
        //System.out.println("Text Field Cleared");					

        // Find the submit button		
        WebElement loginButton = webDriver.findElement(By.name("LoginControl1$btnDangNhap"));							
		// Using click method to submit form		
        loginButton.click();			
        System.out.println("Login Done with Click");
		//WebElement alertError = webDriver.findElement(By.name("LoginControl1_lblThong_bao"));					
        WebElement alertError = new WebDriverWait(webDriver, Duration.ofSeconds(3))
          .until(webDriver -> webDriver.findElement(By.id("LoginControl1_lblThong_bao")));
		  System.out.println(alertError.getText());
		if(alertError.getText().contentEquals("Tên đăng nhập và mật khẩu không hợp lệ, bạn nhập lại !"))
		   System.out.println("Test case Login 2 pass");
		//<span id="LoginControl1_lblThong_bao" class="alert alert-danger col-sm-12">Tên đăng nhập và mật khẩu không hợp lệ, bạn nhập lại !</span>		
        
				
        //System.out.println("Login Done with Submit");		
	}
	public static void name() {
		System.out.println("Good luck");
		setUp();
		headingText();
		searchProfile();
	}
}
