package compulsory;

import compulsory.Catalog;
import compulsory.Document;
import compulsory.CatalogUtil;

import java.io.IOException;


public class Main {
    public static void main(String args[]) {

        try {
            Main app = new Main();
            app.testCreateSave();
            app.testLoadView();
        } catch (Exception e) {
            e.printStackTrace();

        }

    }

    private void testCreateSave() throws IOException {
        Catalog catalog =
                new Catalog("Java Resources", "d:/java/catalog.ser");
        Document doc = new Document("java1", "Java Course 1",
                "https://profs.info.uaic.ro/~acf/java/slides/en/intro_slide_en.pdf");
        Document doc2 = new Document("java2", "Java Course 2",
                "d:/java/alo.txt");
        doc.addTag("type", "Slides");
        catalog.add(doc);

        CatalogUtil.save(catalog);
    }

    private void testLoadView() throws IOException, InvalidCatalogException, ClassNotFoundException {
        Catalog catalog = CatalogUtil.load("d:/java/catalog.ser");
        Document doc = catalog.findById("java1");
        CatalogUtil.view(doc);
    }

}
