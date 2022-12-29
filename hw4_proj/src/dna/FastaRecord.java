package dna;

public class FastaRecord implements DNARecord {
	private String defline;
	private String sequence;

	// Constructs an object based on two arguments, if the defline is not formatted
	// correctly, it will throw an exception.
	public FastaRecord(String defline, String sequence) throws RecordFormatException {
		if (defline.substring(0, 1) == ">") {
			this.defline = defline;
			this.sequence = sequence;
		} else {
			throw new RecordFormatException(
					"Error: " + ">" + "expected as first character, " + defline.substring(0, 1) + " received.");
		}
	}

	// Makes a fasta record out of a fastq record, replacing the first character to
	// follow fasta conventions.
	public FastaRecord(FastqRecord fastqRec) {
		this.defline = fastqRec.getDefline().replace("@", ">");
		this.sequence = fastqRec.getSequence();

	}

	// Returns the defline of the object.
	public String getDefline() {
		return this.defline;
	}

	// Returns the sequence of the object.
	public String getSequence() {
		return this.sequence;
	}

	// Compares the two objects for deep equality.
	public boolean equals(FastaRecord other) {
		return this.defline.equals(other.defline) && this.sequence.equals(other.sequence);
	}

	// Computes the sum of the hashcodes of the instance vars.
	public int hashCode() {
		return this.defline.hashCode() + this.sequence.hashCode();
	}
}