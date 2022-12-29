package dna;

import java.io.*;
import java.util.ArrayList;

//
// Reads lines from a BufferedReader and builds a FastqRecord.
//

public class FastqReader {
	private BufferedReader theBufferedReader;

	public FastqReader(BufferedReader gBufferedReader) {
		theBufferedReader = gBufferedReader;
	}

	// Returns next record in the file, or null if EOF (end-of-file).
	public FastqRecord readRecord() throws IOException, RecordFormatException {
		// linesRead will be the array list of reference to construct a fastq record
		// after verifying that the first line is not null.
		ArrayList<String> linesRead = new ArrayList<String>();
		String line1 = theBufferedReader.readLine();
		if (line1 == null) {
			return null;
		} else {
			// This for loop adds the rest of the lines given that the first line returns
			// something other than null.
			for (int i = 0; i < 3; i++) {
				linesRead.add(theBufferedReader.readLine());
			}
			// line1 is ID, .get(0) is the sequence, .get(2) is the quality.
			return new FastqRecord(line1, linesRead.get(0), linesRead.get(2));
		}
	}
}