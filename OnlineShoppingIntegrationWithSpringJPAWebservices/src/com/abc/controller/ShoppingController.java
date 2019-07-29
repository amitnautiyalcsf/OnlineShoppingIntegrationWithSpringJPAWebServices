package com.abc.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.abc.bean.Card;
import com.abc.bean.Item;
import com.abc.bean.Order;
import com.abc.exception.ShoppingException;
import com.abc.service.ShoppingService;
import com.abc.util.ShoppingMessage;

@Controller
public class ShoppingController {

	@Autowired
	private ShoppingService  service;
	
	
	@RequestMapping(value="/proceed")
	public String showItems(Model model) throws ShoppingException
	{
		List<Item>itemList= service.getItems();
	
		try {
		model.addAttribute("ilist", itemList);
		
		model.addAttribute("sitem", new Item());
		}
		catch(Exception e)
		{
			throw new ShoppingException(ShoppingMessage.ERROR_IN_DB);
			
		}
		
		return "display";
	}
	
	
	@RequestMapping(value="/placeOrder")
	public String placeOrder(@ModelAttribute(value="sitem")Item item, Model model)
	{
		Item itm = service.getItem(item);
		System.out.println("Item from db" +itm);
		
		if(itm!=null) 
		{
			Card card = new Card();
			card.setItemId(item.getId());
			
			model.addAttribute("citem", card);
			
			
		}
		
		return "order";
		
		
	}
	
	
	@RequestMapping(value="/buyItem")
	public String buyItem(@ModelAttribute(value ="citem")Card card, Model model)
	{
		System.out.println("Card: " +card);
		
		Order order = service.buyItem(card);
		
		System.out.println("Order:  " +order);
		
		if(order==null)
		{
			
			model.addAttribute("err","Card Validation Failed");
			return "fail";
		}
		
		model.addAttribute("oitem", order);
		
		return "success";
		
	}
	
	@ExceptionHandler(ShoppingException.class)
	public String handleErrors(ShoppingException err)
	{
		
		return "shoppingerror";
		
	}
	
	
	
}
