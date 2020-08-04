package com.pavel.flex;
import com.aspose.words.*;
import java.io.*;
import java.util.List;


public class Word {
    private  File wordDocument;

    public void setWordDocument(File wordDocument) {
        this.wordDocument = wordDocument;
    }

    public void insert(List<File> images) throws Exception {
        Document doc = new Document();
        DocumentBuilder builder = new DocumentBuilder(doc);
        PageSetup ps = doc.getFirstSection().getPageSetup();
        ps.setOrientation(Orientation.LANDSCAPE);
        for (File image: images
             ) {
            builder.insertImage(image.getAbsolutePath());
        }
        doc.save(wordDocument.getAbsolutePath());
    }

}
