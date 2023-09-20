package med.voll.api.domain.medico;

public record DadosListagemMedica(
        Long id,
        String nome,
        String email,
        String crm,
        Especialidade especialidade) {

    public DadosListagemMedica(Medico medico){
        this(medico.getId(), medico.getNome(), medico.getEmail(), medico.getCrm(), medico.getEspecialidade());
    }
}
