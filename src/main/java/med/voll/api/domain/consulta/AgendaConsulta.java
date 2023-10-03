package med.voll.api.domain.consulta;

import jakarta.validation.ValidationException;
import med.voll.api.domain.medico.Medico;
import med.voll.api.domain.medico.MedicoRepository;
import med.voll.api.domain.paciente.PacienteRepository;
import med.voll.api.domain.ValidacaoException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class AgendaConsulta {

    @Autowired
    private ConsultasRepository consultaRepository;
    @Autowired
    private MedicoRepository medicoRepository;
    @Autowired
    private PacienteRepository pacienteRepository;
    public void agendar(DadosAgendamentoConsulta data){

    if (!pacienteRepository.existsById(data.idPaciente())){
        throw new ValidacaoException("id do paciente informado não existe!");
    }
    if (data.idMedico() != null && !medicoRepository.existsById(data.idMedico())){
        throw new ValidationException("Id do médico informado não existe");
    }

        var paciente = pacienteRepository.getReferenceById(data.idPaciente());
        var medico = escolherMedico(data);
        var consulta = new Consulta(null, medico, paciente, data.data(), null);
        consultaRepository.save(consulta);
    }

    private Medico escolherMedico(DadosAgendamentoConsulta data) {
        if(data.idMedico() != null){
            return medicoRepository.getReferenceById(data.idMedico());
        }

        if(data.especialidade() == null){
            throw new ValidacaoException("Especialidade é obrigatória quando médico não for escolhido");
        }

        return medicoRepository.escolherMedicoAleatorioLivreNaData(data.especialidade(), data.data());
    }

    public void cancelar(DadosCancelamentoConsulta dados){
        if(!consultaRepository.existsById(dados.idConsulta())){
            throw new ValidationException("Id da consulta informado não existe!");
        }
        var consulta = consultaRepository.getReferenceById(dados.idConsulta());
        consulta.cancelar(dados.motivo());
    }


}
