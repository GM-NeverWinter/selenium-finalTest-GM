package org.main.Base;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.apache.poi.ss.usermodel.Workbook;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import java.io.IOException;

public class BaseTest {
    private final Logger log = LogManager.getLogger(this.getClass());
    protected WebDriver driver;
    private Workbook wb;

    /*
    @BeforeTest
    @Parameters({ "filePath", "fileName", "sheetName" })
    public void readExcel(String filePath, String fileName, String sheetName) throws IOException {
        File eFile = new File(filePath + File.separator + fileName);
        FileInputStream inputStream = new FileInputStream(eFile);

        // Determine the file type (XLS or XLSX)
        String extensionName = fileName.substring(fileName.lastIndexOf("."));
        if (extensionName.equalsIgnoreCase(".xlsx")) {
            wb = new XSSFWorkbook(inputStream);
        } else if (extensionName.equalsIgnoreCase(".xls")) {
            wb = new HSSFWorkbook(inputStream);
        }
    }
    // Use an ArrayList to store data (resizable array)
    @DataProvider(name = "input") // Name file
    public Object[][] provideData() {
        Sheet wbSheet = wb.getSheet("Sheet1"); // Change to your sheet name
        Format dateFormat = new SimpleDateFormat("MM-dd-yyyyyyHH:mma");

        int rowCount = wbSheet.getLastRowNum() - wbSheet.getFirstRowNum() + 1;
        List<Object[]> data = new ArrayList<>();
        for (int i = 1; i < rowCount; i++) { // Start from the second row (skip the first row)
            Row row = wbSheet.getRow(i);
            String name = row.getCell(0).getStringCellValue(); // Name
            String subject = row.getCell(1).getStringCellValue(); // Subject
            String body = row.getCell(2).getStringCellValue(); // Body
            String date = dateFormat.format(row.getCell(3).getDateCellValue()); // Date format to String
            String store = row.getCell(4).getStringCellValue(); // Dropdown-list store
            String role = row.getCell(5).getStringCellValue(); // Dropdown-list role
            data.add(new Object[]{name, subject, body, date, store, role});
        }
        return data.toArray(new Object[0][0]);
    }
     */

    @BeforeMethod
    @Parameters("browser")
    public void initDriver(String browser) {
        switch (browser.toLowerCase()) {
            case "chrome":
                System.setProperty("webdriver.chrome.driver",
                        System.getProperty("user.dir") + "\\src\\main\\resources\\Driver\\chromedriver.exe");
                driver = new ChromeDriver();
                log.info("Execute on Chrome");
                break;
            case "firefox":
                System.setProperty("webdriver.gecko.driver",
                        System.getProperty("user.dir") + "\\src\\main\\resources\\Driver\\geckodriver.exe");
                driver = new FirefoxDriver();
                log.info("Execute on Firefox");
                break;
            default:
                throw new IllegalArgumentException("Invalid Browser");
        }
    }

    @BeforeMethod
    public void setUp() {
//      driver.manage().window().maximize();
        driver.get("https://katalon-demo-cura.herokuapp.com/"); // Web page
        log.info("Go to URL");
        /*
        WebDriverWait wait = new WebDriverWait(driver, 10);
        wait.until(driver1 -> ((JavascriptExecutor) driver)
                .executeScript("return document.readyState")
                .equals("complete"));
         */
    }

    @AfterMethod
    public void tearDown() throws IOException, InterruptedException {
        if (driver != null) {
            log.info("Execute Quit Browser in 2 seconds.");
            Thread.sleep(2000);
            driver.quit();
        }
        if (wb != null) {
            log.info("Execute close workbook");
            wb.close();
        }
    }
}
