package at.schafi.schafisock.service;

import at.schafi.schafisock.model.OrderProduct;
import at.schafi.schafisock.repository.OrderProductRepository;
import at.schafi.schafisock.service.api.OrderProductService;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
@AllArgsConstructor
public class OrderProductServiceImpl implements OrderProductService {

    private OrderProductRepository orderProductRepository;

    @Override
    public OrderProduct create(OrderProduct orderProduct) {
        return this.orderProductRepository.save(orderProduct);
    }
}
