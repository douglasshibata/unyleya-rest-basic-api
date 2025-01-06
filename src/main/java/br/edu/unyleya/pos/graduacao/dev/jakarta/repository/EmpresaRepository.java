package br.edu.unyleya.pos.graduacao.dev.jakarta.repository;

import br.edu.unyleya.pos.graduacao.dev.jakarta.model.Empresa;
import br.edu.unyleya.pos.graduacao.dev.jakarta.model.Endereco;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class EmpresaRepository extends BaseRepository<Empresa> {

    @Inject
    private EnderecoRepository endRepository;

    @Override
    public Empresa save(Empresa entity) {
        Endereco endereco = entity.getEndereco();
        entity = super.save(entity);
        if (entity.getEndereco() != null) {
            endereco.setEmpresa(entity);
            entity.setEndereco(endRepository.save(endereco));
        }        
        return entity;
    }

}
