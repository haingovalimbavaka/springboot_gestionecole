/**
 * 
 */
package org.mino.project.ecole;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;

import org.hamcrest.core.IsEqual;
import org.hamcrest.core.IsNull;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.mino.project.Helper.ServiceHelper;
import org.mino.project.classe.Classe;
import org.mockito.Mockito;

/**
 * @author OneLogic
 *
 */
public class EcoleTest {
	
	private Ecole ecole;
	private ServiceHelper helper;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		ecole = new Ecole();
		helper = Mockito.mock(ServiceHelper.class);
	}

	/**
	 * @throws java.lang.Exception
	 */
	@After
	public void tearDown() throws Exception {
	}

	/**
	 * Test method for {@link org.mino.project.ecole.Ecole#setIdEcole(java.lang.Long)}.
	 */
	@Test
	public void testSetIdEcole() {
		ecole.setIdEcole(null);
		Long result = ecole.getIdEcole();
		assertThat(result, IsNull.nullValue());
	}
	
	@Test
	public void testSetIdEcoleNotNull() {
		ecole.setIdEcole(1L);
		Long result = ecole.getIdEcole();
		assertThat(result, IsNull.notNullValue());
		assertThat(result, IsEqual.equalTo(1L));
	}

	/**
	 * Test method for {@link org.mino.project.ecole.Ecole#setNomEcole(java.lang.String)}.
	 */
	@Test
	public void testSetNomEcole() {
		ecole.setNomEcole(null);
		String result = ecole.getNomEcole();
		assertThat(result, IsNull.nullValue());
	}
	
	@Test
	public void testSetNomEcoleNotNull() {
		ecole.setNomEcole("test");
		String result = ecole.getNomEcole();
		assertThat(result, IsNull.notNullValue());
		assertThat(result, IsEqual.equalTo("test"));
	}

	/**
	 * Test method for {@link org.mino.project.ecole.Ecole#setListClasse(java.util.List)}.
	 */
	@Test
	public void testSetListClasse() {
		ecole.setListClasse(null);
		List<Classe> result= ecole.getListClasse();
		assertThat(result, IsNull.nullValue());
	}
	
	@Test
	public void testSetListClasseNonNull() {
		ecole.setListClasse(new ArrayList<>());
		List<Classe> result= ecole.getListClasse();
		assertThat(result, IsNull.notNullValue());
	}

	/**
	 * Test method for {@link org.mino.project.ecole.Ecole#setMoyenneEcole(java.lang.Double)}.
	 */
	@Test
	public void testSetMoyenneEcole() {
		ecole.setMoyenneEcole(null);
		Long result = ecole.getIdEcole();
		assertThat(result, IsNull.nullValue());
	}
	
	/*
	@Test
	public void testGetMoyenneEcole() {
		when(helper.calculMoyenneEcole(ecole)).thenReturn(14D); 		
		ecole.setMoyenneEcole(14D);
		Double result = ecole.getMoyenneEcole();
		assertThat(result, IsNull.notNullValue());
		assertThat(result, IsEqual.equalTo(14D));
	}
	*/
}
