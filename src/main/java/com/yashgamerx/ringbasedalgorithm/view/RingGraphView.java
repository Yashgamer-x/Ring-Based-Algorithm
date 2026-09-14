package com.yashgamerx.ringbasedalgorithm.view;

import com.yashgamerx.ringbasedalgorithm.exceptions.UnknownParsingTechniqueException;
import com.yashgamerx.ringbasedalgorithm.model.RingTreeNode;
import com.yashgamerx.ringbasedalgorithm.parser.RingFileParser;
import com.yashgamerx.ringbasedalgorithm.parser.TreeFileParser;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import java.io.File;
import java.io.IOException;

public class RingGraphView extends Pane {

    private static final int VIRTUAL_CANVAS_SIZE = 8000;
    private RingTreeNode rootNode;

    private double mouseStartX;
    private double mouseStartY;

    private double translateStartX;
    private double translateStartY;

    public RingGraphView(File file)
            throws UnknownParsingTechniqueException, IOException {

        super();

        setPrefSize(VIRTUAL_CANVAS_SIZE, VIRTUAL_CANVAS_SIZE);

        TreeFileParser<RingTreeNode> parser = new RingFileParser();
        rootNode = parser.parse(file);

        enablePanning();
    }

    private void enablePanning() {
        setOnMousePressed(event -> {
            mouseStartX = event.getSceneX();
            mouseStartY = event.getSceneY();

            translateStartX = getTranslateX();
            translateStartY = getTranslateY();
        });

        setOnMouseDragged(event -> {
            double deltaX = event.getSceneX() - mouseStartX;
            double deltaY = event.getSceneY() - mouseStartY;

            setTranslateX(translateStartX + deltaX);
            setTranslateY(translateStartY + deltaY);
        });
    }

    public void compute() {
        rootNode.setLayoutX(10);
        rootNode.setLayoutY(10);
    }

    public void draw() {
        var circle = new Circle(
                rootNode.getLayoutX(),
                rootNode.getLayoutY(),
                RingTreeNode.NODE_RADIUS,
                Color.BLACK
        );

        getChildren().add(circle);
    }
}