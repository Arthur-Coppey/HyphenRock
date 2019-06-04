package view;

import org.junit.Assert;
import org.junit.Test;

public class CameraTest {
	private final Camera tester;

	public CameraTest() {
		this.tester = new Camera();
	}

	@Test
	public final void testGetHEIGHT() {
		this.tester.setHEIGHT(10);
		Assert.assertEquals(10, this.tester.getHEIGHT());
	}

	@Test
	public final void testGetWIDTH() {
		this.tester.setWIDTH(11);
		Assert.assertEquals(11, this.tester.getWIDTH());
	}

	@Test
	public final void testGetX() {
		this.tester.setX(12);
		Assert.assertEquals(12, this.tester.getX());
	}

	@Test
	public final void testGetY() {
		this.tester.setY(13);
		Assert.assertEquals(13, this.tester.getY());
	}

	@Test
	public final void testSetHEIGHT() {
		this.tester.setHEIGHT(14);
		Assert.assertEquals(14, this.tester.getHEIGHT());
	}

	@Test
	public final void testSetWIDTH() {
		this.tester.setWIDTH(15);
		Assert.assertEquals(15, this.tester.getWIDTH());
	}

	@Test
	public final void testSetX() {
		this.tester.setX(16);
		Assert.assertEquals(16, this.tester.getX());
	}

	@Test
	public final void testSetY() {
		this.tester.setY(17);
		Assert.assertEquals(17, this.tester.getY());
	}

}
