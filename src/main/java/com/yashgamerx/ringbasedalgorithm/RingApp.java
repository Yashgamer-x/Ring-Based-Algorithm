package com.yashgamerx.ringbasedalgorithm;

import com.yashgamerx.ringbasedalgorithm.exceptions.UnknownParsingTechniqueException;
import com.yashgamerx.ringbasedalgorithm.view.RingGraphView;
import com.yashgamerx.ringbasedalgorithm.view.ZoomableScrollPane;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.File;
import java.io.IOException;

public class RingApp extends Application {
    @Override
    public void start(Stage stage) throws IOException, UnknownParsingTechniqueException {
        var inputFile = new File("src/main/resources/1k_Tree.txt");
        RingGraphView graphView = new RingGraphView(inputFile);

        graphView.compute();
        graphView.draw();

        ZoomableScrollPane scrollPane = new ZoomableScrollPane(graphView);

        Scene scene = new Scene(scrollPane, 320, 240);
        stage.setTitle("Ring Graph");
        stage.setScene(scene);
        stage.show();
    }
}
