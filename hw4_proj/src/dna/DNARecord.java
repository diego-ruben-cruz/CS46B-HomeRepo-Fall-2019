package dna;

// An interface which helps with conversion from fastq to fasta.
public interface DNARecord 
{
	String		getDefline();
	String		getSequence();
}