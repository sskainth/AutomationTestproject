package PageObjects;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import utility.BaseBrowser;

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

public class FlipcartHomePage {

    WebDriver driver;


    public FlipcartHomePage(WebDriver driver) {

        this.driver = driver;
    }

    public void enterProduct(String productName) {

        driver.findElement(By.xpath("//input[@title ='Search for Products, Brands and More']")).sendKeys(productName);

    }

    public void searchProduct() {
        driver.findElement(By.className("_2iLD__")).submit();
        //INPUT.zDPmFV
    }

    public void retriveInFie() throws IOException, InterruptedException {
        List<WebElement> searchResult = driver.findElements(By.xpath("//div[@class='tUxRFH']"));
        XSSFWorkbook workbook = new XSSFWorkbook();
        XSSFSheet sheet = workbook.createSheet("searchedProduct");

        int rowNum = 0;
        Row row = null;
        List<WebElement> name = List.of();
        List<WebElement> price = List.of();
        Thread.sleep(2000);
        //initializing the row with heading Name and Price
        row = sheet.createRow(rowNum++);
        row.createCell(0).setCellValue("NAME");
        row.createCell(1).setCellValue("PRICE");

        //getting price and name
        for (WebElement product : searchResult) {
            name = product.findElements(By.xpath("//div[@class='KzDlHZ']"));
            price = product.findElements(By.xpath("//div[@class='Nx9bqj _4b5DiR']"));
        }

        //storing Name and price into the xl sheets
        for (int i = 0; i < name.size(); i++) {
            String column1 = name.get(i).getText();
            String column2 = price.get(i).getText();

            row = sheet.createRow(rowNum++);

            row.createCell(0).setCellValue(column1);
            row.createCell(1).setCellValue(column2);
            System.out.println("column1 "+column1);
            System.out.println("column2" +column2);
        }
        FileOutputStream osFile = new FileOutputStream("src/test/resources/searchedProduct.xlsx");
        workbook.write(osFile);
    }
}
