package models;

import javax.persistence.*;
import java.io.Serializable;
import java.util.*;

@Entity
@Table(name = "memberOrder")
@NamedQueries({
        @NamedQuery(name = "MemberOrder.getAll", query = "SELECT m FROM memberOrder m")
})
public class MemberOrder implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;

    double totalCost;

    @Temporal(TemporalType.DATE)
    Date date;

    @Enumerated(EnumType.STRING)
    OrderStatus status;

    @OneToOne(cascade = CascadeType.ALL)
    Member memberId;

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "memberOrder")
    List<MenuItemOrdered> menuItemOrdered = new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL)
    Staff staffId;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public double getTotalCost() {
        return totalCost;
    }

    public void setTotalCost(double cost) {
        this.totalCost = cost;
    }

    public OrderStatus getStatus() {
        return status;
    }

    public void setStatus(OrderStatus status) {
        this.status = status;
    }

    public Member getMemberId() {
        return memberId;
    }

    public void setMemberId(Member memberId) {
        this.memberId = memberId;
    }

    public List<MenuItemOrdered> getMenuItemOrdereds() {
        return menuItemOrdered;
    }

    public void setMenuItemOrdereds(List<MenuItemOrdered> menuItemOrdered) {
        this.menuItemOrdered = menuItemOrdered;
    }

    public Staff getStaffId() {
        return staffId;
    }

    public void setStaffId(Staff staffId) {
        this.staffId = staffId;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }
}
