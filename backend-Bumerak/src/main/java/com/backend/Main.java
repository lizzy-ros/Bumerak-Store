package com.backend;

import com.backend.model.*;
import com.backend.repository.*;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.time.LocalDate;
import java.util.List;



@SpringBootApplication
public class Main {

	public static void main(String[] args) {

		ApplicationContext context = SpringApplication.run(Main.class, args);

		ShoppingListRepository repoShopList = context.getBean(ShoppingListRepository.class);
		CustomerRepository repoCustomer = context.getBean(CustomerRepository.class);
		ProductoRepository repoProduco = context.getBean(ProductoRepository.class);
		ShippingAddresRepository repoShippiAddres = context.getBean(ShippingAddresRepository.class);
		PaymentMethodsRepository repoPaymet = context.getBean(PaymentMethodsRepository.class);
		OrderssRepository repoOrderss = context.getBean(OrderssRepository.class);

		//esta es de lista de compras
		ShoppingList shoppingList1 = new ShoppingList(null, LocalDate.of(2010, 1, 1), 1.99, State.PREPARATION);
		repoShopList.saveAll(List.of(shoppingList1));

		//esta es de customer
		Customer user1 = new Customer(null, "user1", "user1","user1@gmail.com","xxxx", "direccion1", "xxxxx");
		repoCustomer.saveAll(List.of(user1));


		//Esta es de producto
		Productos prod1 = new Productos(null, "teclado", "teclado de oro", 10.3, true, Category.OPCION1, true,"img", shoppingList1 );
		repoProduco.saveAll(List.of(prod1));

		//Esta es de ShippingAddres = direccion de envio
		ShippingAddres address1 = new ShippingAddres(null, "usuario1", "calle1", "madrid", "28025", "madrid", user1);
		repoShippiAddres.saveAll(List.of(address1));

		//Esta es de paymentMethods
		PaymentMethods methods1 = new PaymentMethods(null, CardType.MASTER_CART, 254876L, LocalDate.of(1995, 1,1),"258", user1);
		repoPaymet.saveAll(List.of(methods1));

		//Esta es de orders = pedidos
		Orderss pedido1 = new Orderss(null, LocalDate.of(2024,1, 1),State.PREPARATION, "direccion de envio", 2589.2, user1);
		repoOrderss.saveAll(List.of(pedido1));



	}

}
