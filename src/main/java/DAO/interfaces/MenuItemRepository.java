package DAO.interfaces;

import models.MenuItem;
import models.MenuItemCategory;

import javax.ejb.Local;
import java.util.List;

@Local
public interface MenuItemRepository {
    List<MenuItem> getMenuItemByCategory(MenuItemCategory category);
    List<MenuItem> getDrinks();
    List<MenuItem> getFood();
    List<MenuItem> getSnack();
    MenuItem addToDrinks(MenuItem item);
    MenuItem addToFood(MenuItem item);
    MenuItem addToSnack(MenuItem item);
    MenuItem findItemByName(String name);
    MenuItem findItemById(int id);
    MenuItem createNewMenuItem(String name, double price, MenuItemCategory category);
    MenuItem updateMenuItem(int itemId);
}
