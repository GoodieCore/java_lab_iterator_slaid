package com.example.java_lab_iterator_slaid;

import javafx.scene.image.Image;
import javafx.stage.FileChooser;
import java.io.File;
import java.util.ArrayList;
import java.util.List;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.util.Duration;

public class IteratorController {
    public ImageView imgView;
    public TextField inputTime;
    Timeline time = new Timeline();
    public ConcreteAggregate concreteAggregate = new ConcreteAggregate("");
    public Iterator iterator = concreteAggregate.getIterator();
    @FXML
    public void onNextButtonClick(){
        imgView.setImage(iterator.next());
    }
    @FXML
    public void onPrevButtonClick(){
        imgView.setImage(iterator.prev());
    }
    @FXML
    public void onChouseButtonClick(){
        FileChooser fileChooser = new FileChooser();
        File file = fileChooser.showOpenDialog(imgView.getScene().getWindow());
        if (file != null) {
            String filename = file.getAbsolutePath();
            Image image = new Image("file:" + filename);
            imgView.setImage(image);
        }
    }

    @FXML
    public void onStartButtonClick(){
        int playtime= Integer.parseInt(inputTime.getText());

        time = new Timeline();
        time.setCycleCount(Timeline.INDEFINITE);
        time.getKeyFrames().add(new KeyFrame(Duration.seconds(playtime), event -> {
            imgView.setImage(iterator.next());
        }));
        time.play();
    }
    public void onStopButtonClick(ActionEvent actionEvent) {
        time.stop();
        time.getKeyFrames().clear();
    }
}