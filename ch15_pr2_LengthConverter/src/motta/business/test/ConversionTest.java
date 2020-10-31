package motta.business.test;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import motta.business.Conversion;

class ConversionTest {

	@Test
	void testMilesToFeet() {
		Conversion conversion = new Conversion("Miles", 1.0, "Feet", 5280);
		Assertions.assertEquals(5280, conversion.getToValue());
	}

}
