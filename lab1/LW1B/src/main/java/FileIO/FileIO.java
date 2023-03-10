package FileIO;

import java.io.*;

public class FileIO implements FileIOI{

    private String fileName = "file.txt";

    public String getFileName() {
        return fileName;
    }

    public void setFileName(String fileName) {
        this.fileName = fileName;
    }

    @Override
    public void saveToFile(Object object) {

        try {
            FileOutputStream fos = new FileOutputStream(fileName);
            ObjectOutputStream oos = new ObjectOutputStream(fos);
            oos.writeObject(object);
            oos.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    @Override
    public Object loadFromFile() {
        Object result =null;

        try {
            FileInputStream fis = new FileInputStream(fileName);
            ObjectInputStream ois = new ObjectInputStream(fis);
            result = ois.readObject();
            ois.close();

        } catch (IOException | ClassNotFoundException e) {
            throw new RuntimeException(e);
        }

        return result;
    }
}
