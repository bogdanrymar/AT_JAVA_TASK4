package model;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import java.util.regex.Matcher;
import java.util.regex.Pattern;



public class PricingCalculatorPage extends AbstractPage {
    private static final String URL = "https://cloud.google.com/products/calculator";
    private static final String REGEX_TOTAL_SUM = ".*: (.+) p.*";


    public PricingCalculatorPage(WebDriver driver) {
        super(driver);
    }

    public PricingCalculatorPage open() {
        driver.get(URL);
        return this;
    }


    public PricingCalculatorPage enterFormFrame() {
        WebElement mainframe = driver.findElement(By.xpath("//*[@id=\"cloud-site\"]/devsite-iframe/iframe"));
        driver.switchTo().frame(mainframe);

        WebElement myFrame = driver.findElement(By.id("myFrame"));
        driver.switchTo().frame(myFrame);

        return this;
    }

    public PricingCalculatorPage switchToComputeEngineTab() {
        WebElement computeEngine = driver.findElement(By.id("tab-item-1"));
        computeEngine.click();

        return this;
    }

    public PricingCalculatorPage enterNumberOfInstances(int instances) {
        WebElement numInstances = driver.findElement(By.id("input_100"));
        numInstances.sendKeys(String.valueOf(instances));

        return this;
    }

    public PricingCalculatorPage enterPurpose(String description) {
        WebElement forWhatInstances = driver.findElement(By.id("input_101"));
        forWhatInstances.sendKeys(description);

        return this;
    }

    public PricingCalculatorPage chooseFreeOS() {
        WebElement operatingSystem = driver.findElement(By.id("select_value_label_92"));
        operatingSystem.click();

        delay(1);

        WebElement freeOS = driver.findElement(By.id("select_option_102"));
        freeOS.click();

        return this;
    }

    public PricingCalculatorPage chooseRegularProvisioningModel() {
        WebElement provisioningModel = driver.findElement(By.id("select_value_label_93"));
        provisioningModel.click();

        delay(1);

        WebElement regular = driver.findElement(By.id("select_option_115"));
        regular.click();

        return this;
    }

    public PricingCalculatorPage chooseGeneralMachineFamily() {
        WebElement machineFamily = driver.findElement(By.id("select_value_label_94"));
        machineFamily.click();

        delay(1);

        WebElement general = driver.findElement(By.id("select_option_119"));
        general.click();

        return this;
    }

    public PricingCalculatorPage chooseN1Series() {
        WebElement series = driver.findElement(By.id("select_value_label_95"));
        series.click();

        delay(1);

        WebElement n1 = driver.findElement(By.id("select_option_222"));
        n1.click();

        return this;
    }

    public PricingCalculatorPage chooseCpu8Ram32MachineType() {
        WebElement machineType = driver.findElement(By.id("select_value_label_96"));
        machineType.click();

        delay(1);

        WebElement cpu8Ram32 = driver.findElement(By.id("select_option_471"));
        cpu8Ram32.click();

        return this;
    }

    public PricingCalculatorPage chooseNVIDIATeslaV100GpuType() {
        WebElement checkGPU = driver.findElement(By.xpath("//*[@id=\"mainForm\"]/div[2]/div/md-card/md-card-content/div/div[1]/form/div[13]/div[1]/md-input-container/md-checkbox"));
        checkGPU.click();

        WebElement gpuType = driver.findElement(By.id("select_507"));
        gpuType.click();

        delay(1);

        WebElement NVIDIATeslaV100 = driver.findElement(By.id("select_option_514"));
        NVIDIATeslaV100.click();

        return this;
    }

    public PricingCalculatorPage choose1Gpu() {
        WebElement numOfGPUs = driver.findElement(By.id("select_509"));
        numOfGPUs.click();

        delay(1);

        WebElement oneGPU = driver.findElement(By.id("select_option_517"));
        oneGPU.click();

        return this;
    }

    public PricingCalculatorPage chooseSSD2x375() {
        WebElement localSSD = driver.findElement(By.id("select_value_label_465"));
        localSSD.click();

        delay(1);

        WebElement SSD2x375 = driver.findElement(By.id("select_option_492"));
        SSD2x375.click();

        return this;
    }

    public PricingCalculatorPage chooseEurope3Location() {
        WebElement location = driver.findElement(By.id("select_value_label_98"));
        location.click();

        delay(1);

        WebElement europe3 = driver.findElement(By.id("select_option_265"));
        europe3.click();

        return this;
    }

    public PricingCalculatorPage choose1YearUsage() {
        WebElement usage = driver.findElement(By.id("select_value_label_99"));
        usage.click();

        delay(1);

        WebElement oneYear = driver.findElement(By.id("select_option_138"));
        oneYear.click();

        return this;
    }

    public PricingCalculatorPage submitForm() {
        delay(2);

        WebElement submitButton = driver.findElement(By.cssSelector("[ng-click=\"listingCtrl.addComputeServer(ComputeEngineForm);\"]"));
        submitButton.click();

        return this;
    }

    public PricingCalculatorPage sendToEmail(String email) {
        WebElement emailButton = driver.findElement(By.id("Email Estimate"));
        emailButton.click();

        WebElement emailString = driver.findElement(By.xpath("//input[@type='email']"));
        emailString.sendKeys(email);
        //delay(500);
        WebElement sendLetterButton = driver.findElement(By.xpath("/html/body//md-dialog/form/md-dialog-actions/button[2]"));

        sendLetterButton.click();

        return this;
    }

    public String getTotalSum() {
        WebElement totalSum = driver.findElement(By.xpath("//*[@id=\"resultBlock\"]/md-card/md-card-content/div/div/div/div[1]/h2/b"));
        String sum = totalSum.getText();

        Pattern pattern = Pattern.compile(REGEX_TOTAL_SUM);
        Matcher matcher = pattern.matcher(sum);
        return matcher.replaceAll("$1");
    }
}