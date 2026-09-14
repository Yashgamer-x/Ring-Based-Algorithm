package com.yashgamerx.ringbasedalgorithm.algorithm;

import com.yashgamerx.ringbasedalgorithm.model.RingTreeNode;

public class RingAlgorithm {

    public void processNode(RingTreeNode rootNode) {
        preComputeRoot(rootNode);
    }

    private void preComputeRoot(RingTreeNode rootNode) {
        rootNode.getChildren().forEach(this::preCompute);
        var childrenCount = rootNode.getChildren().size();
        var maxRadiusNode = rootNode.getChildren().stream()
                .max(this::compareNodes);
        var stepAngle = step360AngleBasedOnChildren(childrenCount);

    }

    private int compareNodes(RingTreeNode ringTreeNode, RingTreeNode ringTreeNode1) {
        return Double.compare(ringTreeNode.getRadius(), ringTreeNode1.getRadius());
    }

    private void preCompute(RingTreeNode node) {
        if (node.getChildren().isEmpty()){
            setDefaultValues(node);
            return;
        }

        // All the children + 1 for the parent node too because the
        var childrenCount = node.getChildren().size() + 1;

    }

    private void setDefaultValues(RingTreeNode node){
        node.setRadius(RingTreeNode.NODE_RADIUS);
    }

    private double step360AngleBasedOnChildren(int children) {
        return Math.PI * 2 / children;
    }

}
