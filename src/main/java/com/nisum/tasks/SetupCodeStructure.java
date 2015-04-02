package com.nisum.tasks;

import org.gradle.api.DefaultTask;
import org.gradle.api.tasks.TaskAction;
import com.nisum.extensions.RestCodeConfig;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class SetupCodeStructure extends DefaultTask
{

    @TaskAction
    public void generateWarCodeStructure() {
        RestCodeConfig restCodeConfig = getProject().getExtensions().findByType(RestCodeConfig.class);
        if (restCodeConfig!=null){

			for (String staticResource : restCodeConfig.getStaticResources()){
				createFile("WebContent/"+staticResource);
			}        	

			for (String restResource : restCodeConfig.getRestResources()){
				createFile("src/main/java/"+restResource.replace(".","/")+".java");
				createFile("src/test/java/"+restResource.replace(".","/")+"Test.java");	
			}

        }

    }

    private void createFolder(String folderName) {
    	try{
    		Files.createDirectory(Paths.get(folderName));
    	} catch (java.io.IOException ex){
    		System.out.println("Could not create directory\n"+ex);	
    	}
    }

    private void createFile(String fileName){
    	try{
    		Files.createDirectories(Paths.get(fileName).getParent());
    		Files.createFile(Paths.get(fileName));
    	} catch(java.io.IOException ex){
			System.out.println("Could not create file\n"+ex);	
    	}
    }

}