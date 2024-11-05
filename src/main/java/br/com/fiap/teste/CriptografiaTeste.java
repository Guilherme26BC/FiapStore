package br.com.fiap.teste;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Test;

import br.com.fiap.util.CriptografiaUtils;

public class CriptografiaTeste {

	@Test
	public void testCriptografar()  throws Exception{
		try {
			String senha ="123456";
			String criptografada = "e10adc3949ba59abbe56e057f20f883e";
			assertNotNull("A senha criptografada não deve ser nula", criptografada);
			assertEquals("A criptografia deve ser consistente", criptografada, CriptografiaUtils.criptografar(senha));
			//assertEqual faz o teste, coloca a função que quer testar com os valores, e o resultado esperado
		}catch(Exception e) {
			e.printStackTrace();
		}
	}

}
