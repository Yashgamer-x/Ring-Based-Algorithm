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
    private double radius;

    private int value;
    private final List<RingTreeNode> children = new ArrayList<>();
}
