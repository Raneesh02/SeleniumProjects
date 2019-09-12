package test;

import org.testng.annotations.Factory;

public class SimpleTestFactory2 {
	@Factory
	public Object[] factoryMethod() {
		return new Object[] { new SimpleTestFactory(), new SimpleTestFactory() };
	}
}
