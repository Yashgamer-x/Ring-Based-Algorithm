package com.yashgamerx.ringbasedalgorithm.view;

import com.yashgamerx.ringbasedalgorithm.algorithm.RingAlgorithm;
import com.yashgamerx.ringbasedalgorithm.exceptions.UnknownParsingTechniqueException;
import com.yashgamerx.ringbasedalgorithm.model.RingTreeNode;
import com.yashgamerx.ringbasedalgorithm.parser.RingFileParser;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Circle;
import javafx.scene.shape.Line;

import java.io.File;
import java.io.IOException;

public class RingGraphView extends Pane {

    private static final int VIRTUAL_CANVAS_SIZE = 8000;
    private static final Color DEFAULT_COLOR = Color.BLACK;
    private static final Color SELECTED_COLOR = Color.RED;

    private final RingTreeNode rootNode;
    private final NodeInfoPanel infoPanel = new NodeInfoPanel();
    private Circle selectedCircle;

    public RingGraphView(File file)
            throws UnknownParsingTechniqueException, IOException {
        super();
        setPrefSize(VIRTUAL_CANVAS_SIZE, VIRTUAL_CANVAS_SIZE);
        RingFileParser parser = new RingFileParser();
        rootNode = parser.parse(file);

        getChildren().add(infoPanel);

        // Clicking empty canvas space deselects the current node
        setOnMouseClicked(event -> deselect());
    }

    public void compute() {
        new RingAlgorithm().processNode(rootNode);
    }

    public void draw() {
        drawCircle(rootNode);
        rootNode.getChildren().forEach(this::drawChildren);
    }

    private void drawCircle(RingTreeNode node) {
        var circle = new Circle(
                node.getLayoutX(),
                node.getLayoutY(),
                RingTreeNode.NODE_RADIUS,
                DEFAULT_COLOR
        );

        circle.setOnMouseClicked(event -> {
            event.consume(); // prevent bubbling up to the pane's deselect handler
            selectNode(node, circle);
        });

        getChildren().add(circle);
    }

    private void drawLine(RingTreeNode node) {
        var parent = node.getParent();
        if (parent != null) {
            var line = new Line(
                    parent.getLayoutX(),
                    parent.getLayoutY(),
                    node.getLayoutX(),
                    node.getLayoutY()
            );
            getChildren().add(line);
        }
    }

    private void drawChildren(RingTreeNode ringTreeNode) {
        drawCircle(ringTreeNode);
        drawLine(ringTreeNode);
        ringTreeNode.getChildren().forEach(this::drawChildren);
    }

    private void selectNode(RingTreeNode node, Circle circle) {
        deselect();

        circle.setFill(SELECTED_COLOR);
        selectedCircle = circle;

        infoPanel.setLayoutX(node.getLayoutX() + RingTreeNode.NODE_RADIUS + 8);
        infoPanel.setLayoutY(node.getLayoutY() - 10);
        infoPanel.show(node);
        infoPanel.toFront();
    }

    private void deselect() {
        if (selectedCircle != null) {
            selectedCircle.setFill(DEFAULT_COLOR);
            selectedCircle = null;
        }
        infoPanel.hide();
    }
}