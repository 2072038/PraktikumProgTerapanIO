package com.pterapan.demoio;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.FileChooser;

import java.io.*;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class HelloController {
    public Label label1;
    public TextArea text1;

    public void openFile(ActionEvent actionEvent) {
        FileChooser chooser = new FileChooser();
        File f = chooser.showOpenDialog(text1.getScene().getWindow());
        Path p = Paths.get(f.toURI());
        try {
            String baru = "";
            for (String something : Files.readAllLines(p)) {
                baru += something + "\n";
            }
            text1.setText(baru);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    public void saveAsFile(ActionEvent actionEvent) {
        FileChooser chooser = new FileChooser();
        File f = chooser.showSaveDialog(text1.getScene().getWindow());
        try {
            String hasil = text1.getText();
            Files.write(f.toPath(), hasil.getBytes());
        }
        catch(IOException e) {
            e.printStackTrace();
        }
    }

    public void saveFile(ActionEvent actionEvent) {
        FileChooser chooser = new FileChooser();
        File f = new File(text1.getText());
        try {
            FileWriter writer = new FileWriter(f.getAbsoluteFile().getName(), true);
            writer.write(text1.getText());
            writer.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}


//        FileChooser chooser = new FileChooser();
//        File f = chooser.showOpenDialog(text1.getScene().getWindow());
//        Path p = Paths.get(f.toURI());
//
//        FileChooser chooser = new FileChooser();
//        File file = openFile(Paths.get());
//
//        if (file != null) {
//            saveTextToFile(sampleText, file);
//        }

//        Path file = Paths.get(text1.getText());
//        if(!Files.exists(file)) {
//            try {
//                Files.createFile(file.toAbsolutePath());
//                //...
//            } catch (IOException e) {
//                e.printStackTrace();
//            }
//        }

//        FileChooser chooser = new FileChooser();
//        File f = chooser.showSaveDialog();
//        try {
//            String hasil = text1.getText();
//            Files.write(f.toPath(), hasil.getBytes());
//        }
//        catch(IOException e) {
//            e.printStackTrace();
//        }


//        FileChooser chooser = new FileChooser();
//        File f = chooser.showSaveDialog(null);
//
//        if(f != null){
//            copy(f.getAbsolutePath());
//        }

//        String fileName = f.getName();
//        Path p = Paths.get(f.toURI());
//        Files.copy(selectedFile.toPath(), target);

//        FileChooser chooser = new FileChooser();
//        File f = chooser.(text1.getScene().getWindow());
//        try {
//            String hasil = text1.getText();
//            Files.write(f.toPath(), hasil.getBytes());
//        }
//        catch(IOException e) {
//            e.printStackTrace();
//        }

//        try {
//            PrintWriter writer;
//            writer = new PrintWriter(file);
//            writer.println(content);
//            writer.close();
//        } catch (IOException ex) {
//            Logger.getLogger(saveFile().class.getName()).log(Level.SEVERE, null, ex);
//        }

//    public void copy(String path) {
//        FileReader fr = null;
//        FileWriter fw = null;
//        try {
//            fr = new FileReader(path);
//            fw = new FileWriter(path);
//            int c = fr.read();
//            while(c!=-1) {
//                fw.write(c);
//                c = fr.read();
//            }
//        } catch (FileNotFoundException e) {
//            throw new RuntimeException(e);
//        } catch (IOException e) {
//            throw new RuntimeException(e);
//        } finally {
//            close(fr);
//            close(fw);
//        }
//    }
//
//    public static void close(Closeable stream) {
//        if (stream != null) {
//            try {
//                stream.close();
//            } catch (IOException e) {
//                throw new RuntimeException(e);
//            }
//        }
//    }