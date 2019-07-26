package com.abc.service;

import java.util.List;

import com.abc.bean.Card;
import com.abc.bean.Item;
import com.abc.bean.Order;

public interface ShoppingService {

	List<Item> getItems();

	Item getItem(Item item);

	Order buyItem(Card card);

	

}
