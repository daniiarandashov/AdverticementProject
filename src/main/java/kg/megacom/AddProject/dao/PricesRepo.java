package kg.megacom.AddProject.dao;

import kg.megacom.AddProject.models.Prices;
import kg.megacom.AddProject.models.TvChanel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface PricesRepo extends JpaRepository<Prices, Long> {

    @Query(value = "select * from prices p where p.tv_chanel_id = ?1 and current_timestamp between start_date and end_date", nativeQuery = true)
    Prices findByChannelAndDate(Long channelId);
}
