package models;

import javax.persistence.*;

@Entity
@Table(name = "menuItem")
@NamedQueries({
        @NamedQuery(name = "MenuItem.getAll", query = "SELECT i FROM menuItem i"),
        @NamedQuery(name = "MenuItem.getByName", query = "SELECT i FROM menuItem i WHERE i.name = :name"),
        @NamedQuery(name = "MenuItem.getByCategory", query = "SELECT i FROM menuItem i WHERE i.category = :category"),
        @NamedQuery(name = "MenuItem.getById", query = "SELECT i FROM menuItem i WHERE i.id = :id")
})
public class MenuItem {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    int id;
    String name;
    double price;

    @Enumerated(EnumType.STRING)
    MenuItemCategory category;

    public MenuItem(){}

    public MenuItem(String name, double price){
        this.name = name;
        this.price = price;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public double getPrice() {
        return price;
    }

    public MenuItemCategory getCategory() {
        return category;
    }

    public void setCategory(MenuItemCategory category) {
        this.category = category;
    }

    public void setPrice(double price) {
        this.price = price;
    }
}
