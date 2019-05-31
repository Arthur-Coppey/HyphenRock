package model;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

import model.element.Diamond;

public class DiamondTest {
	private final Diamond tester;

	public DiamondTest() throws IOException {
		this.tester = new Diamond(1, 1);
	}

	@Test
	public void testUpdate() {
		Assert.fail("Not yet implemented");
	}

	@Test
	public void testUse() {
		Assert.assertEquals(true, this.tester.use(null), "use must return null");
		Assert.fail("Not yet implemented");
	}

}
