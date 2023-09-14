package Test_scenarios;


import Config.Connection_Object;
import Object_Model.File_Submission_Model;
import Object_Model.Login_Model;
import org.openqa.selenium.Alert;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class UserStory_02
{
    private WebDriver driver;
//    private File_Submission_Model csvSubmission;
    private Login_Model loginPage;
    private Alert browse;

    @BeforeTest
    public void setup() {
        System.out.println("===================12");
        Connection_Object connection = new Connection_Object();
        this.driver = connection.getDriver();
        this.loginPage = new Login_Model(this.driver);
    }
//    public void csv_page_setup(){
//        this.csvSubmission = new Login_Model(this.driver);
//        csvSubmission.open();
//        csvSubmission.csv_uploadpage_Open();
//    }
    @Test(priority = 1)
    public void login_to_System() throws InterruptedException {

        System.out.println("=====================1");
        loginPage.open();
        try {
//            InputStream inputStream = new FileInputStream(new File("src/test/resources/test_data.yml"));
//            Yaml yaml = new Yaml();
//            Map<String, Object> data = yaml.load(inputStream);
//            System.out.println("------------------------");
//            System.out.println(data);
            loginPage.login("clerk", "clerk");
            Thread.sleep(2000);
            System.out.println("=====================2");
        }catch(Exception e){
            System.out.println(e);
        }

    }
    @Test(priority = 2)
    public void csv_file_upload() throws InterruptedException {
        System.out.println("CSV UPLOAD===========================1");
//        this.csvSubmission = new Login_Model(this.driver);
        File_Submission_Model csvSubmission = new File_Submission_Model(this.driver);
        Thread.sleep(2000);
        csvSubmission.csv_uploadpage_open();
        System.out.println("CSV UPLOAD===========================2");

        try {
            String expectedMessage = "Unable to create hero!";
            String actualMessage = csvSubmission.csv_uploadpage_run();
            Assert.assertEquals(actualMessage,expectedMessage, "cannot compared");
            System.out.println("File is Uploaded Successfully");
        } catch (Exception e) {
            System.out.println(e);
            System.out.println("===========================");
        }

    }
    @AfterTest
    public void closePro() throws InterruptedException {
        Thread.sleep(2000);
        this.driver.quit();
    }
}
