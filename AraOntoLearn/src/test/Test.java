package test;

import gate.Gate;
import gate.util.GateException;

import java.io.File;

import util.Settings;

import linguistic.LinguisticPreprocessor;

public class Test {

	public static void main(String[] args) {
		LinguisticPreprocessor pro=new LinguisticPreprocessor();
		try {
			System.setProperty("gate.plugins.home", "E:/newfolder/gate/gate-5.0-beta1-build3048-ALL/plugins");
			Settings.load();
			pro.init();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}

}
