package dna;

//

// FastqRecord contains the defline, sequence, and quality string
// from a record in a fastq file.
//

public class FastqRecord implements DNARecord {
	private String defline;
	private String sequence;
	private String quality;

	// Constructs a FastqRecord given three strings. If the defline is not formatted
	// correctly, then it will throw an exception.
	public FastqRecord(String defline, String sequence, String quality) throws RecordFormatException {
		this.defline = defline;
		this.sequence = sequence;
		this.quality = quality;
		// The if verifies if the first character is an "@" and throws an exception
		// otherwise
		if (!this.defline.substring(0, 1).equals("@")) {
			throw new RecordFormatException("Error: " + "@ " + "expected as first character, got " + defline.charAt(0));

		}
	}

	// returns the defline of the object.
	public String getDefline() {
		return this.defline;
	}

	// returns the sequence of the object
	public String getSequence() {
		return this.sequence;
	}
 
	// Evaluates deep equality of the objects being compared.
	public boolean equals(FastqRecord other) {
		return this.defline.equals(other.defline) && this.sequence.equals(other.sequence)
				&& this.quality.equals(other.quality);
	}

	// Checks the quality of the object. Returns true if low, returns false
	// otherwise.
	public boolean qualityIsLow() {
		if (this.quality.contains("#") && this.quality.contains("$")) {
			return true;
		} else {
			return false;
		}
	}

	// Computes the sum of the hashcodes of the instance vars.
	public int hashCode() {
		return this.defline.hashCode() + this.quality.hashCode() + this.sequence.hashCode();
	}
}