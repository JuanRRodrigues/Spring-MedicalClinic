package med.voll.api.controller;

import jakarta.transaction.Transactional;
import jakarta.validation.Valid;
import med.voll.api.domain.consulta.AgendaConsulta;
import med.voll.api.domain.consulta.DataAppointmentConsultation;
import med.voll.api.domain.consulta.DatadetailConsultation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("consultas")
public class ConsultaController {

    @Autowired
    private AgendaConsulta agenda;

    @PostMapping
    @Transactional
    public ResponseEntity appointment(@RequestBody @Valid DataAppointmentConsultation data){
        agenda.agendar(data);
        return  ResponseEntity.ok(new DatadetailConsultation(null, null, null, null));
    }

}
