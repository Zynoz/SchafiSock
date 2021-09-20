package at.schafi.schafisock.service;

import at.schafi.schafisock.model.Order;
import at.schafi.schafisock.repository.OrderRepository;
import at.schafi.schafisock.service.api.OrderService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@AllArgsConstructor
public class OrderServiceImpl implements OrderService {

    private OrderRepository orderRepository;

    @Override
    public Iterable<Order> getAllOrders() {
        return this.orderRepository.findAll();
    }

    @Override
    public Order update(Order order) {
        return this.orderRepository.save(order);
    }

    @Override
    public Order create(Order order) {
        return this.orderRepository.save(order);
    }
}
