package im.huahang.rsslinkextractor;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.InputStream;

/**
 * @author huahang
 */
public class App {
    public static void main( String[] args ) throws Exception {
        String[] tags = {"ed2k", "magnet"};
        ClassLoader loader = App.class.getClassLoader();
        try (InputStream is = loader.getResourceAsStream("topgear.xml")) {
            DocumentBuilderFactory factory =
                DocumentBuilderFactory.newInstance();
            DocumentBuilder builder = factory.newDocumentBuilder();
            Document doc = builder.parse(is);
            for (String tag : tags) {
                NodeList nodeList = doc.getElementsByTagName(tag);
                int length = nodeList.getLength();
                for (int i = 0; i < length; ++i) {
                    Node node = nodeList.item(i);
                    String text = node.getTextContent();
                    System.out.println(text);
                }
            }
        }
    }
}
