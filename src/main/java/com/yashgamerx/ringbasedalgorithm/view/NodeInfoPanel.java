package com.yashgamerx.ringbasedalgorithm.view;

import com.yashgamerx.ringbasedalgorithm.model.RingTreeNode;
import javafx.geometry.Insets;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundFill;
import javafx.scene.layout.CornerRadii;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Priority;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;

/**
 * Small overlay panel that displays the fields of a selected RingTreeNode.
 */
public class NodeInfoPanel extends VBox {

    private final Label idLabel = new Label();
    private final Label xLabel = new Label();
    private final Label yLabel = new Label();
    private final Label thetaLabel = new Label();
    private final Label radiusLabel = new Label();
    private final Label childCountLabel = new Label();
    private final Label parentIdLabel = new Label();

    public NodeInfoPanel() {
        setSpacing(4);
        setPadding(new Insets(10));
        setBackground(new Background(new BackgroundFill(
                Color.WHITE, new CornerRadii(4), Insets.EMPTY)));
        setStyle("-fx-border-color: #999; -fx-border-width: 1;");

        var titleLabel = new Label("Node Info");
        titleLabel.setStyle("-fx-font-weight: bold;");

        var spacer = new HBox();
        HBox.setHgrow(spacer, Priority.ALWAYS);

        var closeButton = new Button("\u00D7");
        closeButton.setStyle("-fx-font-size: 12px; -fx-padding: 0 6 0 6;");
        closeButton.setOnAction(event -> hide());

        var header = new HBox(titleLabel, spacer, closeButton);

        getChildren().addAll(header, idLabel, xLabel, yLabel, thetaLabel,
                radiusLabel, childCountLabel, parentIdLabel);

        setVisible(false);
        setManaged(false); // don't affect layout of siblings when hidden
    }

    public void show(RingTreeNode node) {
        idLabel.setText("ID: " + node.getId());
        xLabel.setText(String.format("X: %.2f", node.getLayoutX()));
        yLabel.setText(String.format("Y: %.2f", node.getLayoutY()));
        thetaLabel.setText(String.format("Theta: %.4f rad", node.getTheta()));
        radiusLabel.setText(String.format("Radius: %.2f", node.getRadius()));
        childCountLabel.setText("Children: " + node.getChildren().size());
        parentIdLabel.setText("Parent ID: " +
                (node.getParent() != null ? node.getParent().getId() : "none"));

        setVisible(true);
        setManaged(true);
    }

    public void hide() {
        setVisible(false);
        setManaged(false);
    }
}