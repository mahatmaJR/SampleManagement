package DAO.implementations;

import DAO.interfaces.MenuItemRepository;
import models.MenuItem;
import models.MenuItemCategory;

import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
import java.util.List;

@Stateless
public class MenuItemRepositoryImp implements MenuItemRepository {

    @PersistenceContext
    EntityManager entity;

    MenuItem addToMenuItem(MenuItem newItem, MenuItemCategory givenCategory){
        if(newItem.getCategory().equals(givenCategory)){
            entity.persist(newItem);
        }
        return findItemById(newItem.getId());
    }

    @Override
    public MenuItem createNewMenuItem(String name, double price, MenuItemCategory category) {
        MenuItem item = new MenuItem();
        item.setName(name);
        item.setCategory(category);
        item.setPrice(price);
        return item;
    }

    @Override
    public List<MenuItem> getMenuItemByCategory(MenuItemCategory category) {
        Query query = entity.createNamedQuery("MenuItem.getByCategory").setParameter("category", category);
        List<MenuItem> menuItems = query.getResultList();
        if (menuItems.size() == 0){
            return null;
        }
        return menuItems;
    }

    @Override
    public List<MenuItem> getDrinks() {
        List<MenuItem> items = getMenuItemByCategory(MenuItemCategory.DRINK);
        if (items == null)
            return null;
        return items;
    }

    @Override
    public List<MenuItem> getFood() {
        List<MenuItem> items = getMenuItemByCategory(MenuItemCategory.FOOD);
        return items;
    }

    @Override
    public List<MenuItem> getSnack() {
        List<MenuItem> items = getMenuItemByCategory(MenuItemCategory.SNACK);
        return items;
    }

    @Override
    public MenuItem addToDrinks(MenuItem item) {
        return addToMenuItem(item, MenuItemCategory.DRINK);
    }

    @Override
    public MenuItem addToFood(MenuItem item) {
        return addToMenuItem(item, MenuItemCategory.FOOD);
    }

    @Override
    public MenuItem addToSnack(MenuItem item) {
        return addToMenuItem(item, MenuItemCategory.SNACK);
    }

    @Override
    public MenuItem findItemByName(String name) {
        List<MenuItem> items = entity.createNamedQuery("MenuItem.getByName").setParameter("name", name).getResultList();
        return items.get(0);
    }

    @Override
    public MenuItem findItemById(int id) {
        List<MenuItem> items = entity.createNamedQuery("MenuItem.getById").setParameter("id", id).getResultList();
        return items.get(0);
    }



    @Override
    public MenuItem updateMenuItem(int itemId) {
        MenuItem retrievedItem = findItemById(itemId);

        entity.merge(retrievedItem);

        return retrievedItem;
    }
}
