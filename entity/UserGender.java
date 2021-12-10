package entity;

public enum UserGender {
    MALE("Мужчина"),
    FEMALE("Женищина");

    private final String gender;
    UserGender(String gender) {
        this.gender = gender;
    }

    public String getGender() {
        return gender;
    }
}
