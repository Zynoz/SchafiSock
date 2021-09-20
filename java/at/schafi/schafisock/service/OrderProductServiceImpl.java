/* (C)2021 */
package at.schafi.schafisock.service;

import at.schafi.schafisock.model.OrderProduct;
import at.schafi.schafisock.repository.OrderProductRepository;
import at.schafi.schafisock.service.api.OrderProductService;
import javax.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

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
