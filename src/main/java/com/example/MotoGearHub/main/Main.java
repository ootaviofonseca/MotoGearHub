package com.example.MotoGearHub.main;

import com.example.MotoGearHub.model.Brand;
import com.example.MotoGearHub.repository.ProductsRepository;
import jdk.jfr.Category;

import java.util.Scanner;

public class Main {
    private Scanner input = new Scanner(System.in);
    private ProductsRepository repository;

    public Main(ProductsRepository repository){this.repository = repository;}
    public void displayMenu(){
        var option = -1;
        while (option != 0){
            var menu = """
        
        *** MOTOGEAR HUB ***
        \n
        1 - Register Brand
        2 - Register Item
        3 - List Items
        4 - Search Items by Brand
        5 - Search Items by Type
        6 - Brand Information
        
        0 - Exit                           
        """;

            System.out.println(menu);
            option = input.nextInt();
            input.nextLine();
            switch (option) {
                case 1:
                    registerBrand();
                    break;
                case 0:
                    System.out.println("Exiting...");
                    break;
                default:
                    System.out.println("Invalid option");
            }
        }
    }

    private void registerBrand() {
        System.out.println("Enter the brand name: ");
        var name = input.nextLine();

        System.out.println("Enter the country of origin: ");
        var country = input.nextLine();

        System.out.println("Enter the contact email: ");
        var email = input.nextLine();

        System.out.println("Enter the CNPJ");
        var cnpj = input.nextLine();

        Brand brand = new Brand(name, country, email, cnpj);
        repository.save(brand);



    }
}
