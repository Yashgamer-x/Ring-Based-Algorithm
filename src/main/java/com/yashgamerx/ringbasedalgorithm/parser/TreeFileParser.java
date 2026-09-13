package com.yashgamerx.ringbasedalgorithm.parser;

import com.yashgamerx.ringbasedalgorithm.exceptions.UnknownParsingTechniqueException;
import com.yashgamerx.ringbasedalgorithm.model.TreeNode;

import java.io.File;

public interface TreeFileParser {
    TreeNode parse(File file) throws UnknownParsingTechniqueException;
}
