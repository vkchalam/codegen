package com.nisum.extensions;


public class RestCodeConfig {

	private String[] staticResources;
	private String[] restResources;

	public void setStaticResources(String[] staticResources){
		this.staticResources = staticResources;
	}

	public String[] getStaticResources(){
		return this.staticResources;
	}

	public void setRestResources(String [] restResources){
		this.restResources = restResources;
	}

	public String [] getRestResources(){
		return this.restResources;
	}
}