 package dna;

import java.io.*;

//
// Writes a FastaRecord to the command line.
//

public class FastaWriter {
	private PrintWriter thePrintWriter;

	// Constructs an object and initializes the instance var given an argument.
	public FastaWriter(PrintWriter gPrintWriter) {
		thePrintWriter = gPrintWriter;
	}

	// writes the record in the correct format, given a FastaRecord.
	public void writeRecord(FastaRecord rec) throws IOException {
		thePrintWriter.println(rec.getDefline());
		thePrintWriter.println(rec.getSequence());
	}
}
