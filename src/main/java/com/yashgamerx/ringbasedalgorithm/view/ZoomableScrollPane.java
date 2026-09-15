package com.yashgamerx.ringbasedalgorithm.view;

import javafx.scene.Node;
import javafx.scene.control.ScrollPane;
import javafx.scene.input.ScrollEvent;

/**
 * A ScrollPane that supports Ctrl+scroll zooming on its content.
 * Zoom is anchor-free (scales from center); simple, predictable, low-maintenance.
 */
public class ZoomableScrollPane extends ScrollPane {

    private static final double MIN_SCALE = 0.05;
    private static final double MAX_SCALE = 4.0;
    private static final double ZOOM_STEP = 0.1;

    private final Node content;
    private double scale = 1.0;

    public ZoomableScrollPane(Node content) {
        super(content);
        this.content = content;

        setPannable(true);
        setFitToWidth(false);
        setFitToHeight(false);

        addEventFilter(ScrollEvent.SCROLL, this::onScroll);
    }

    private void onScroll(ScrollEvent event) {
        if (!event.isControlDown()) return;
        event.consume();

        double delta = event.getDeltaY() > 0 ? ZOOM_STEP : -ZOOM_STEP;
        setScale(scale + delta);
    }

    public void setScale(double newScale) {
        scale = clamp(newScale, MIN_SCALE, MAX_SCALE);
        content.setScaleX(scale);
        content.setScaleY(scale);
    }

    public double getScale() {
        return scale;
    }

    private static double clamp(double value, double min, double max) {
        return Math.max(min, Math.min(max, value));
    }
}