package dataProviders;

import org.testng.annotations.DataProvider;

public class SignUpDataProvider {
    @DataProvider(name = "negativeSignUpDataProvider")
    public Object[][] negativeSignUpDataProvider() {
        return new Object[][]{
                {"chrome", "abc123", "12345678","12345678", "Ms", "fi", "la", "bla@test.com", "12/14/1999", "Romania", true, "", "", "" , "" ,
                        "","", "You need to accept our T&C!"},
                {"chrome", "", "","", "", "", "", "", "", "", false, "Please choose a username", "Please choose a password", "" , "" ,
                        "","Email is required!", "You need to accept our T&C!"},
                {"chrome", "abc123", "12345678","123456789", "Ms", "A", "B", "costel@gmail.com", "12/13/2025", "Romania", true, "", "", "Passwords do not match" , "Please choose a longer first name" ,
                        "Please choose a longer last name","", "You need to accept our T&C!"},
                {"chrome", "a", "","", "", "", "", "", "", "", false, "Please choose a longer username", "Please choose a password", "" , "" ,
                        "","Email is required!", "You need to accept our T&C!"},
                {"chrome", "abc", "","", "", "", "", "", "", "", false, "Please choose a longer username", "Please choose a password", "" , "" ,
                        "","Email is required!", "You need to accept our T&C!"},
                {"chrome", "abcd", "","", "", "", "", "", "", "", false, "", "Please choose a password", "" , "" ,
                        "","Email is required!", "You need to accept our T&C!"},
                {"chrome", "@#$%", "","", "", "", "", "", "", "", false, "", "Please choose a password", "" , "" ,
                        "","Email is required!", "You need to accept our T&C!"},
                {"chrome", "Popescu Daniel", "","", "", "", "", "", "", "", false, "", "Please choose a password", "" , "" ,
                        "","Email is required!", "You need to accept our T&C!"},
                {"chrome", "Abcdefghijklmopqrstuvwxyzabcdefghijklll", "","", "", "", "", "", "", "", false, "Please choose a shorter username", "Please choose a password", "" , "" ,
                        "","Email is required!", "You need to accept our T&C!"},
        };
    }
}
