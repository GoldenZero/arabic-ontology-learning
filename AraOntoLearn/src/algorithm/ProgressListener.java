package algorithm;


public interface ProgressListener {

	public void progressChanged( String sAlgorithm, int iAlgorithm, int iAll );
}