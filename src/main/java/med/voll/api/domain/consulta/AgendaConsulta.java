package med.voll.api.domain.consulta;

import jakarta.validation.ValidationException;
import med.voll.api.domain.medico.MedicoRepository;
import med.voll.api.domain.paciente.PacienteRepository;
import med.voll.api.domain.validacaoExecpiton;
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
    public void agendar(DataAppointmentConsultation data){

    if (!pacienteRepository.existsById(data.idPaciente())){
        throw new validacaoExecpiton("id do paciente informado não existe!");
    }
    if (data.idMedico() != null && !medicoRepository.existsById(data.idMedico())){
        throw new ValidationException("Id do médico informado não existe");
    }

        var paciente = pacienteRepository.findById(data.idPaciente()).get();
        var medico = escolherMedico(data);
        var consulta = new Consulta(null, medico, paciente, data.data());
        consultaRepository.save(consulta);
    }

    private Medico escolherMedico(DataAppointmentConsultation data) {
    }

}
