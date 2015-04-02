package com.nisum.plugins;

import org.gradle.api.Plugin;
import org.gradle.api.Project;

public class CodeGen implements Plugin<Project>{
	
	public void apply(Project project){
		project.getTasks().create("codeSetup",com.nisum.tasks.SetupCodeStructure.class);
		project.getExtensions().create("restCodeConfig", com.nisum.extensions.RestCodeConfig.class);
	}
}