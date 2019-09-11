package models;

import javax.persistence.*;

@Entity
@Table
public class MenuItemOrdered {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;


    @ManyToOne(cascade = CascadeType.ALL, targetEntity = MenuItem.class)
    MenuItem menuItem;
    
    int quantity;
    double totalPrice;

    @ManyToOne(fetch = FetchType.EAGER)
    private MemberOrder memberOrder;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public MenuItem getMenuItem() {
        return menuItem;
    }

    public void setMenuItem(MenuItem menuItem) {
        this.menuItem = menuItem;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public MemberOrder getMemberOrder() {
        return memberOrder;
    }

    public void setMemberOrder(MemberOrder memberOrder) {
        this.memberOrder = memberOrder;
    }
}
