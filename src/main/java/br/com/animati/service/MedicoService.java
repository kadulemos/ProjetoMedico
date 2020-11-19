package br.com.animati.service;

import java.util.List;

import br.com.animati.entity.EstadoType;
import br.com.animati.entity.Medico;

public interface MedicoService {

	public void add(Medico m) throws Exception;
	public void edit(Medico m);
	public List<Medico> list();
	public void delete(long idMedico);
	public Medico findById(long idMedico);
	public Medico findMedicoByCrm(String crm);
	public Medico findMedicoByCrmAndEstado(String crm, EstadoType estado);
	public Medico findMedicoByExecutor();
	public Medico findMedicoByProvisorio();


}
