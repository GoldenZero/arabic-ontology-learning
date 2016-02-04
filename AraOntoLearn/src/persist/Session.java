package persist;

import java.io.Serializable;

import corpus.Corpus;

import algorithm.AlgorithmController;

import pom.POM;
import pom.POMWrapper;

public class Session implements Serializable {

	AlgorithmController m_controller;
	
	Corpus m_corpus;

	POM m_pom;

	public Session(AlgorithmController controller, POM pom, Corpus corpus) {
		m_controller = controller;
		m_pom = pom;
		m_corpus = corpus;
	}

	public AlgorithmController getAlgorithmController() {
		return m_controller;
	}

	public void setAlgorithmController(AlgorithmController m_controller) {
		this.m_controller = m_controller;
	}

	public POM getPOM() {
		return m_pom;
	}

	public void setPOM(POM m_pom) {
		this.m_pom = m_pom;
	}
	
	public Corpus getCorpus(){
		return m_corpus;
	}
	
	public void setCorpus( Corpus corpus ){
		m_corpus = corpus;
	}
}
