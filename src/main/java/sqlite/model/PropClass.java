package sqlite.model;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class PropClass {

	String connProperty = null;

	public void getProperies() {
		File file = new File("properties.xml");

		try (InputStream is = new FileInputStream(file)) {

			Properties theProperties = new Properties();
			theProperties.loadFromXML(is);
			connProperty = theProperties.getProperty("connection");

		} catch (IOException e) {
			System.out.println("IO Error: " + e.getMessage());
		}
	}

	public String getConn() {
		return connProperty;
	}
}
