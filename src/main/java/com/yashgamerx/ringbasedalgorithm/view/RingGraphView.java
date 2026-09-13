package com.yashgamerx.ringbasedalgorithm.view;

import javafx.scene.layout.Pane;

public class RingGraphView extends Pane {

    private static final int VIRTUAL_CANVAS_SIZE = 8000;

    public RingGraphView() {
        super();
        super.setPrefSize(VIRTUAL_CANVAS_SIZE, VIRTUAL_CANVAS_SIZE);
    }
}
