package br.com.fiap.smartmottu.repository;


import br.com.fiap.smartmottu.entity.StatusMoto;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Repository;

@Repository
public interface StatusMotoRepository  extends Specification<StatusMoto> {
}
