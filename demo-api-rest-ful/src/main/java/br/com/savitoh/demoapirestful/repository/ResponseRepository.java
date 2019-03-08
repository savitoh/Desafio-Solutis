package br.com.savitoh.demoapirestful.repository;


import br.com.savitoh.demoapirestful.model.Response;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ResponseRepository extends CrudRepository<Response, Long> {

}
