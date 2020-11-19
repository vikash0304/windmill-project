package com.solution.smart.windmill.api.service;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;
import static org.junit.Assert.assertNull;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class WindMillSolutionServiceTest {

	@InjectMocks
	private WindMillSolutionService windMillSolutionService;

	List<String> listInput = new ArrayList<String>();

	@Before
	public void setup() {
		listInput.add("this is interview test");
		listInput.add("this interview is going on");
	}

	@Test
	public void addAndFetchValueTestForNoResult() {
		String result = windMillSolutionService.addAndFetchValue(listInput);
		assertNull(result);

	}

	@Test
	public void addAndFetchValueTest() {
		listInput.add("Its aa interview as technical");
		String result = windMillSolutionService.addAndFetchValue(listInput);
		assertNotNull(result);
		assertEquals(result, "Its aa interview as technical");

	}
}
