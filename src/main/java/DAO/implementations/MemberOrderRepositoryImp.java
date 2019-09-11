package DAO.implementations;

import DAO.interfaces.MemberOrderRepository;
import DAO.interfaces.MemberRepository;
import DAO.interfaces.MenuItemRepository;
import DAO.interfaces.StaffRepository;
import models.*;

import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.util.*;

@Stateless
public class MemberOrderRepositoryImp implements MemberOrderRepository {

    @EJB
    MenuItemRepository menu;

    @EJB
    MemberRepository member;

    @EJB
    StaffRepository staff;

    @PersistenceContext
    EntityManager entity;

    List<MenuItemOrdered> listOfItemsOrdered = new ArrayList<>();
    double totalPriceOfItems = 0.0;
    Date date;

    public MemberOrder createMemberOrder(int memberId, OrderStatus status, int staffId){
        MemberOrder order = new MemberOrder();
       order.setMemberId(member.getMemberById(memberId));
       order.setStaffId(staff.getStaffById(staffId));
       order.setStatus(OrderStatus.RECEIVED);
       order.setMenuItemOrdereds(listOfItemsOrdered);
       order.setDate(date);
       order.setTotalCost(totalPriceOfItems);

       saveOrder(order);
        return order;
    }

    public MemberOrder saveOrder(MemberOrder memberOrder){
        entity.persist(memberOrder);

        return memberOrder;
    }

    public MenuItemOrdered saveMenuItemOrder(MenuItemOrdered menuItemOrdered){
        entity.persist(menuItemOrdered);
        return menuItemOrdered;
    }

    @Override
    public MemberOrder getByMemberOrderId(int memberOrderId) {
        MemberOrder memberOrder = entity.find(MemberOrder.class, memberOrderId);
        if (memberOrder.getDate().equals(date)){
            return memberOrder;
        }
        return null;
    }

    @Override
    public MemberOrder changeOrderStatus(int memberOrderId, OrderStatus status) {

        MemberOrder memberOrder = getByMemberOrderId(memberOrderId);

        memberOrder.setStatus(status);

        return memberOrder;
    }
    @Override
    public MemberOrder addItemToOrder(int memberOrderId, int itemId, int itemOrderedQuantity) {
        MemberOrder memberOrder = getByMemberOrderId(memberOrderId);

        MenuItemOrdered item = new MenuItemOrdered();
        item.setMenuItem(menu.findItemById(itemId));
        item.setQuantity(itemOrderedQuantity);
        item.setTotalPrice(menu.findItemById(itemId).getPrice() * itemOrderedQuantity);

        if (memberOrder.getMenuItemOrdereds() == null){
            listOfItemsOrdered.add(item);
            memberOrder.setMenuItemOrdereds(listOfItemsOrdered);
        }else {
            if (memberOrder.getMenuItemOrdereds().contains(item)){
                item.setQuantity(itemOrderedQuantity);
                item.setTotalPrice(menu.findItemById(itemId).getPrice() * itemOrderedQuantity);

                listOfItemsOrdered.add(item);
                memberOrder.setMenuItemOrdereds(listOfItemsOrdered);
            }
        }
        saveOrder(memberOrder);
        return memberOrder;
    }

    @Override
    public double calculateTotalCost(int memberOrderId) {
        MemberOrder memberOrder = getByMemberOrderId(memberOrderId);
        List<MenuItemOrdered> orderedItems = memberOrder.getMenuItemOrdereds();

        for (MenuItemOrdered itm : orderedItems) {
                totalPriceOfItems = totalPriceOfItems + itm.getTotalPrice();
            }

        memberOrder.setTotalCost(totalPriceOfItems);

        return totalPriceOfItems;
        }



    @Override
    public List<MemberOrder> getAllOrders() {
        List<MemberOrder> memberOrders = entity.createNamedQuery("MemberOrder.getAll").getResultList();
        return memberOrders;
    }
}
