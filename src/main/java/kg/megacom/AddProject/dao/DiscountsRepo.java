package kg.megacom.AddProject.dao;

import kg.megacom.AddProject.models.Discounts;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

@Repository
public interface DiscountsRepo extends JpaRepository<Discounts, Long> {

    @Query(value = "select * from discounts d where d.min_days = (select MAX(min_days) from discounts d where d.min_days < ?1) and current_timestamp between start_date and end_date and d.tv_chanel_id = ?2", nativeQuery = true)
    Discounts findByTvChannelAndMinDay(int days, Long id);
}
