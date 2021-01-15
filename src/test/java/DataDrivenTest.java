import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataDrivenTest {

    @DataProvider(name="Invalid Credentials")
    public Object[][] getData() {
        Object[][] array = {
                {"Admin", "123", "Invalid credentials"},
                {"Admin1", "Hum@nhrm123", "Invalid credentials"},
                {"Admin", "", "Password cannot be empty"},
                {"", "Syntax123", "Username cannot be empty"}
        };
        return array;
    }

    @Test(dataProvider ="Invalid Credentials")
    public void myTest(String username, String password,  String message){
        System.out.println("username ="+username);
        System.out.println("password ="+password);
        System.out.println("message ="+message);
        System.out.println("----------------------------------");
    }

    @BeforeMethod
    public void before() {
        System.out.println("Before method");
    }

    @AfterMethod
    public void after(){
        System.out.println("After method");
    }
}
