package br.com.animati;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNotNull;

import org.junit.Before;
import org.junit.Test;

import br.com.animati.entity.ConselhoProfissionalType;
import br.com.animati.entity.EstadoType;
import br.com.animati.entity.Medico;
import br.com.animati.service.MedicoService;
import br.com.animati.service.MedicoServiceImpl;

public class MedicoTest {

	private MedicoService medicoService;

	@Before
	public void intil() {
		medicoService = new MedicoServiceImpl();
	}

	@Test
	public void addTest() throws Exception {
		Medico medico = new Medico();

		medico.setIdMedico(12345);
		medico.setProfissao("Cardiologista");
		medico.setConselhoProfissional(ConselhoProfissionalType.CRM);
		medico.setCrm("12345678-9");
		medico.setEstadoCrm(EstadoType.MG);

		medicoService.add(medico);

		assertEquals(1, medicoService.list().size());

	}

	@Test
	public void editTest() throws Exception {
		Medico medico = new Medico();

		medico.setIdMedico(54321);
		medico.setProfissao("Pediatra");
		medico.setConselhoProfissional(ConselhoProfissionalType.CNS);
		medico.setCrm("98765432-1");
		medico.setEstadoCrm(EstadoType.AC);

		medicoService.add(medico);

		Medico medicoEditar = medicoService.findById(54321);
		medicoEditar.setProfissao("Ortopedista");
		medicoService.edit(medicoEditar);

		Medico medicoEditado = medicoService.findById(54321);

		assertEquals("Ortopedista", medicoEditado.getProfissao());

	}

	@Test
	public void findMedicoByCrmAndEstadoTest() throws Exception {
		Medico medico = new Medico();

		medico.setIdMedico(12345);
		medico.setProfissao("Cardiologista");
		medico.setConselhoProfissional(ConselhoProfissionalType.CRM);
		medico.setCrm("12345678-9");
		medico.setEstadoCrm(EstadoType.MG);

		medicoService.add(medico);
		
		assertNotNull(medicoService.findMedicoByCrmAndEstado("12345678-9", EstadoType.MG));

	}

}
