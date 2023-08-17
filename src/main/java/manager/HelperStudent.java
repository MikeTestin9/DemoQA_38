package manager;

import models.Gender;
import models.Hobby;
import models.StudentDTO;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.List;

public interface HelperStudent extends HelperBase{
    Logger logger = LoggerFactory.getLogger(HelperStudent.class);

    default void selectForms(){
        click(By.xpath("//div[@class='category-cards']/div[2]"));
    }
    default void selectPracticeForm(){
//        click(By.id("item-0"));
        click(By.xpath("//span[.='Practice Form']"));
    }

    default void fillForm(StudentDTO studentDTO){
        type(By.id("firstName"), studentDTO.getFirstName());
        logger.info("First name is: " + studentDTO.getFirstName());
        type(By.id("lastName"), studentDTO.getLastName());
        logger.info("last name is: " + studentDTO.getLastName());
        type(By.id("userEmail"), studentDTO.getEmail());
        logger.info("The email is: " + studentDTO.getEmail());
        selectGender(studentDTO.getGender());
        logger.info(studentDTO.getFirstName() + "'s gender is: " + studentDTO.getGender());
        type(By.id("userNumber"), studentDTO.getPhone());
        logger.info(studentDTO.getFirstName() + "'s phone number is: " + studentDTO.getPhone());

        hideFooter();

//        type(By.id("dateOfBirthInput"), studentDTO.getBirthday());
        typeBDay(studentDTO.getBirthday());
        addSubject(studentDTO.getSubjects());
        logger.info("The subject/s is/are: " + studentDTO.getSubjects());
        selectHobby(studentDTO.getHobbies());
        logger.info("The hobby/s is/are: " + studentDTO.getHobbies());
        type(By.id("currentAddress"), studentDTO.getAddress());
        logger.info(studentDTO.getFirstName() + "'s address is: " + studentDTO.getAddress());
        typeState(studentDTO.getState());
        typeCity(studentDTO.getCity());
        logger.info(studentDTO.getFirstName() + "is from: " + studentDTO.getPhone() + ", " + studentDTO.getCity());
    }

    default void typeBDay(String birthday){

        String[] components = birthday.split(" ");
        String day = components[0];
        String month = components[1];
        String year = components[2];
        String monthLong = "";

        if (month.equals("01")) {
            monthLong = "January";
        } else if (month.equals("02")) {
            monthLong = "February";
        } else if (month.equals("03")) {
            monthLong = "March";
        } else if (month.equals("04")) {
            monthLong = "April";
        } else if (month.equals("05")) {
            monthLong = "May";
        } else if (month.equals("06")) {
            monthLong = "June";
        } else if (month.equals("07")) {
            monthLong = "July";
        } else if (month.equals("08")) {
            monthLong = "August";
        } else if (month.equals("09")) {
            monthLong = "September";
        } else if (month.equals("10")) {
            monthLong = "October";
        } else if (month.equals("11")) {
            monthLong = "November";
        } else if (month.equals("12")) {
            monthLong = "December";
        }

        logger.info("The date of birth is: " + day + "/" + month + "/" + year);
        logger.info("Day: " + day);
        logger.info("Month: " + monthLong);
        logger.info("year: " + year);


        WEB_DRIVER.findElement(By.xpath("//input[@id='dateOfBirthInput']")).click();
        pause(2000);

        WebElement yearElement = WEB_DRIVER.findElement(By.xpath("//div[@class='react-datepicker__year-dropdown-container react-datepicker__year-dropdown-container--select']"));
        yearElement.click();
        pause(1000);
        WebElement clickYear = WEB_DRIVER.findElement(By.xpath("//option[@value='" + year + "']"));
        clickYear.click();
        pause(1000);
        WebElement monthElement = WEB_DRIVER.findElement(By.xpath("//div[@class='react-datepicker__month-dropdown-container react-datepicker__month-dropdown-container--select']"));
        monthElement.click();
        pause(1000);
        WebElement clickMonth = WEB_DRIVER.findElement(By.xpath("//select[@class='react-datepicker__month-select']/option[contains(text(), '" + monthLong + "')]"));
        clickMonth.click(); //idk why. not closing the dropdown
        monthElement.click();
        pause(1000);
        String dayPick = "//div[contains(@aria-label, '" + monthLong + " " + day + "')]";
        WebElement dayElement = WEB_DRIVER.findElement(By.xpath(dayPick));
        dayElement.click();

    }

    default void selectGender(Gender gender){
        if(gender.equals(Gender.MALE)){
//            click(By.id("gender-radio-1"));
            click(By.xpath("//label[@for='gender-radio-1']"));
        } else if (gender.equals(Gender.FEMALE)){
//            click(By.id("gender-radio-2"));
            click(By.xpath("//label[@for='gender-radio-2']"));
        } else {
//            click(By.id("gender-radio-3"));
            click(By.xpath("//label[@for='gender-radio-3']"));
        }
    }

    default void addSubject(String subjects){
        String[] split = subjects.split(",");
        String locator = "subjectsInput";
        click(By.id(locator));
        for(String subject : split){
            WEB_DRIVER.findElement(By.id(locator)).sendKeys(subject);
            WEB_DRIVER.findElement(By.id(locator)).sendKeys(Keys.ENTER);
        }
    }

    default void selectHobby(List<Hobby> hobbies){

        for(Hobby hobby : hobbies){
            switch (hobby){
                case SPORTS:
//                    click(By.id("hobbies-checkbox-1"));
                    click(By.xpath("//label[@for='hobbies-checkbox-1']"));
                    break;
                case READING:
//                    click(By.id("hobbies-checkbox-2"));
                    click(By.xpath("//label[@for='hobbies-checkbox-2']"));
                    break;
                case MUSIC:
//                    click(By.id("hobbies-checkbox-3"));
                    click(By.xpath("//label[@for='hobbies-checkbox-3']"));
                    break;
            }
        }
    }

    default void typeState(String state){
        WEB_DRIVER.findElement(By.id("react-select-3-input")).sendKeys(state);
        WEB_DRIVER.findElement(By.id("react-select-3-input")).sendKeys(Keys.ENTER);
    }
    default void typeCity(String city){
        WEB_DRIVER.findElement(By.id("react-select-4-input")).sendKeys(city);
        WEB_DRIVER.findElement(By.id("react-select-4-input")).sendKeys(Keys.ENTER);
    }

    default void submit(){
//        click(By.xpath("//button[@id='submit']"));
        WebElement submitButton = WEB_DRIVER.findElement(By.xpath("//button[@id='submit']"));
        submitButton.submit();
        logger.info("The form has been submitted successfully");
    }
    default void closeResultForm(){
        
    }
}