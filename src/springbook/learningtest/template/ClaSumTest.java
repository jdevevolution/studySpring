package springbook.learningtest.template;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;
import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

public class ClaSumTest {
	Calculator calculator;
	String numFilePath;
	
	@Before 
	public void setUp(){
		this.calculator = new Calculator();
		this.numFilePath = getClass().getResource("numbers.txt").getPath();
	}
	
	@Test
	public void sumOfNumbers() throws IOException{
		int sum = calculator.calSum(this.numFilePath);
		assertThat(sum, is(15));
	}
	
	@Test
	public void multiplyOfNumbers() throws IOException{
		int sum = calculator.calMultiply(this.numFilePath);
		assertThat(sum, is(120));
	}
}
