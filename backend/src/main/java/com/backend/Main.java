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
        UserRepository userRepo = context.getBean(UserRepository.class);
        ProductoRepository repoProduco = context.getBean(ProductoRepository.class);
        ShippingAddresRepository ShippiAddresRepo = context.getBean(ShippingAddresRepository.class);
        PaymentMethodsRepository repoPaymet = context.getBean(PaymentMethodsRepository.class);
        OrderssRepository repoOrderss = context.getBean(OrderssRepository.class);

                // borrado de tablas




                 //esta es de Usuarios
            User u1 = new User( null, "user1", "user1", "user1@gmail.com", "xxxx", "640364015");
            User u2 = new User( null, "user1", "user2", "user2@gmail.com", "xxxx", "640364015");
            User u3 = new User( null, "user1", "user3", "user3@gmail.com", "xxxx",  "640364015");
            userRepo.saveAll(List.of(u1,u2,u3));

                //Esta es de ShippingAddres = direccion de envio
            ShippingAddres address1 = new ShippingAddres(null, "usuario1", "calle1", "madrid", "28025", "madrid", u2);
            ShippingAddres address2 = new ShippingAddres(null, "usuario1", "calle1", "madrid", "28025", "madrid", u1);
            ShippingAddres address3 = new ShippingAddres(null, "usuario1", "calle1", "madrid", "28025", "madrid", u3);
            ShippiAddresRepo.saveAll(List.of(address1,address2,address3));


                //esta es de lista de compras

            ShoppingList carrito1 = new ShoppingList(null, LocalDate.of(2010, 1, 1), 1.99, State.PREPARATION,u1);
            repoShopList.saveAll(List.of(carrito1));


                //Esta es de producto
            Productos prod1 = new Productos(null, "teclado", "teclado de oro", 10.3, true, Category.OPCION1, true, "img",carrito1);
            Productos prod2 = new Productos(null, "raton", "raton de oro", 10.3, true, Category.OPCION2, true, "img",carrito1);
            Productos prod3 = new Productos(null, "carro", "carro de oro", 10.3, true, Category.OPCION3, true, "img",carrito1);
            repoProduco.saveAll(List.of(prod1,prod2,prod3));



                 //Esta es de paymentMethods
            PaymentMethods methods1 = new PaymentMethods(null, CardType.MASTER_CART, 254876L, LocalDate.of(1995, 1, 1), "258",u2);
            repoPaymet.save(methods1);

                //Esta es de orders = pedidos
            Orderss pedido1 = new Orderss(null, LocalDate.of(2024, 1, 1), State.PREPARATION, "direccion de envio", 2589.2,carrito1);
            repoOrderss.save(pedido1);



    }

}
