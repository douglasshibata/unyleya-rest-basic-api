package br.edu.unyleya.pos.graduacao.dev.jakarta.repository;

import br.edu.unyleya.pos.graduacao.dev.jakarta.model.Empresa;
import jakarta.ejb.Stateless;
import jakarta.inject.Inject;

@Stateless
public class EmpresaRepository extends  BaseRepository<Empresa> {

    @Inject
    private EnderecoRepository endRepository;

    @Override
    public Empresa save(Empresa entity) {
        entity = super.save(entity);
        System.out.println(entity.toString());
        System.out.println(entity.getEndereco());
        if(entity.getEndereco() != null){
            entity.getEndereco().setEmpresa(entity);
            entity.setEndereco(endRepository.save(entity.getEndereco()));
        }
        System.out.println(entity.toString());
        return entity;
    }
   

}
