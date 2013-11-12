package com.epam.reutska.helpers.core;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.io.Reader;
import java.nio.charset.Charset;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.jdom2.Document;
import org.jdom2.Element;
import org.jdom2.JDOMException;
import org.jdom2.input.SAXBuilder;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;

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

			Reader in = new InputStreamReader(new FileInputStream(filePath),
					"UTF-8");

			rDoc = parser.build(in);
		} catch (JDOMException | IOException e) {
			throw new IOException(e);
		}
	Element page=	rDoc.getRootElement().getChildren("page").get(sheetNumber); 
	int rowNumber=page.getChildren("line").size();
	int colNumber=page.getChildren("data").size();
	array= new Object[rowNumber][colNumber];
		for (int i = 0; i < array.length; i++) {
			for (int j = 0; j < array[i].length; j++) {
				
				array[i][j]=rDoc.getRootElement().getChildren().get(i).getChildren().get(j).getText();
			}

		}

		return array;
		
	}

}
