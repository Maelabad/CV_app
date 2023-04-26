package sn.esmt.CV.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import sn.esmt.CV.entities.AppCVEntity;

@Repository
public interface AppCVRepository extends JpaRepository<AppCVEntity,Integer> {
    AppCVEntity findById(int id);

}
