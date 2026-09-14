package com.yashgamerx.ringbasedalgorithm.model;

import lombok.Getter;
import lombok.Setter;

@Getter @Setter
public class RingTreeNode extends TreeNode {
    public final static double NODE_RADIUS = 5.0;
    public final static double NODE_DIAMETER = NODE_RADIUS * 2;

    private double layoutX;
    private double layoutY;
}
