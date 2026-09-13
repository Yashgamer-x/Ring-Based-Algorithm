package com.yashgamerx.ringbasedalgorithm.view;

import com.yashgamerx.ringbasedalgorithm.exceptions.UnknownParsingTechniqueException;
import com.yashgamerx.ringbasedalgorithm.model.TreeNode;
import com.yashgamerx.ringbasedalgorithm.parser.RingFileParser;
import com.yashgamerx.ringbasedalgorithm.parser.TreeFileParser;
import javafx.scene.layout.Pane;
import java.io.File;
import java.io.IOException;

public class RingGraphView extends Pane {

    private static final int VIRTUAL_CANVAS_SIZE = 8000;
    private final TreeFileParser parser = new RingFileParser();
    private TreeNode rootNode;

    public RingGraphView(File file) throws UnknownParsingTechniqueException, IOException {
        super();
        super.setPrefSize(VIRTUAL_CANVAS_SIZE, VIRTUAL_CANVAS_SIZE);
        rootNode = parser.parse(file);
    }

    public void compute() {
    }
}
