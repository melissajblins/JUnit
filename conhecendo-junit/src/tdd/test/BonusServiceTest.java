package tdd.test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.fail;

import java.math.BigDecimal;
import java.time.LocalDate;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import tdd.modelo.Funcionario;
import tdd.service.BonusService;

class BonusServiceTest {

	private BonusService service;
	
	private Funcionario criarFuncionario(BigDecimal salario) {
		return new Funcionario("Rodrigo", LocalDate.now(), salario);
	}

	@BeforeEach
	public void inicializa() {
		this.service = new BonusService();
	}

	@Test
	void bonusDeveriaSerZeroParaFuncionarioComSalarioMuitoAlto() {
		try {
			service.calcularBonus(criarFuncionario(new BigDecimal("25000")));
			fail("Sem exception");
		} catch (IllegalArgumentException exception) {
			assertEquals("Funcionário com salário maior do que R$1000 não pode receber bonus!", exception.getMessage());
		}

	}

	@Test
	void bonusDeveriaSer10PorCentoDoSalario() {
		BigDecimal bonus = service.calcularBonus(criarFuncionario(new BigDecimal("2500")));

		assertEquals(new BigDecimal("250.00"), bonus);
	}

	@Test
	void bonusDeveriaSerDezPorCentoParaSalarioDeExatamente10000() {
		BigDecimal bonus = service.calcularBonus(criarFuncionario(new BigDecimal("10000")));

		assertEquals(new BigDecimal("1000.00"), bonus);
	}
}
