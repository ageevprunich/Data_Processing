package lab5.demo.Entity;
import jakarta.persistence.*;

@Entity
@Table(name = "refugees_table_new")
public class Refugees  {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;
    private String name;
    private Integer age;
    private String city;

    public Refugees(){

    }
    public Refugees(Integer id,String name, Integer age, String city) {
        this.id=id;
        this.name = name;
        this.age = age;
        this.city=city;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public String getCity() {return city;}

    public void setCity(String city) {this.city = city;}

    @Override
    public String toString() {
        return "Refugees{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", age=" + age +
                ", city='" + city + '\'' +
                '}';
    }

}