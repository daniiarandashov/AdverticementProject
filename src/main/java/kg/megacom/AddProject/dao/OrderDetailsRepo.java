package kg.megacom.AddProject.dao;

import kg.megacom.AddProject.models.Order;
import kg.megacom.AddProject.models.OrderDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderDetailsRepo extends JpaRepository<OrderDetails,Long> {

    List<OrderDetails> findAllByOrder(Order order);
}
