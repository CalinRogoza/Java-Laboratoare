package compulsory;

import java.awt.*;
import java.io.*;
import java.net.URI;

import compulsory.Document;

public class CatalogUtil {
    public static void save(Catalog catalog)
            throws IOException {
        try (ObjectOutputStream oos = new ObjectOutputStream(
                new FileOutputStream(catalog.getPath()))) {
            oos.writeObject(catalog);
        }
    }

    public static Catalog load(String path)
            throws IOException, ClassNotFoundException {
        try (ObjectInputStream ois = new ObjectInputStream(
                new FileInputStream(path))) {
            Catalog catalog = (Catalog) ois.readObject();
            return catalog;
        }
    }

    public static void view(Document doc) throws IOException {
        Desktop desktop = Desktop.getDesktop();
        String path = doc.getLocation();
        if (path.startsWith("http")) {
            desktop.browse(URI.create(path));
        } else {
            File file = new File(path);
            desktop.open(file);
        }
    }
}
