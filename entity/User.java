package entity;

public class User {
    private Integer id;
    private String userFirstName;
    private String userLastName;
    private String userGender;
    private Integer userAge;
    private String userPsychotype;


    public User() {
    }
    public User(String userFirstName, String userLastName, String userGender, Integer userAge, String userPsychotype) {
        this.userFirstName = userFirstName;
        this.userLastName = userLastName;
        this.userGender = userGender;
        this.userAge = userAge;
        this.userPsychotype = userPsychotype;
    }

    public void setUserFirstName(String userFirstName) {
        this.userFirstName = userFirstName;
    }

    public void setUserLastName(String userLastName) {
        this.userLastName = userLastName;
    }

    public void setUserGender(String userGender) {
        this.userGender = userGender;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setUserAge(Integer userAge) {
        this.userAge = userAge;
    }

    public void setUserPsychotype(String userPsychotype) {
        this.userPsychotype = userPsychotype;
    }

    public String getUserFirstName() {
        return userFirstName;
    }

    public String getUserLastName() {
        return userLastName;
    }

    public String getUserGender() {
        return userGender;
    }

    public Integer getUserAge() {
        return userAge;
    }

    public String getUserPsychotype() {
        return userPsychotype;
    }


    @Override
    public String toString() {
        return "ID: " + this.id +
               "\nИмя: " + this.userFirstName +
               "\nФамилия: " + this.userLastName +
               "\nПол: " + this.userGender +
               "\nВозраст: " + this.userAge +
               "\nПсихотип: " + this.userPsychotype;
    }
}
