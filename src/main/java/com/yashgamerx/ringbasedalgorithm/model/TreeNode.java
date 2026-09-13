package com.yashgamerx.ringbasedalgorithm.model;

import lombok.Getter;
import lombok.Setter;

import java.util.ArrayList;
import java.util.List;

@Getter @Setter
public class TreeNode {
    private int value;
    private final List<TreeNode> children = new ArrayList<>();
}
