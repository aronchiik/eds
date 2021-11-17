package kz.halykfinance.vote.repository;

import kz.halykfinance.vote.entity.Signers;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface SignersRepository extends CrudRepository<Signers,Long> {
     Signers getSignersByIin(String iin);
     List<Signers> getAll();
}
