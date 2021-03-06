package Parser;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class Printer {
	public static void createXMLFile(modelXML.XMLModel container) {
		try {
			FileWriter file = new FileWriter("test.xml");
			BufferedWriter buffer = new BufferedWriter(file);
			String str = container.getHeader() + "\n";
			if (str.charAt(1) != '?')
				str = "";
			str += printModel(container.getRoot(), 0);
			buffer.write(str);
			buffer.close();
		} catch (IOException e1) {
			e1.printStackTrace();
		}
	}

	private static String printModel(modelXML.Node node, int count) {
		if (node.getName() == null)
			return "";

		StringBuilder content = new StringBuilder();
		// Spaces
		String spaces = "";
		for (int i = 0; i < count; i++)
			spaces += " ";
		// StartTag
		content.append(String.format(spaces + "<%s", node.getName()));
		for (var attr : node.getAttributes()) {
			content.append(String.format(" %s=\"%s\"", attr.getName(), attr.getValue()));
		}
		if (node.getChildren().isEmpty()) {
			if (node.getValue().getText().isEmpty()) {
				content.append("/>\n");
			} else {
				content.append(">\n" + spaces + " " + node.getValue().getText() + "\n");
				content.append(String.format(spaces + "</%s>\n", node.getName()));
			}
		} else {
			content.append(">\n");
			// Children
			for (var child : node.getChildren()) {
				content.append(printModel(child, count + 1));
			}

			// CloseTag
			content.append(String.format(spaces + "</%s>\n", node.getName()));
		}
		return content.toString();
	}
}
