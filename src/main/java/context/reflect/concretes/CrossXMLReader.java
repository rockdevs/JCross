package context.reflect.concretes;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * XML must be this format
 * <connector name="postgres">
 *     <databaseName>postgres</databaseName>
 *     <username>jack</username>
 *     <password>31454354</password>
 * </connector>
 */
public class CrossXMLReader {
    private final ConfigurationReflector  reflector;
    private final Map<String,Map<String,String>> properties;
    private final Set<String> resources;


    {
        reflector = new ConfigurationReflector();
        resources = reflector.getJCrossXmlPaths();
        properties = new HashMap<>();
    }

    private void parseResource(String resourcePath) throws IOException, SAXException, ParserConfigurationException {
        File file = new File(resourcePath);
        DocumentBuilderFactory dbf = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = dbf.newDocumentBuilder();
        Document doc = db.parse(file);
        doc.getDocumentElement().normalize();
        NodeList nodeList = doc.getElementsByTagName("connector");
        System.out.println(nodeList.getLength());
        segregateNode(nodeList);
    }

    private void segregateNode(NodeList nodeList){
        Map<String,String> connectionNode;
        for (int itr = 0; itr < nodeList.getLength(); itr++){
            connectionNode = new HashMap<>();
            Node node = nodeList.item(itr);
            if (node.getNodeType() == Node.ELEMENT_NODE)
            {
                Element eElement = (Element) node;
                connectionNode.putIfAbsent(
                        "databaseName",
                        eElement.getElementsByTagName("databaseName").item(0).getTextContent()
                );
                connectionNode.putIfAbsent(
                        "username",
                        eElement.getElementsByTagName("databaseName").item(0).getTextContent()
                );
                connectionNode.putIfAbsent(
                        "password",
                        eElement.getElementsByTagName("databaseName").item(0).getTextContent()
                );
                properties.putIfAbsent(eElement.getAttribute("name"),connectionNode);
            }

        }
    }

    public Map<String,Map<String,String>> render() throws IOException, ParserConfigurationException, SAXException {
        for (String path:resources){
            parseResource(path);
        }
        System.out.println("List "+properties);
        return properties;
    }
}
