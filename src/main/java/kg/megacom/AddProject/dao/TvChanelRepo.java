package kg.megacom.AddProject.dao;

import kg.megacom.AddProject.models.TvChanel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface TvChanelRepo extends JpaRepository<TvChanel, Long> {
    @Query(value = "SELECT * FROM tv_chanels t where t.is_active=true", nativeQuery = true)
    List<TvChanel> findByIs_activeTrue();
}
