package br.com.animati.dao;

import java.util.ArrayList;
import java.util.List;

import br.com.animati.entity.EstadoType;
import br.com.animati.entity.Medico;

public class MedicoDAOImpl implements MedicoDAO {

	private List<Medico> listaMedicos;

	public MedicoDAOImpl() {
		listaMedicos = new ArrayList<Medico>();
	}

	public void add(Medico m) throws Exception {
		listaMedicos.add(m);

	}

	public void edit(Medico m) {
		boolean encontrou = true;
		int indice = 0;
		do {
			if (listaMedicos.get(indice).getIdMedico() == m.getIdMedico()) { //find by id
				listaMedicos.set(indice, m); // update
				encontrou = false;
			}
			indice++;

		} while (encontrou);

		/* Medico medicoEditar = findById(m.getIdMedico());

		if(medicoEditar != null) {
			medicoEditar.setProfissao(m.getProfissao());
			medicoEditar.setConselhoProfissional(m.getConselhoProfissional());
			medicoEditar.setCrm(m.getCrm());
			medicoEditar.setCns(m.getCns());
			medicoEditar.setEstadoCrm(m.getEstadoCrm());
			medicoEditar.setSolicitante(m.getSolicitante());
			medicoEditar.setExecutor(m.getExecutor());
			medicoEditar.setAnestesista(m.getAnestesista());
			medicoEditar.setProvisorio(m.getProvisorio());
		} else {
			System.out.println("Por favor, verifique o Id do Médico.");
		}
		 */

	}

	public List<Medico> list() {
		return listaMedicos;
	}

	public void delete(long idMedico) {
		boolean encontrar = true;
		int indice = 0;

		do {
			if(listaMedicos.get(indice).getIdMedico() == idMedico) {
				listaMedicos.remove(indice);
				encontrar = false;
			}
			indice++;
		} while (encontrar);

	}

	public Medico findById(long idMedico) {
		Medico medicoEncontrado = null;
		boolean encontrar = true;
		int indice = 0;

		do {
			if(listaMedicos.get(indice).getIdMedico() == idMedico) {
				medicoEncontrado = listaMedicos.get(indice);
				encontrar = false;
			}
		} while (encontrar);

		return medicoEncontrado;
	}

	public Medico findMedicoByCrm(String crm) {
		Medico medicoEncontrado = null;
		boolean encontrar = true;
		int indice = 0;
		do {
			if (listaMedicos.get(indice).getCrm() == crm) {
				medicoEncontrado = listaMedicos.get(indice);
				encontrar = false;
			}

			indice++;

		} while (encontrar);

		return medicoEncontrado;
	}

	public Medico findMedicoByCrmAndEstado(String crm, EstadoType estado) {
		Medico medicoEncontrado = null;
		boolean encontrar = true;
		int indice = 0;
		do {
			if(listaMedicos.get(indice).getCrm() == crm && listaMedicos.get(indice).getEstadoCrm() == estado) {
				medicoEncontrado = listaMedicos.get(indice);
				encontrar = false;
			}
			indice++;
		} while(encontrar);

		return medicoEncontrado;
	}

	public Medico findMedicoByExecutor() {
		// TODO Auto-generated method stub
		return null;
	}

	public Medico findMedicoByProvisorio() {
		// TODO Auto-generated method stub
		return null;
	}

}
