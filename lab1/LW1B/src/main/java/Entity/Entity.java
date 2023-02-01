package Entity;

public class Entity {

    private String name;
    private int timeToWait;
    private String description;

    public Entity(String name, int timeToWait, String description) {
        this.name = name;
        this.timeToWait = timeToWait;
        this.description = description;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getTime_to_waite() {
        return timeToWait;
    }

    public void setTime_to_waite(int time_to_waite) {
        this.timeToWait = timeToWait;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    //create Gson....
    @Override
    public String toString(){
        return "{ \"name\" : \""+name+"\", \"timeToWaite\":\""+timeToWait+"\",\"description\":"+description+" } " ;
    }
}
