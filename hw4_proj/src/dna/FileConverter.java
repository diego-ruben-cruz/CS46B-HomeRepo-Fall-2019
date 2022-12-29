package dna;

import java.io.*;
import java.util.*;

public class FileConverter {
	private File fastq;
	private File fasta;

	public FileConverter(File gFastq, File gFasta) {
		fastq = gFastq;
		fasta = gFasta;
	}

	//
	// Writes a fasta file consisting of conversion of all records from the fastq
	// with
	// sufficient quality and unique defline.
	//
	public void convert() throws IOException {
		// Build chain of readers.
		FileReader fr = new FileReader(fastq);
		BufferedReader br = new BufferedReader(fr);
		FastqReader fqr = new FastqReader(br);

		// Build chain of writers.
		FileWriter fw = new FileWriter(fasta);
		PrintWriter pw = new PrintWriter(fw);
		FastaWriter faw = new FastaWriter(pw);

		// Read, translate, write.
		ArrayList<FastqRecord> fastQList = new ArrayList<FastqRecord>();
		ArrayList<FastaRecord> fastAList = new ArrayList<FastaRecord>();
		// count was used for testing.
		// int count = 0;
		// A done block was implemented because other attempted methods would involve
		// bad placement of try-catch block.
		boolean done = false;
		while (!done) {
			try {
				// count was incremented here to see the inputs received(both valid and
				// invalid).
				// count++;
				FastqRecord fq = fqr.readRecord();
				if (fq == null) {
					done = true;
					break;
				} else {
					fastQList.add(fq);
				}
			} catch (RecordFormatException e) {
				// System.out.println("Record " + count + " -- " + e.getMessage());
			}
		}
		// The for loop puts the valid inputs and checks their quality. If high, the
		// input would be placed in the fasta arraylist.
		for (FastqRecord ref : fastQList) {
			boolean check = ref.qualityIsLow();
			if (check == false) {
				fastAList.add(new FastaRecord(ref));
			}
		}
		// This writes the fasta records that were placed into the arraylist from the
		// previous for loop.
		for (FastaRecord ref : fastAList) {
			faw.writeRecord(ref);
		}
		// Close fr, br, fw, and pw in reverse order of creation.
		pw.close();
		fw.close();
		br.close();
		fr.close();
	}

	public static void main(String[] args) {
		System.out.println("Starting");
		try {
			File fastq = new File("data/HW4.fastq");
			if (!fastq.exists()) {
				System.out.println("Can't find input file " + fastq.getAbsolutePath());
				System.exit(1);
			}
			File fasta = new File("data/HW4.fasta");
			FileConverter converter = new FileConverter(fastq, fasta);
			converter.convert();
		} catch (IOException x) {
			System.out.println(x.getMessage());
		}
		System.out.println("Done");
	}
}