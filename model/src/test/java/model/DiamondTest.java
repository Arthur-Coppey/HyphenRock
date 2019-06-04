package model;

import java.io.IOException;

import org.junit.Assert;
import org.junit.Test;

import model.element.Diamond;

public class DiamondTest {
	private final Diamond tester;

	public DiamondTest() throws IOException {
		this.tester = new Diamond(0, 0);
	}

	/*@Test
	public final void testGetX() {
		this.tester.setX(10);
		Assert.assertEquals(10, this.tester.getX());
	}

	@Test
	public final void testGetY() {
		this.tester.setY(20);
		Assert.assertEquals(20, this.tester.getY());
	}

	@Test
	public final void testSetX() {
		this.tester.setX(15);
		Assert.assertEquals(15, this.tester.getX());
	}

	@Test
	public final void testSetY() {
		this.tester.setY(25);
		Assert.assertEquals(25, this.tester.getY());
	}*/

}
