package network;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SeleniumAutoLogin {
	
	public static void main(String[] args) {
		
		// 크롬드라이버 경로 설정
		System.setProperty("webdriver.chrome.driver", "D:/pub2511/driver/chromedriver.exe");

		// 안정성 향상을 위한 옵션 추가
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--remote-allow-origins=*");
		options.addArguments("--no-sandbox");
		options.addArguments("--disable-dev-shm-usage");
		options.addArguments("--disable-gpu");
		
		// 크롬드라이버
		WebDriver driver = new ChromeDriver(options);
		
		// Waiting 시간 설정
		WebDriverWait wait = new WebDriverWait(driver, Duration.ofSeconds(20));
		
		try {
			
			// GET 요청 (Orange HRM 연습용 사이트)
			driver.get("https://opensource-demo.orangehrmlive.com/web/index.php/auth/login");
			
			// 로그인
			// name이 username인 요소가 화면에 렌더링되면 Admin을 입력
			wait.until(ExpectedConditions.visibilityOfElementLocated(By.name("username")))
				.sendKeys("Admin");
			// name이 password인 요소에 admin123을 입력
			driver.findElement(By.name("password")).sendKeys("admin123");
			// button 요소 중 class가 orangehrm-login-button인 버튼을 클릭
			driver.findElement(By.cssSelector("button.orangehrm-login-button")).click();
			
			// 로그인 완료 확인
			wait.until(ExpectedConditions.presenceOfElementLocated(
				By.cssSelector("img[alt='client brand banner']")
			));
			
			// Admin 메뉴 클릭
			wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("//span[text()='Admin']/ancestor::a")
			)).click();
			
			// Add 버튼 클릭
			wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("//button[.=' Add ']")
			)).click();
			
			Thread.sleep(5000);
			
			// User Role
			List<WebElement> selects 
				= driver.findElements(By.cssSelector("div.oxd-select-text"));
			selects.get(0).click();
			wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("//div[@role='listbox']//span[text()='Admin']")
			)).click();
			
			// Employee Name
			WebElement empInput = wait.until(
				ExpectedConditions.visibilityOfElementLocated(
					By.cssSelector("input[placeholder='Type for hints...']")
				)
			);
			empInput.sendKeys("Peter Mac Anderson");
			
			Thread.sleep(5000);
			
			// 자동완성 항목 다시 클릭
			WebElement firstOption = wait.until(ExpectedConditions.elementToBeClickable(
			    By.cssSelector("div.oxd-autocomplete-option")));
			firstOption.click();
			
			// Status
			selects.get(1).click();
			wait.until(
					ExpectedConditions.elementToBeClickable
					(By.xpath("//div[@role='listbox']//span[text()='Enabled']")))
					.click();
			
			Thread.sleep(5000);
			
			// Username
			WebElement usernameInput 
			= wait.until(ExpectedConditions.visibilityOfElementLocated(
				    By.xpath("//label[text()='Username']/following::input[1]")));
				usernameInput.sendKeys("realchoky001");
				
			Thread.sleep(2000);				
				
			// Password / Confirm Password
			List<WebElement> pwInputs = driver.findElements(By.cssSelector("input[type='password']"));
			if (pwInputs.size() < 2) {
			    System.out.println("비밀번호 입력란이 부족합니다 (pwInputs.size = " + pwInputs.size() + ")");
			    return;
			}
			pwInputs.get(0).sendKeys("Password@123"); // Password
			pwInputs.get(1).sendKeys("Password@123"); // Confirm Password		
			
			Thread.sleep(2000);
			
	         // 저장 버튼 클릭
	         driver.findElement(By.cssSelector("button[type='submit']")).click();

	         System.out.println("사용자 추가 성공!");
			
		} catch (Exception ex) {
			ex.printStackTrace();
		} finally {
			driver.quit(); // 웹브라우져 종료
		}
		
	} // main

} // class




























