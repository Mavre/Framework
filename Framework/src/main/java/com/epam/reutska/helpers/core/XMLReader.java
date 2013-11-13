package com.epam.reutska.helpers.core;

import java.io.BufferedReader;
import java.io.CharArrayReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;

public class XMLReader implements IReader{
	
	private String filePath;

	public XMLReader(String filePath) {
		this.filePath = filePath;
	}
	




	@Override
	public Object[][] read(int sheetNumber) throws IOException {
		Object [][]array = null;
		 Document rDoc = null;
		  try {
		   SAXBuilder parser = new SAXBuilder();

		   StringBuilder sb = new StringBuilder();
		   
		   try(BufferedReader is = new BufferedReader(new InputStreamReader(new FileInputStream(filePath)))){
		    String line;
		    while ((line = is.readLine()) != null){
		     sb.append(line);
		    }
		   }
		   
		   String xml = sb.toString();
		   Matcher junkMatcher = (Pattern.compile("^([\\W]+)<"))
		                             .matcher( xml.trim() );
		   xml = junkMatcher.replaceFirst("<");
		   
		   rDoc = parser.build(new CharArrayReader(xml.toCharArray()));
		  } catch (JDOMException | IOException e) {
		   throw new IOException(e);
		  }

	Element page=	rDoc.getRootElement().getChildren("page").get(sheetNumber); 
	int rowNumber=page.getChildren("line").size();
	int colNumber=page.getChildren("line").get(0).getChildren("data").size();
	array= new Object[rowNumber][colNumber];
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				
				page.getChildren().get(i).getChildren().get(j).getText();
			}

		}

		return array;
		
		
		
		
		
		
		
		
		
		
		
		
		
		
	}

}
