package com.pavel.flex;

import com.aspose.words.Document;
import com.aspose.words.DocumentBuilder;

public class TEST {
    public static void main(String[] args) throws Exception {

        Document doc = new Document();
        DocumentBuilder builder = new DocumentBuilder(doc);
        builder.insertImage("/home/pavel/Flex/src/test/resources/testImgDir/12.04 morning test1.jpeg");

        doc.save("/home/pavel/Flex/src/test/resources/testImgDir/testword.docx");
        builder.insertImage("/home/pavel/Flex/src/test/resources/testImgDir/12.04 morning test1.jpeg");
        doc.save("/home/pavel/Flex/src/test/resources/testImgDir/testword.docx");

        builder.insertImage("/home/pavel/Flex/src/test/resources/testImgDir/12.04 morning test1.jpeg");
        doc.save("/home/pavel/Flex/src/test/resources/testImgDir/testword.docx");

        builder.insertImage("/home/pavel/Flex/src/test/resources/testImgDir/12.04 morning test1.jpeg");
        doc.save("/home/pavel/Flex/src/test/resources/testImgDir/testword.docx");
        builder.insertImage("/home/pavel/Flex/src/test/resources/testImgDir/12.04 morning test1.jpeg");
        doc.save("/home/pavel/Flex/src/test/resources/testImgDir/testword.docx");
        doc.save("/home/pavel/Flex/src/test/resources/testImgDir/testword.docx");
    }

}
