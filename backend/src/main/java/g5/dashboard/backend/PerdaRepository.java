package g5.dashboard.backend;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import g5.dashboard.backend.Perda;

// This will be AUTO IMPLEMENTED by Spring into a Bean called userRepository
// CRUD refers Create, Read, Update, Delete
public interface PerdaRepository extends CrudRepository<Perda, Integer> {

    @Query(value = "SELECT"
    + " SUM(TIMESTAMPDIFF(minute, dth_inicial_realizado, dth_final_realizado)) "
    + " FROM perda"
    + " WHERE year(dth_inicial_realizado)= ?1"
    , nativeQuery = true)
    Double getSomadasParadas(Integer year);

}