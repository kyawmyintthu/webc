package com.java.webc;

import static org.junit.Assert.assertTrue;

import org.junit.Test;

import com.java.webc.service.CawlerService;
import com.java.webc.service.CawlerServiceImpl;
import com.java.webc.util.AppContext;

/**
 * Unit test for simple App.
 */
public class CawlerServiceImplTest {

	@Test
	public void cawlerServiceTest() {

		CawlerService cs = new CawlerServiceImpl();
		
		cs.constractDataLink("https://www.google.com");
		assertTrue(AppContext.getDataList().size()>0);
	}
	

	
}
