package com.yashgamerx.ringbasedalgorithm.parser;

import com.yashgamerx.ringbasedalgorithm.exceptions.UnknownParsingTechniqueException;
import com.yashgamerx.ringbasedalgorithm.model.TreeNode;

import java.io.File;
import java.io.IOException;

public interface TreeFileParser {
    TreeNode parse(File file) throws UnknownParsingTechniqueException, IOException;
}
