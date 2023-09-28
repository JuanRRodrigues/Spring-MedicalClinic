package med.voll.api.domain.consulta;

import lombok.var;
import med.voll.api.domain.medico.MedicoRepository;
import med.voll.api.domain.paciente.PacienteRepository;
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


        var paciente = pacienteRepository.findById(data.idPaciente()).get();
        var medico = medicoRepository.findById(data.idMedico()).get();
        var consulta = new Consulta(null, medico, paciente, data.data());
        consultaRepository.save(consulta);
    }

}
