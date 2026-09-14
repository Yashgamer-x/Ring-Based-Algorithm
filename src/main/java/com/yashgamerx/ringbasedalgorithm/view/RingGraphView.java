package com.yashgamerx.ringbasedalgorithm.view;

import com.yashgamerx.ringbasedalgorithm.exceptions.UnknownParsingTechniqueException;
import com.yashgamerx.ringbasedalgorithm.model.RingTreeNode;
import com.yashgamerx.ringbasedalgorithm.parser.RingFileParser;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import java.io.File;
import java.io.IOException;

public class RingGraphView extends Pane {

    private static final int VIRTUAL_CANVAS_SIZE = 8000;
    private final RingTreeNode rootNode;

    public RingGraphView(File file)
            throws UnknownParsingTechniqueException, IOException {
        super();
        setPrefSize(VIRTUAL_CANVAS_SIZE, VIRTUAL_CANVAS_SIZE);
        RingFileParser parser = new RingFileParser();
        rootNode = parser.parse(file);
    }

    public void compute() {
        rootNode.setLayoutX(10);
        rootNode.setLayoutY(10);
    }

    public void draw() {
        drawCircle(rootNode);
        rootNode.getChildren().forEach(this::drawChildren);
    }

    public void drawCircle(RingTreeNode node) {
        var circle = new Circle(
                node.getLayoutX(),
                node.getLayoutY(),
                RingTreeNode.NODE_RADIUS,
                Color.BLACK
        );

        getChildren().add(circle);
    }

    private void drawChildren(RingTreeNode ringTreeNode) {
        drawCircle(ringTreeNode);
        ringTreeNode.getChildren().forEach(this::drawChildren);
    }
}