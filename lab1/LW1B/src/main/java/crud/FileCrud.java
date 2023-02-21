package crud;
import Entity.Services;
import FileIO.FileIO;
import FileIO.FileIOI;

public class FileCrud implements Lab2CrudI{

    FileIOI fio;
    public FileCrud(){
        this.fio = new FileIO();
    }
    @Override
    public Services readEntity() {

        return (Services) fio.loadFromFile();
    }

    @Override
    public void update(Services documents) {
        fio.saveToFile(documents);
    }
}
