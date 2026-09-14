package com.yashgamerx.ringbasedalgorithm;

import com.yashgamerx.ringbasedalgorithm.exceptions.UnknownParsingTechniqueException;
import com.yashgamerx.ringbasedalgorithm.view.RingGraphView;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ScrollPane;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class RingApp extends Application {
    @Override
    public void start(Stage stage) throws IOException, UnknownParsingTechniqueException {
        var inputFile = new File("src/main/resources/1k_Tree.txt");
        RingGraphView graphView = new RingGraphView(inputFile);
        ScrollPane scrollPane = new ScrollPane(graphView);

        graphView.compute();
        graphView.draw();

        scrollPane.setPannable(true);
        scrollPane.setFitToWidth(false);
        scrollPane.setFitToHeight(false);

        Scene scene = new Scene(scrollPane, 320, 240);
        stage.setTitle("Ring Graph");
        stage.setScene(scene);
        stage.show();
    }
}
