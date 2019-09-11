package models;

import javax.persistence.*;

@Entity
@Table(name = "drink_stock")
public class DrinkStock {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    @OneToOne(cascade = CascadeType.ALL)
    MenuItem menuItem;
    int stock;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public MenuItem getMenuItem() {
        return menuItem;
    }

    public void setDrinkId(MenuItem menuItem) {
        this.menuItem = menuItem;
    }

    public int getStock() {
        return stock;
    }

    public void setStock(int stock) {
        this.stock = stock;
    }

}
