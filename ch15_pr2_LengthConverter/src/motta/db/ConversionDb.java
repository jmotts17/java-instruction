package motta.db;

import java.util.ArrayList;
import java.util.List;

import motta.business.Conversion;

public class ConversionDb {

	// Fields
	private List<Conversion> conversion;

	// Constructors
	public ConversionDb() {
		conversion = new ArrayList<>();
	}

	public ConversionDb(List<Conversion> conversion) {
		this.conversion = conversion;
	}

//	// Helper methods
//	public ArrayList<Conversion> getConverions() {
//
//	}
//
//	public boolean saveConversions(ArrayList<Conversion> typeList) {
//
//	}

}
