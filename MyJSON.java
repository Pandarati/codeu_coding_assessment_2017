// Copyright 2017 Google Inc.
//
// Licensed under the Apache License, Version 2.0 (the "License");
// you may not use this file except in compliance with the License.
// You may obtain a copy of the License at
//
//    http://www.apache.org/licenses/LICENSE-2.0
//
// Unless required by applicable law or agreed to in writing, software
// distributed under the License is distributed on an "AS IS" BASIS,
// WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
// See the License for the specific language governing permissions and
// limitations under the License.

package com.google.codeu.codingchallenge;

import java.util.Collection;

final class MyJSON implements JSON  {

	//Instance variables
	private String[] objNames, objContent;
	public String objectData;
	MyJSON(){
		
	}
	
	MyJSON(String objectData){
		this.objectData = objectData;
	}
	
	MyJSON(String[]objNames, String[] objConent){
		this.objNames = this.objNames;
		this.objContent = this.objContent;
	}

	
  @Override
  public JSON getObject(String name) {
    // TODO: implement this
	  
	  
	  for(String content : objContent){
		  //Checks to see if we have a nested class
		  if(content.contains(name) && content.contains("{")){
			  return new MyJSON(content.substring(content.indexOf("{"+1)));
		  }
		 
	  }
	  

	
    return null;
  }

  @Override
  public JSON setObject(String name, JSON value) {
	 int pos = 0;
	  for(String content : objContent){
		  //Checks to see if we have a nested class
		  if(content.contains(name) && content.contains("{")){
			  String objData = content.substring(0, content.indexOf("{"));
			  objData = objData.concat(value.getString(name));
			  objData = objData + content.substring(content.indexOf(":")+1);
			  this.objContent[pos] = objData;
			  
			  break;
		  }
		  
		pos++;
	  }
	  
	  
    return this;
  }

  @Override
  public String getString(String name) {
    
	  for(String content : objContent){
			System.out.println(content);
		}
	  
	  
    return null;
  }

  @Override
  public JSON setString(String name, String value) {
    // TODO: implement this
	  
	  for(String content : objContent){
		  //Checks to see if we have a nested class
		  if(content.contains(name) && content.contains("{")){
			  String objData = content.substring(0, content.indexOf("{"));
			  objData = objData.concat(value);
			  objData = objData + content.substring(content.indexOf(":")+1);
			  
			  
			  break;
		  }
		  
		
	  }
	  
	  
	  
    return this;
  }

  @Override
  public void getObjects(Collection<String> names) {
	
	//Prints out all object names to the user
	for(String name : objNames){
		System.out.println(name);
	}
	
  }

  @Override
  public void getStrings(Collection<String> names) {
    // TODO: implement this
	  
	//Prints out the string values of the objects
	for(String content : objContent){
		System.out.println(content);
	}
  }
  
}