package br.com.fiap.smartmottu.repository;

import br.com.fiap.smartmottu.dto.MotoRequestDto;
import br.com.fiap.smartmottu.entity.Moto;
import br.com.fiap.smartmottu.entity.StatusMoto;
import br.com.fiap.smartmottu.entity.TipoMoto;
import jakarta.persistence.criteria.Join;
import jakarta.persistence.criteria.JoinType;
import jakarta.persistence.criteria.Predicate;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import java.util.ArrayList;
import java.util.List;

@Repository
public interface MotoRepository extends JpaRepository<Moto, Long>, JpaSpecificationExecutor<Moto> {

//    interface Specs {
//
//        static Specification<Moto> byFilter(MotoRequestDto filter) {
//
//            return (root, query, criteriaBuilder) -> {
//                List<Predicate> predicates = new ArrayList<>();
//
//                Join<Moto, StatusMoto> joinStatus = root.join("status", JoinType.INNER);
//                Join<Moto, TipoMoto> joinTipo = root.join("modelo", JoinType.INNER);
//
//                if (StringUtils.hasText(filter.getNmChassi())) {
//                    Predicate predicate = criteriaBuilder.like(criteriaBuilder.upper(root.get("nmChassi")), "%" + filter.getNmChassi().trim().toUpperCase() + "%");
//                    predicates.add(predicate);
//                }
//                if (StringUtils.hasText(filter.getPlaca())) {
//                    Predicate predicate = criteriaBuilder.like(criteriaBuilder.upper(root.get("placa")), "%" + filter.getPlaca().trim().toUpperCase() + "%");
//                    predicates.add(predicate);
//                }
//                if (StringUtils.hasText(filter.getUnidade())) {
//                    Predicate predicate = criteriaBuilder.like(criteriaBuilder.upper(root.get("unidade")), "%" + filter.getUnidade().trim().toUpperCase() + "%");
//                    predicates.add(predicate);
//                }
//                if (StringUtils.hasText(filter.getStatus())) {
//                    Predicate predicate = criteriaBuilder.like(criteriaBuilder.upper(joinStatus.get("status")), "%" + filter.getStatus().trim().toUpperCase() + "%");
//                    predicates.add(predicate);
//                }
//                if (StringUtils.hasText(filter.getModelo())) {
//                    Predicate predicate = criteriaBuilder.like(criteriaBuilder.upper(joinTipo.get("nmTipo")), "%" + filter.getModelo().trim().toUpperCase() + "%");
//                    predicates.add(predicate);
//                }
//
//                return criteriaBuilder.and(predicates.toArray(Predicate[]::new));
//
//            };
//
//        }
//
//    }


}
