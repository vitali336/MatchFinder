import java.util.ArrayList;
import java.util.Arrays;
import java.util.UUID;

/**
 * Objects of this class represent a person who is looking for a partner.
 * The attributes describe the own properties and the search criteria.
 */
public class Single implements Cloneable {

    private final UUID id;

    private String firstName;
    private String lastName;
    private Gender gender;
    private int age;
    private ArrayList<Gender> seeksGenders;
    private int seeksAgeMin;
    private int seeksAgeMax;

    public Single(String firstName, String lastName, Gender gender, int age,
                  Gender[] seeksGenders, int seeksAgeMin, int seeksAgeMax) {

        this.id = UUID.randomUUID();

        this.firstName = firstName;
        this.lastName = lastName;
        this.gender = gender;
        this.age = age;
        this.seeksGenders = new ArrayList<Gender>(Arrays.asList(seeksGenders));
        this.seeksAgeMin = seeksAgeMin;
        this.seeksAgeMax = seeksAgeMax;
    }

    /**
     * Checks if an object of another single meets the search
     * criteria of the single represented by this object.
     * @param single object of another single
     * @return true if the object of another single meets the search
     * criteria of the single represented by this object.
     */
    public boolean likesSingle(Single single) {
        return single.age <= this.seeksAgeMax && single.age >= this.seeksAgeMin
                && this.seeksGenders.contains(single.gender);
    }

    /**
     * Checks if there is a match between the single represented by this object
     * and another single.
     * @param single object of another single
     * @return true if the single represented by this object meets the search
     * criteria of the other one and vice versa
     */
    public boolean matchWith(Single single) {
        return this.likesSingle(single) && single.likesSingle(this);
    }

    public boolean isHetero(){
        return this.gender == Gender.MALE
                && this.seeksGenders.size() == 1
                && this.seeksGenders.get(0) == Gender.FEMALE
                ||
                this.gender == Gender.FEMALE
                        && this.seeksGenders.size() == 1
                        && this.seeksGenders.get(0) == Gender.MALE;
    }

    @Override
    public String toString() {
        return "id='" + id + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", gender=" + gender +
                ", age=" + age +
                ", seeksGenders=" + seeksGenders +
                ", seeksAgeMin=" + seeksAgeMin +
                ", seeksAgeMax=" + seeksAgeMax + '\n';
    }

    @Override
    protected Single clone() throws CloneNotSupportedException {
        return new Single(this.firstName, this.lastName, this.gender, this.age, this.getSeeksGenders(), this.seeksAgeMin, this.seeksAgeMax);
    }


    public UUID getId() { return id; }

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

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Gender[] getSeeksGenders() {
        return this.seeksGenders.toArray(new Gender[0]);
    }

    public void setSeeksGenders(Gender[] seeksGenders) {
        this.seeksGenders = new ArrayList<Gender>(Arrays.asList(seeksGenders));
    }

    public int getSeeksAgeMin() {
        return seeksAgeMin;
    }

    public void setSeeksAgeMin(int seeksAgeMin) {
        this.seeksAgeMin = seeksAgeMin;
    }

    public int getSeeksAgeMax() {
        return seeksAgeMax;
    }

    public void setSeeksAgeMax(int seeksAgeMax) {
        this.seeksAgeMax = seeksAgeMax;
    }
}
