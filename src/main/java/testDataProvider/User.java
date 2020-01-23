package testDataProvider;

import com.github.javafaker.Faker;

public class User {

    String FirstName;
    String LastName;
    String DisplayName;
    String Description;
    String Email;
    String Phone;
    String Skype;
    String Password;
    String Note;

    Faker faker = new Faker();

    public void setFirstName(){
        this.FirstName = faker.name().firstName();
    }

    public String getFirstName(){
        return this.FirstName;
    }

    public void setLastName(){
        this.LastName = faker.name().lastName();
    }

    public String getLastName(){
        return this.LastName;
    }

    public void setDisplayName(){
        this.DisplayName = faker.name().fullName();
    }

    public String getDisplayName(){
        return this.DisplayName;
    }

    public void setDescription(){
        this.Description = faker.gameOfThrones().quote();
    }

    public String getDescription(){
        return this.Description;
    }

    public void setPhone(){
        this.Phone = faker.phoneNumber().subscriberNumber(9);
    }

    public String getPhone(){
        return this.Phone;
    }

    public void setSkype(){
        this.Skype = faker.name().username();
    }

    public String getSkype(){
        return this.Skype;
    }

    public void setPassword(){
        this.Password = faker.internet().password();
    }

    public String getPassword(){
        return this.Password;
    }

    public void setNote(){
        this.Note = faker.gameOfThrones().quote();
    }

    public String getNote(){
        return this.Note;
    }

}
