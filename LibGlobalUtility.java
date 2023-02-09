package org.libglobal;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

import io.github.bonigarcia.wdm.WebDriverManager;

public class LibGlobalUtility {
	WebDriver driver;
	public void login (String username,String password) {
		WebDriverManager.chromedriver().setup();
		driver= new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(100));
		driver.get("http://adactinhotelapp.com/");
		WebElement txtUserName = driver.findElement(By.id("username"));
		txtUserName.sendKeys(username);
		WebElement txtPassword = driver.findElement(By.id("password"));
		txtPassword.sendKeys(password);
		WebElement btnLogin = driver.findElement(By.id("login"));
		btnLogin.click();
	}
	public void searchHotel(String location,String hotels,String type,String nos,String inDate,String outDate,String roomAdl,String roomchild) {
WebElement ddLocation = driver.findElement(By.id("location"));
Select s= new Select(ddLocation);
s.selectByVisibleText(location);

WebElement hotelSelect = driver.findElement(By.id("hotels"));
Select s0= new Select(hotelSelect);
s0.selectByVisibleText(hotels);

WebElement roomType = driver.findElement(By.id("room_type"));
Select s1= new Select(roomType);
s1.selectByVisibleText(type);

WebElement roomNos = driver.findElement(By.id("room_nos"));
Select s2= new Select(roomNos);
s2.selectByVisibleText(nos);

WebElement checkIn = driver.findElement(By.id("datepick_in"));
checkIn.sendKeys(inDate);

WebElement checkOut = driver.findElement(By.id("datepick_in"));
checkOut.sendKeys(outDate);

WebElement adultRoom = driver.findElement(By.id("adult_room"));
Select s3= new Select(adultRoom);
s3.selectByVisibleText(roomAdl);

WebElement childRoom = driver.findElement(By.id("adult_room"));//3 - Three
Select s4= new Select(childRoom);
s4.selectByVisibleText(roomchild);


WebElement submit = driver.findElement(By.id("Submit"));
submit.click();
	}
	public void selectHotel() {

WebElement radBtn = driver.findElement(By.id("radiobutton_0"));
radBtn.click();
WebElement selectBtn = driver.findElement(By.id("continue"));
selectBtn.click();
}
	public void bookAhotel(String name,String nameLast,String address1,String cardNumber,String cardType1,String expiryMon,String expiryYear,String ccvNo) {
		WebElement firstName = driver.findElement(By.id("first_name"));
		firstName.sendKeys(name);
		WebElement lastName = driver.findElement(By.id("last_name"));
		lastName.sendKeys(nameLast);
		WebElement address = driver.findElement(By.id("address"));
		address.sendKeys(address1);		
		WebElement cardNo = driver.findElement(By.id("cc_num"));
		cardNo.sendKeys(cardNumber);
		WebElement cardType = driver.findElement(By.id("cc_type"));
		Select s5= new Select(cardType);
		s5.selectByVisibleText(cardType1);	
		WebElement expMonth = driver.findElement(By.id("cc_exp_month"));
		Select s6= new Select(expMonth);
		s6.selectByVisibleText(expiryMon);	
		WebElement expYear = driver.findElement(By.id("cc_exp_year"));
		Select s7= new Select(expYear);
		s7.selectByVisibleText(expiryYear);	
		WebElement ccv = driver.findElement(By.id("cc_cvv"));
		ccv.sendKeys(ccvNo);
		
		WebElement bookingConfrim = driver.findElement(By.id("book_now"));
		bookingConfrim.click();	
		
		}
	
	private void bookingConfirmation() {
						
		WebElement orderNO = driver.findElement(By.name("my_itinerary"));
		orderNO.click();
		WebElement orderId = driver.findElement(By.xpath("(//input[@type='text'])[39]"));
		String text = orderId.getAttribute("value");
		System.out.println(text);
		

	}
	public static void main(String[] args) {
		LibGlobalUtility m= new LibGlobalUtility();
		m.login("DhanalakshmiMurugan", "dhana@M");
		m.searchHotel("London", "Hotel Sunshine", "Standard", "3 - Three", "17/12/2022", "18/12/2022", "2 - Two","3 - Three");
		m.selectHotel();
		m.bookAhotel("Dhanalakshmi", "murugan", "no1,thirukulam street,mamallapuram", "6543212345678987", "VISA", "December", "2022", "234");
	    m.bookingConfirmation();
	}
}
