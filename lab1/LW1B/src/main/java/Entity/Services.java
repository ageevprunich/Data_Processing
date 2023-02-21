package Entity;

import java.io.Serializable;

public class Services implements Serializable {
    public static final long serialVersionUID =1L;
    private String name;
    private int timeToWait;
    private String imag;

    public Services(String name, int timeToWait, String imag) {
        this.name = name;
        this.timeToWait = timeToWait;
        this.imag = imag;
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

    public String getImag() {
        return imag;
    }

    public void setImag(String imag) {
        this.imag = imag;
    }

    //create Gson....
    @Override
    public String toString(){
        return "{ \"name\" : \""+name+"\", \"timeToWaite\":\""+timeToWait+"\",\"description\":"+imag+" } " ;
    }

}
