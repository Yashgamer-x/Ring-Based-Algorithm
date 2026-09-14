package com.yashgamerx.ringbasedalgorithm.parser;

import com.yashgamerx.ringbasedalgorithm.exceptions.UnknownParsingTechniqueException;
import com.yashgamerx.ringbasedalgorithm.model.RingTreeNode;
import lombok.extern.java.Log;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.HashMap;
import java.util.function.Function;

@Log
public class RingFileParser {
    private final HashMap<Integer, RingTreeNode> nodeMap = new HashMap<>();


    public RingTreeNode parse(File file) throws UnknownParsingTechniqueException, IOException {
        try(var bufferedLines = new BufferedReader(Files.newBufferedReader(file.toPath()))) {
            var firstLine = bufferedLines.readLine();
            if(firstLine != null ){
                if (firstLine.equals("Numbered")) {
                    readNumberedFile(bufferedLines);
                } else {
                    throw new UnknownParsingTechniqueException("The following reading technique has not been implemented yet: "+firstLine);
                }
            }
        }
        return nodeMap.get(1);
    }

    /// Reads the lines, separates the parent and child ID, and then links the parent to its children
    private void readNumberedFile(BufferedReader bufferedLines) throws IOException {
        String line;
        while((line = bufferedLines.readLine()) != null) {
            var splitNodes = line.split(" ");
            var parentNodeId = Integer.parseInt(splitNodes[0]);
            var parentNode = nodeMap.computeIfAbsent(parentNodeId, createRingNodeFromParentId());

            for (int i = 1; i < splitNodes.length; i++) {
                var childNodeId = Integer.parseInt(splitNodes[i]);
                nodeMap.computeIfAbsent(childNodeId, createChildNode(parentNode));
            }
        }
    }


    /// Creates a childNode based on provided child ID and links the parent to its child.
    private static Function<Integer, RingTreeNode> createChildNode(RingTreeNode parentTreeNode) {
        return childId -> {
            // Create a new node with the child ID
            var node = new RingTreeNode();
            node.setValue(childId);

            // Link the parent node to the child node.
            // Or, add the child node to the parent node.
            parentTreeNode.getChildren().add(node);

            return node;
        };
    }

    /// Creates the Ring node for the ParentId who does not have a parent.
    /// Usually it is the root node, and is suppose to be root node only.
    private static Function<Integer, RingTreeNode> createRingNodeFromParentId() {
        return parentId -> {
            var node = new RingTreeNode();
            node.setValue(parentId);
            return node;
        };
    }
}
