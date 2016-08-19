package br.ufc.storm.xml;

import java.io.BufferedReader;
import java.io.File;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.StringReader;
import java.io.StringWriter;
import java.net.MalformedURLException;
import java.net.URL;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBElement;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.jdom2.Attribute;
import org.jdom2.output.Format;
import org.jdom2.output.XMLOutputter;
import org.w3c.dom.Document;
import org.xml.sax.InputSource;
import org.xml.sax.SAXException;

import br.ufc.storm.jaxb.AbstractComponentType;
import br.ufc.storm.jaxb.AbstractUnitType;
import br.ufc.storm.jaxb.CalculatedFunctionType;
import br.ufc.storm.jaxb.CandidateListType;
import br.ufc.storm.jaxb.ComputationalSystemType;
import br.ufc.storm.jaxb.ConcreteUnitType;
import br.ufc.storm.jaxb.ContextContract;
import br.ufc.storm.jaxb.ContextParameterType;
import br.ufc.storm.jaxb.ContractList;
import br.ufc.storm.jaxb.ObjectFactory;
import br.ufc.storm.jaxb.UnitFileType;


public class XMLHandler {
	static DocumentBuilderFactory dbf;
	static DocumentBuilder db = null;
	static Document doc = null;
	static URL url;

	/**
	 * This method open a xml file
	 * @param file XML file URL or content
	 * @return XML document opened
	 */
	public static Document openXMLFile(String file){

		dbf = DocumentBuilderFactory.newInstance();
		try {
			db = dbf.newDocumentBuilder();
		} catch (ParserConfigurationException e1) {
			e1.printStackTrace();
		}
		InputSource inStream = new InputSource(); 
		try {
			url = new URL(file);
			BufferedReader in = new BufferedReader(new InputStreamReader(url.openStream()));
			StringBuilder out = new StringBuilder();
			String newLine = System.getProperty("line.separator");
			String line;
			while ((line = in.readLine()) != null) {
				out.append(line);
				out.append(newLine);
			}
			file = out.toString();
			in.close();
		} catch (MalformedURLException e) {
			//Not an error
			//This exception is purposely left in blank, because always when enter in this method, 
			//the file name can be a url or a file content as string
		} catch (IOException e) {
			e.printStackTrace();
		}
		inStream.setCharacterStream(new StringReader(file)); 
		try {
			doc = db.parse(inStream);
		} catch (SAXException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return doc;
	}


	public static CandidateListType getCandidateList(String file) throws Exception{
			CandidateListType cl = new CandidateListType();
			JAXBContext context;
			try {
				context = JAXBContext.newInstance(br.ufc.storm.jaxb.ObjectFactory.class.getPackage().getName(),
						br.ufc.storm.jaxb.ObjectFactory.class.getClassLoader());
				Unmarshaller unmarshaller = context.createUnmarshaller();
				@SuppressWarnings("unchecked")
				JAXBElement<CandidateListType> element = (JAXBElement<CandidateListType>) unmarshaller.unmarshal(new InputSource(new java.io.StringReader(file)));
				cl=element.getValue();
			} catch (Exception e) {
				e.printStackTrace();
			}
			return cl;
	}
}