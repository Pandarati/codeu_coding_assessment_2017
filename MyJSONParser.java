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

import java.io.IOException;
import java.util.HashMap;


final class MyJSONParser implements JSONParser {

  @Override
  public JSON parse(String in) throws IOException {
    // TODO: implement this
	
	 // \"name\":{\"first\":\"sam\", \"last\":\"doe\" }
	HashMap hm = new HashMap();
	
	//Find the positions of the parthesis in the 
	int p1 = in.indexOf("\"");
	int p2 = in.indexOf("\"", p1+1);
	
	String objName = in.substring(p1+1,p2);
	
	//Remove Curly Brackets around the entire problem.
	in = in.substring(in.indexOf("{")+1);
	in = in.substring(0, in.length()-1);

	
	//The in put translated to another variable that will be altered.
	String jsonFormat = in;
	
	//Delete what in-between curly-brackets for now. Delete the details of the object just in case there are other objects
	int curlyB1Pos = jsonFormat.indexOf("{");
	int curlyB2Pos = jsonFormat.indexOf("}");
	
	//update the jsonFormat output
	jsonFormat = jsonFormat.substring(0, curlyB1Pos) + jsonFormat.substring(curlyB2Pos+1);
	
	//OUTPUT SHOULD LOOK LIEK THIS: "name":
	//System.out.println("FORMAT TEST INPUT: " + jsonFormat);
	
	
	
		//Check for more object names
		while(jsonFormat.indexOf("{") != -1){
			
			curlyB1Pos = jsonFormat.indexOf("{");
			curlyB2Pos = jsonFormat.indexOf("}");
			jsonFormat = jsonFormat.substring(0, curlyB1Pos) + jsonFormat.substring(curlyB2Pos+1);
			
			//OUTPUT SHOULD LOOK LIEK THIS: "cheese":
			//System.out.println("FORMAT TEST INPUT: " + jsonFormat);
			
		}
		
	//Output
	jsonFormat = jsonFormat.replaceAll("[\" ]", "");
	//System.out.println("REGEX CODIGN BABY: " + jsonFormat);
	
	//There will be an extraneous  ":", so I'm deleting it here
	jsonFormat = jsonFormat.substring(0, jsonFormat.length()-1);
	//System.out.println("REGEX CODIGN BABY #2: " + jsonFormat);
	
	//Split all objects into their own array.
	String[] objectNames = jsonFormat.split(":");
	String[] objContent = new String[objectNames.length];
	
	//Keeping the credibility of the original String given so I can do careful manipulation
	String jsonFormat2 = in;
	
	System.out.println("JONATHAN'S TEST: " + jsonFormat2);
	
	//Add each of the contents to an Array that's index is mirrored with the objectsName
	for(int i = 0; i < objContent.length; i++){
		p1 = jsonFormat2.indexOf("{");
		p2 = jsonFormat2.indexOf("}");
		
		objContent[i] = jsonFormat2.substring(p1+1, p2);
		jsonFormat2 = jsonFormat2.substring(p2+1);
		
	}
	
	for(String x: objContent)
		System.out.println(x);
	
	
	JSON abc = new MyJSON();
	
	
	  
	  
    return abc;
  }
}