package com.yashgamerx.ringbasedalgorithm.parser;

import com.yashgamerx.ringbasedalgorithm.exceptions.UnknownParsingTechniqueException;

import java.io.File;

public interface FileParser {
    void parse(File file) throws UnknownParsingTechniqueException;
}
