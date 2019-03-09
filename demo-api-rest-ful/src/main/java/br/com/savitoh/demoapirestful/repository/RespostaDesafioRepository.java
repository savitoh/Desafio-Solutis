package br.com.savitoh.demoapirestful.repository;


import br.com.savitoh.demoapirestful.model.RespostaDesafio;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RespostaDesafioRepository extends CrudRepository<RespostaDesafio, Long> {

}
