package com.cognizant.bfs.mvp.service;

import java.io.File;
import java.util.HashMap;
import java.util.Map;

import com.cognizant.bfs.mvp.util.GeneratorUtil;

public class DeploymentGenerator implements MvpGenerator {

	String projectName = null;
	String appPort = null;
	File configFile = null;
	Map<String, String> contentMap;

	public DeploymentGenerator(final File configFile, final String projectName, final String appPort) {
		this.projectName = projectName;
		this.appPort = appPort;
		this.configFile = configFile;
		contentMap = new HashMap<>();
	}

	@Override
	public File generate() {
		this.contentMap.put("projectName", projectName);
		this.contentMap.put("appPort", appPort);
		return GeneratorUtil.generatePipelineFile(configFile.getAbsolutePath(), contentMap);
	}

}