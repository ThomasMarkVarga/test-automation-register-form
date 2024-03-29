package pages;

import org.openqa.selenium.Keys;
import org.openqa.selenium.NoSuchElementException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import javax.xml.xpath.XPath;

public class SignUpPage {
    WebDriver driver;

    @FindBy(id = "username")
    WebElement userNameInput;
    @FindBy(xpath = "//*[@id=\"svelte\"]/div[1]/div[2]/div[2]/div/div/div/form/div[1]/small[2]")
    WebElement userNameErrorElement;

    @FindBy(id = "password")
    WebElement passwordInput;
    @FindBy(xpath = "//*[@id=\"svelte\"]/div[1]/div[2]/div[2]/div/div/div/form/div[2]/small[2]")
    WebElement passwordErrorElement;

    @FindBy(id = "password2")
    WebElement confirmPasswordInput;
    @FindBy(xpath = "//*[@id=\"svelte\"]/div[1]/div[2]/div[2]/div/div/div/form/div[3]/small[2]")
    WebElement confirmPasswordErrorElement;

    @FindBy(id = "Ms")
    WebElement msRadioButton;
    @FindBy(id = "Mr")
    WebElement mrRadioButton;

    @FindBy(id = "input-first-name")
    WebElement firstNameInput;
    @FindBy(xpath = "//*[@id=\"svelte\"]/div[1]/div[2]/div[2]/div/div/div/form/div[6]/small[2]")
    WebElement firstNameErrorElement;

    @FindBy(id = "input-last-name")
    WebElement lastNameInput;
    @FindBy(xpath = "//*[@id=\"svelte\"]/div[1]/div[2]/div[2]/div/div/div/form/div[7]/small[2]")
    WebElement lastNameErrorElement;

    @FindBy(id = "input-email")
    WebElement emailInput;

    @FindBy(id = "input-dob")
    WebElement dateOfBirthInput;

    @FindBy(id = "input-nationality")
    WebElement nationalityElement;

    @FindBy(id = "terms")
    WebElement termsAndConditionsCheckbox;

    @FindBy(xpath = "//*[@id=\"svelte\"]/div[1]/div[2]/div[2]/div/div/div/form/div[12]/button")
    WebElement submitButton;

    public SignUpPage(WebDriver driver){
        this.driver = driver;
        PageFactory.initElements(driver, this);
    }

    public boolean open(String url){
        if(driver == null) return false;
        driver.get(url);
        return true;
    }

    public void insertIntoInputElement(WebElement inputElement, String textValue){
        inputElement.clear();
        inputElement.sendKeys(textValue);
    }

    public void insertUserName(String userNameText){
        System.out.println("Username input " + userNameText);
        insertIntoInputElement(userNameInput, userNameText);
    }

    public void insertUPassword(String passwordText){
        System.out.println("Password input " + passwordText);
        insertIntoInputElement(passwordInput, passwordText);
    }

    public void insertConfirmUPassword(String passwordConfirmText){
        System.out.println("Password confirm input " + passwordConfirmText);
        insertIntoInputElement(confirmPasswordInput, passwordConfirmText);
    }

    public void selectGender(String value){
        if(value.equalsIgnoreCase("ms")){
            msRadioButton.click();
        }

        if(value.equalsIgnoreCase("mr")){
            mrRadioButton.click();
        }
    }

    public void insertFirstName(String firstNameText){
        insertIntoInputElement(firstNameInput, firstNameText);
    }

    public void insertLastName(String lastNameText){
        insertIntoInputElement(lastNameInput, lastNameText);
    }

    public void insertEmail(String emailText){
        insertIntoInputElement(emailInput, emailText);
    }

    public void selectDateOfBirth(String dateOfBirthValue){
        insertIntoInputElement(dateOfBirthInput, dateOfBirthValue);
    }

    public void selectNationality(String nationalityValue){
        Select nationalitySelect = new Select(nationalityElement);
        nationalitySelect.selectByVisibleText(nationalityValue);
    }

    public void checkTermsAndConditions(boolean value){
        System.out.println("Selected = " + termsAndConditionsCheckbox.getAttribute("selected"));
        termsAndConditionsCheckbox.sendKeys(Keys.SPACE);
        System.out.println("Selected = " + termsAndConditionsCheckbox.getAttribute("selected"));
    }

    public void registerNewUser(String username, String password, String confirmationPassword, String gender,
                                String firstName, String lastName, String email, String dateOfBirth, String nationality, boolean termsAndConditionsSelected){
        insertUserName(username);
        insertUPassword(password);
        insertConfirmUPassword(confirmationPassword);
        selectGender(gender);
        insertFirstName(firstName);
        insertLastName(lastName);
        insertEmail(email);
        selectDateOfBirth(dateOfBirth);
        selectNationality(nationality);
        checkTermsAndConditions(termsAndConditionsSelected);

//        submitButton.submit();
    }

    public boolean checkErr(String expectedErr, String errorType) {
        switch (errorType) {
            case "username":
                String userNameError = "";
                try {
                    userNameError = userNameErrorElement.getText();
                } catch (NoSuchElementException e) {

                }
                return expectedErr.equalsIgnoreCase(userNameError);
            case "password":
                String passwordError = "";
                try {
                    passwordError = passwordErrorElement.getText();
                } catch (NoSuchElementException e) {

                }
                return expectedErr.equalsIgnoreCase(passwordError);
            case "confirmPassword":
                String confirmPasswordError = "";
                try {
                    confirmPasswordError = confirmPasswordErrorElement.getText();
                } catch (NoSuchElementException e) {

                }
                return expectedErr.equalsIgnoreCase(confirmPasswordError);
            case "firstName":
                String firstNameError = "";
                try {
                    firstNameError = firstNameErrorElement.getText();
                } catch (NoSuchElementException e) {

                }
                return expectedErr.equalsIgnoreCase(firstNameError);
            case "lastName":
                String lastNameError = "";
                try {
                    lastNameError = lastNameErrorElement.getText();
                } catch (NoSuchElementException e) {

                }
                return expectedErr.equalsIgnoreCase(lastNameError);
            case "email":
                String email = emailInput.getAttribute("value");
//                System.out.println("TEST" + isEmailValid(email) + "email: " + emailInput.getAttribute("value"));
//                return isEmailValid(email);

            default:
                return false;
        }
    }
}
