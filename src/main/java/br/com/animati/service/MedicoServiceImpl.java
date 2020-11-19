package br.com.animati.service;

import java.util.List;

import br.com.animati.dao.MedicoDAO;
import br.com.animati.dao.MedicoDAOImpl;
import br.com.animati.entity.EstadoType;
import br.com.animati.entity.Medico;

public class MedicoServiceImpl implements MedicoService {

	private MedicoDAO dao;
	
	public MedicoServiceImpl() {
		dao = new MedicoDAOImpl();
	}

	public void add(Medico m) throws Exception {
		if(m.getCrm() == null)
			throw new Exception("Favor inserir CRM");
		dao.add(m);
	}

	public void edit(Medico m) {
		dao.edit(m);
	}

	public List<Medico> list() {
	
		return dao.list();
	}

	public void delete(long idMedico) {
		dao.delete(idMedico);
	}

	public Medico findById(long idMedico) {
		return dao.findById(idMedico);
	}

	public Medico findMedicoByCrm(String crm) {
		return dao.findMedicoByCrm(crm);
	}

	public Medico findMedicoByCrmAndEstado(String crm, EstadoType estado) {
		return dao.findMedicoByCrmAndEstado(crm, estado);
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
