package lab5;

import java.io.*;
import java.util.*;

public class Lister {
	private File file;

	public Lister(File file) {
		this.file = file;
	}

	public void list() {
		listRecurse(file, "");
	}

	private void listRecurse(File f, String indent) {
		if (f.isFile()) {
			System.out.println(indent + f.getName());
			// Print the indent, followed by the file's name. Use
			// the getName() method of class File.
		} else {
			// f isn't a file, so it must be a directory. Print the indent,
			// followed by the directory's name. Then add 2 spaces to the
			// indent string and recursively list the contents of the directory.
			System.out.println(indent + f.getAbsolutePath());
			indent = indent + "  ";
			for (String contentName : f.list()) {
				// Create a File object representing the file in directory f
				// whose name is contentName.
				File contentFile = new File(f, contentName);// ???
				// call listRecurse with the content file and the wider indent string
				listRecurse(contentFile, indent);
			}
		}
	}

	public static void main(String[] args) {
		File f = new File(".");
		Lister lister = new Lister(f);
		lister.list();
	}
}
