package crud;
import Entity.Services;
import javax.swing.text.html.parser.Entity;

public interface Lab2CrudI {
    public Services readEntity();
    public void update(Services documents);
}
