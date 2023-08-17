import manager.AppManager;
import manager.HelperStudent;
import models.Gender;
import models.Hobby;
import models.StudentDTO;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import java.util.ArrayList;
import java.util.List;

public class StudentFormTest extends TestBase implements HelperStudent {

    Logger logger = LoggerFactory.getLogger(StudentFormTest.class);

    @BeforeMethod
    public void precondition(){
        hideAds();
        logger.info("Hiding Ads");
        selectForms();
        logger.info("Selecting forms");
        pause(5000);
        selectPracticeForm();
        logger.info("Selecting practice forms");
    }

    @Test
    public void studentFormPositive(){

        List<Hobby> hobbies = new ArrayList<>();
        hobbies.add(Hobby.MUSIC);
        hobbies.add(Hobby.READING);


        StudentDTO studentDTO = StudentDTO.builder()
                .firstName("Sarah")
                .lastName("Connor")
                .email("sarah@gmail.com")
                .gender(Gender.FEMALE)
                .phone("1234567890")
                .birthday("5 05 2000")
                .subjects("Maths,Physics")
                .hobbies(hobbies)
                .address("Main street, 5")
                .state("NCR")
                .city("Delhi")
                .build();

        fillForm(studentDTO);
        submit();

    }


}