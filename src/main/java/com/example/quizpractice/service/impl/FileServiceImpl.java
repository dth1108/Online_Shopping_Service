package com.example.quizpractice.service.impl;

import com.example.quizpractice.service.IFileService;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;
import org.springframework.core.io.ClassPathResource;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.context.annotation.RequestScope;

@Service
@Transactional
@RequestScope
public class FileServiceImpl implements IFileService {

    @Override
    public void writeFile(String path, String context) {

//            File file = new ClassPathResource(path + ".txt").getFile();
//            if (!file.exists()) {
//                file.createNewFile();
//            }
//            FileWriter fw = new FileWriter(file.getAbsoluteFile());
//            BufferedWriter bw = new BufferedWriter(fw);
//            bw.write(context);
//            bw.close();
//            File convertFile = new File("/src/main/java/com/example/quizpractice/image"+"aaaa.txt");
//            convertFile.createNewFile();
//            FileOutputStream fout = new FileOutputStream(convertFile);
//            fout.write("sssss");
//            fout.close();
//            return "File is upload successfully";
//            System.out.println("check");
//            File file = new File("/src/main/java/com/example/quizpractice/image"+"aaaa.txt");
//            Scanner sc = new Scanner(file);
//            FileWriter writer = new FileWriter(
//                    "D:\\quizPractice\\src\\main\\java\\com\\example\\quizpractice\\image" + "aaaa.txt");
//            writer.write("context");
//            writer.close();
//            System.out.println("check");

        try {
            File myObj = new File(
                    "D:\\quizPractice\\src\\main\\java\\com\\example\\quizpractice\\image"
                            + "aaaa.txt");
            myObj.createNewFile();

        } catch (IOException e) {
            System.out.println("An error occurred.");
            e.printStackTrace();
        }

    }

    @Override
    public void readFile(String path) {

    }
}
