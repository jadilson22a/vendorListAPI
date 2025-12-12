package com.github.jadilson22a.vendorListAPI;

import com.github.jadilson22a.vendorListAPI.DTOs.VendedorDTO;
import com.github.jadilson22a.vendorListAPI.Enum.FornecimentoEscopo;
import com.github.jadilson22a.vendorListAPI.Models.Categoria;
import com.github.jadilson22a.vendorListAPI.Models.Vendedor;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class VendorListApiApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void CriarVendedorDTO(){
		VendedorDTO dto = new VendedorDTO("Pacheco",
				"19945633000106",
				"pacheco@pacheco.com.br","19982403477",
				FornecimentoEscopo.SERVICO,new Categoria(),"Teste");

		System.out.println(dto);

		Vendedor vendedor = dto.mapearParaVendedor();
		System.out.println(vendedor);

		VendedorDTO dto2 = vendedor.mapearParaDto();
		System.out.println(dto2);
	}

}
