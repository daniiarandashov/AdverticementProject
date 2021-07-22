package kg.megacom.AddProject.dao;

import kg.megacom.AddProject.models.OrderDays;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderDaysRepo extends JpaRepository<OrderDays,Long> {

}
