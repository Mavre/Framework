package com.epam.reutska.citygame.datasource;

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

public class CityXMLReader implements IReader<String> {
	private String citiesPath;

	public CityXMLReader(String citiesPath) {
		this.citiesPath = citiesPath;
	}

	@Override
	public void write(Set<String> value) throws DataSourceException {
		Element rootElement = new Element("cities");
		Document doc = new Document(rootElement);
		for (String city : value) {
			rootElement.addContent(new Element("city").setText(city));
		}

		Format outFormat = Format.getCompactFormat();
		outFormat.setEncoding(Charset.forName("UTF-8").displayName());

		XMLOutputter outputter = new XMLOutputter(outFormat);
		outputter.setFormat(Format.getPrettyFormat());
		try (OutputStreamWriter out = new OutputStreamWriter(
				new FileOutputStream(citiesPath), "UTF-8")) {
			out.write(outputter.outputString(doc));
		} catch (IOException e) {
			throw new DataSourceException(e);
		}

	}

	@Override
	public Set<String> read() throws DataSourceException {
		Set<String> set = new HashSet<String>();

		Document rDoc = null;
		try {
			SAXBuilder parser = new SAXBuilder();

			Reader in = new InputStreamReader(new FileInputStream(citiesPath),
					"UTF-8");

			rDoc = parser.build(in);
		} catch (JDOMException | IOException e) {
			throw new DataSourceException(e);
		}

		List<Element> temp = rDoc.getRootElement().getChildren();
		for (int i = 0; i < temp.size(); i++) {
			set.add(temp.get(i).getValue());

		}

		return set;
	}

}
