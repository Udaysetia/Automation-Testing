package Project1;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Internet {
	public static String h1ElementText;
	public static Boolean h1Present;
	public static Boolean h2Present;
	public static String h2ElementText;
	public static String h3ElementText;
	public static Boolean h3Present;
	WebDriver driver;
	@BeforeTest
    public void setup() {

	//creating a setup for application open and maximize
	 System.setProperty("webdriver.edge.driver",
             "C:\\Users\\Trainee390\\Downloads\\edgedriver_win64\\msedgedriver.exe");
     driver = new EdgeDriver();
     driver.manage().window().maximize();
     driver.get("http://the-internet.herokuapp.com/");
     driver.manage().timeouts().implicitlyWait(5000, TimeUnit.MILLISECONDS);
	}
	 @Test
	    public void TestEdge() throws Exception {
		 
		 //checking up the h1 tag
     String t1 = driver.findElement(By.xpath("//h1")).getAttribute("tagName");
	 System.out.println(t1);
	 h1ElementText = driver.findElement(By.tagName("h1")).getText();
	 System.out.println(h1ElementText);
	 if(h1ElementText.contains("Welcome to the-internet")) {
		 h1Present = true;
	 }
	 else {
		 h1Present = false;
	 }
	 //checking up the h2 tag
	 String t2 = driver.findElement(By.xpath("//h2")).getAttribute("tagName");
	 System.out.println(t2);
	 h2ElementText = driver.findElement(By.tagName("h2")).getText();
	 System.out.println(h2ElementText);
	 if(h2ElementText.contains("Available Examples")) {
		 h2Present = true;
	 }
	 else {
		 h2Present = false;
	 }
	 //checking up the h3 tag
	driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[1]/a")).click();
	 String t3 = driver.findElement(By.xpath("//h3")).getAttribute("tagName");
	 System.out.println(t3);
	 h3ElementText = driver.findElement(By.tagName("h3")).getText();
	 System.out.println(h3ElementText);
	 if(h3ElementText.contains("A/B Test Variation 1")) {
		 h3Present = true;
	 }
	 else {
		 h3Present = false;
	 }
	
	driver.navigate().back();
	//testing the removing and adding element
	driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[2]/a")).click();
	System.out.println("If you want to add element");
	driver.findElement(By.xpath("//*[@id=\"content\"]/div/button")).click();
	driver.findElement(By.xpath("//*[@id=\"content\"]/div/button")).click();
	driver.findElement(By.xpath("//*[@id=\"content\"]/div/button")).click();	
	System.out.println("If you want to delete the element");
	driver.findElement(By.xpath("//*[@id=\"elements\"]/button")).click();
	
	driver.navigate().back();
	
	//checking the checkbox functionality  
	driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[5]/a")).click();
	
	
	String t5 = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/div/div[2]")).getText();
	System.out.println(t5);
	driver.navigate().back();
	driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[6]/a")).click();
	driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[1]")).click();
	boolean isCheckboxSelected = driver.findElement(By.xpath("//*[@id=\"checkboxes\"]/input[1]")).isSelected();
	if(isCheckboxSelected) {
		System.out.println("Checkbox selected");
	}
	else {
		System.out.println("Not selected");
		
	}
	
	driver.navigate().back();
	//checking the dropdawn and dragdown
	driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[10]/a")).click();
	
	Actions act = new Actions(driver);
	act.dragAndDrop(driver.findElement(By.xpath("//*[@id=\"column-a\"]")), driver.findElement(By.xpath("//*[@id=\"column-b\"]")));
	
	driver.navigate().back();
	driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[11]/a")).click();
	WebElement dropDawn = driver.findElement(By.id("dropdown"));
	Select down = new Select(dropDawn);
	down.selectByIndex(1);

	
	driver.navigate().back();
	//retriving the table data
	driver.findElement(By.xpath("//*[@id=\"content\"]/ul/li[14]/a")).click();
	driver.findElement(By.xpath("//*[@id=\"content\"]/div/a[1]")).click();
	driver.findElement(By.xpath("//*[@id=\"start\"]/button")).click();
	
	String x1 = driver.findElement(By.xpath("//*[@id=\"finish\"]/h4")).getText();
	System.out.println(x1);
	//checking the form functionality
	driver.navigate().to("http://the-internet.herokuapp.com/login");;
	
	driver.findElement(By.id("username")).sendKeys("tomsmith");
	driver.findElement(By.id("password")).sendKeys("SuperSecretPassword!");
	driver.findElement(By.xpath("//*[@id=\"login\"]/button/i")).click();
	String x2 = driver.findElement(By.id("flash")).getText();
	System.out.println(x2);
	//checking the slider function
	driver.navigate().to("http://the-internet.herokuapp.com/horizontal_slider");
	WebElement slider = driver.findElement(By.xpath("//*[@id=\"content\"]/div/div/input"));
	String valueBefore = driver.findElement(By.id("range")).getText();
	Actions action = new Actions (driver);
	action.dragAndDropBy(slider, 204 , 167).perform();
	System.out.println(valueBefore);
	
	String valueAfter = driver.findElement(By.id("range")).getText();
	System.out.println(valueAfter);
	
}
}
