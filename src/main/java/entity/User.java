package entity;

public final class User {
    private String id;
    private String firstName;
    private String lastName;
    private int age;
    private String workPlace;
    private String ownCity;

    public User(String firstName, String lastName, int age, String workPlace, String ownCity) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.age = age;
        this.workPlace = workPlace;
        this.ownCity = ownCity;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getWorkPlace() {
        return workPlace;
    }

    public void setWorkPlace(String workPlace) {
        this.workPlace = workPlace;
    }

    public String getOwnCity() {
        return ownCity;
    }

    public void setOwnCity(String ownCity) {
        this.ownCity = ownCity;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }
}
