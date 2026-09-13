package com.yashgamerx.ringbasedalgorithm.algorithm;

import com.yashgamerx.ringbasedalgorithm.model.TreeNode;

public interface Algorithm<T extends TreeNode> {
    void compute(T root);
}
