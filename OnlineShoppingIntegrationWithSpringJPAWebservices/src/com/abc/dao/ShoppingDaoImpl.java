package com.abc.dao;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Repository;

import com.abc.bean.Card;
import com.abc.bean.Item;
import com.abc.bean.Order;

@Component
@Transactional
@Repository
public class ShoppingDaoImpl implements ShoppingDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	@Transactional
	@Override
	public List<Item> getItems() {
	
		//return null;
		
		List<Item>itemList=new ArrayList<>();
		//itemList.add(new Item());
		
		String qry = "select itm from Item itm";
		
		try {
			
		Session sm = sessionFactory.getCurrentSession(); 
			
		TypedQuery<Item>query=sm.createQuery(qry,Item.class);
		itemList= query.getResultList();
		}
		
		catch(Exception e)
		{
			System.out.println("Error Fetching the items from db");
			
		}
		return itemList;
	}

	@Transactional
	@Override
	public Item getItem(Item item) {
		
		Session sm1 = sessionFactory.getCurrentSession();
		Item itm = sm1.find(Item.class, item.getId());
		return itm;
	}

	@Transactional
	@Override
	public Order buyitem(Card card) {
		// TODO Auto-generated method stub
	
		Session sm2 =sessionFactory.getCurrentSession();
		Order order = new Order();
		Item itm = sm2.find(Item.class, card.getItemId());
		System.out.println("Item : " +itm);
		order.setCustName(card.getName());
		order.setItemId(itm.getId());
		order.setPurchaseDate(new Date());
		order.setQuantity(card.getQuantity());
		order.setCustMobile(card.getMobile());
		
		sm2.persist(order);
	
		return order;
	}

}
