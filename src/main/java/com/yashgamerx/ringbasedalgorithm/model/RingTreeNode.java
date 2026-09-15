package com.yashgamerx.ringbasedalgorithm.model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter @Setter
public class RingTreeNode {
    public final static double NODE_RADIUS = 5.0;
    public final static double NODE_DIAMETER = NODE_RADIUS * 2;

    private double layoutX;
    private double layoutY;
    private double theta;
    private double radius;

    private int id;
    private RingTreeNode parent;
    private final List<RingTreeNode> children = new ArrayList<>();

    public void translate(double r, double theta) {
        var x = r * Math.cos(theta);
        var y = r * Math.sin(theta);
        this.layoutX += x;
        this.layoutY += y;
    }

    public void translateFromParent(double r, double theta) {
        var x = r * Math.cos(theta);
        var y = r * Math.sin(theta);
        this.layoutX = parent.layoutX + x;
        this.layoutY = parent.layoutY + y;
    }

    public void translateFromParentBasedOnImplicitlyProvidedTheta(double r) {
        var x = r * Math.cos(theta);
        var y = r * Math.sin(theta);
        this.layoutX = parent.layoutX + x;
        this.layoutY = parent.layoutY + y;
    }

}
