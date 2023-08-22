package med.voll.api.controller;

import med.voll.api.medico.DadosCadastroMedico;
import med.voll.api.paciente.DadosCadastropaciente;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("pacientes")
public class PacienteController {

    //@RequestBody To receive the data from the request body in a parameter in the Controller.;
    @PostMapping
    public void cadastrar(@RequestBody DadosCadastropaciente dados){
        System.out.println("dados recebidos: " + dados);
    }


}
