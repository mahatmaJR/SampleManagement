package DAO.interfaces;

import models.MemberOrder;
import models.OrderStatus;

import javax.ejb.Local;
import java.util.List;

@Local
public interface MemberOrderRepository {
    MemberOrder createMemberOrder(int memberId, OrderStatus status, int staffId);
    MemberOrder getByMemberOrderId(int memberOrderId);
    MemberOrder changeOrderStatus(int memberOrderId, OrderStatus status);
    MemberOrder addItemToOrder(int memberOrder, int item, int itemQuantity);
    double calculateTotalCost(int memberOrderId);
    List<MemberOrder> getAllOrders();
}
