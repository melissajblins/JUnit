package tdd.test;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.Test;

import tdd.modelo.Desempenho;
import tdd.modelo.Funcionario;
import tdd.service.BonusService;
import tdd.service.ReajusteService;

class ReajusteServiceTest {

	@Test
	public void reajusteDeveriaSerDe3PorCento() {
		ReajusteService service = new ReajusteService();
		Funcionario funcionario = new Funcionario("Melissa", LocalDate.now(), new BigDecimal("1000.00"));
		
		service.concederReajuste(funcionario, Desempenho.A_DESEJAR);
		assertEquals(new BigDecimal("1030.00"), funcionario.getSalario());
	}

}
