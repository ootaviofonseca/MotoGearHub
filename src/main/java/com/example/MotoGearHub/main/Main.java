//package com.example.MotoGearHub.main;
//
//import com.example.MotoGearHub.model.Brand;
//import com.example.MotoGearHub.model.Product;
//import com.example.MotoGearHub.model.ProductCategory;
//import com.example.MotoGearHub.repository.BrandRepository;
//
//import java.math.BigDecimal;
//import java.util.*;
//
//public class Main {
//    private Scanner input = new Scanner(System.in);
//    private BrandRepository repository;
//
//
//    private List<Brand> allBrands = new ArrayList<>();
//    public Main(BrandRepository brandRepository){
//        this.repository = brandRepository;
//    }
//    public void displayMenu(){
//        var option = -1;
//        while (option != 0){
//            var menu = """
//
//        *** MOTOGEAR HUB ***
//        \n
//        1 - Register Brand
//        2 - Register Item
//        3 - Search Items by Brand
//        4 - Search Items by Type
//        5 - Brand Information
//
//        0 - Exit
//        """;
//
//            System.out.println(menu);
//            option = input.nextInt();
//            input.nextLine();
//            switch (option) {
//                case 1:
//                    registerBrand();
//                    break;
//                case 2:
//                    registerProduct();
//                    break;
//                case 3:
//                    listProductsbyBrand();
//                    break;
//                case 4:
//                    listProductsByType();
//                case 5:
//                    brandInfo();
//                    break;
//                case 0:
//                    System.out.println("Exiting...");
//                    break;
//
//                default:
//                    System.out.println("Invalid option");
//            }
//        }
//    }
//
//    private void registeredBrands(){
//        allBrands =  repository.findAll();
//        allBrands.stream()
//                .sorted(Comparator.comparing(Brand::getName))
//                .forEach(b -> System.out.println(b.getName()));
//    }
//
//    private Optional<Brand> findBrand(){
//        registeredBrands();
//        System.out.println("\n\nWrite one of the brands listed above:");
//        var nameBrand = input.nextLine().toUpperCase();
//
//        Optional<Brand> brand = repository.findByNameContainingIgnoreCase(nameBrand);
//
//        return  brand;
//    }
//
//    private void registerBrand() {
//        System.out.println("Enter the brand name: ");
//        var name = input.nextLine().toUpperCase();
//
//        System.out.println("Enter the country of origin: ");
//        var country = input.nextLine();
//
//        System.out.println("Enter the contact email: ");
//        var email = input.nextLine();
//
//        System.out.println("Enter the CNPJ");
//        var cnpj = input.nextLine();
//
//        Brand brand = new Brand(name, country, email, cnpj);
//        repository.save(brand);
//
//    }
//
//    private void registerProduct() {
//
//        Optional<Brand> brand = findBrand();
//
//        if(brand.isPresent()){
//            System.out.println("Enter the product name: ");
//            var name = input.nextLine();
//
//            List<ProductCategory> categories = Arrays.asList(ProductCategory.values());
//            categories.stream()
//                    .forEach(System.out::println);
//            System.out.println("\nType one of the categories: "  );
//            var categoryInput = input.nextLine().toUpperCase();
//
//            ProductCategory category;
//            try {
//                category = ProductCategory.valueOf(categoryInput);
//            } catch (IllegalArgumentException e) {
//                System.out.println("Invalid category. Please try again.");
//                return;
//            }
//
//            System.out.println("Enter the color: ");
//            var color = input.nextLine();
//
//            System.out.println("Enter the quantity in stock:");
//            var stock = input.nextInt();
//            input.nextLine();
//
//            System.out.println("Enter the price: ");
//            while (!input.hasNextBigDecimal()){
//                System.out.println("Invalid input, format (9,99): ");
//                input.next();
//            }
//
//            var price = input.nextBigDecimal();
//            input.nextLine();
//
//            System.out.println("Enter a description: ");
//            var description = input.nextLine();
//
//            Product product = new Product(name,category,color,stock,price,description);
//            var foundBrand = brand.get();
//
//            product.setBrand(foundBrand);
//            foundBrand.addProduct(product);
//            repository.save(foundBrand);
//        }else {
//            System.out.println("Brand not founded");
//        }
//    }
//
//    private void listProductsbyBrand() {
//        Optional<Brand> brand = findBrand();
//
//            if(brand.isPresent()){
//                List<Product> productsByBrand = repository.findByBrand(brand.get().getId());
//
//                System.out.println(productsByBrand);
//
//            }
//
//
//    }
//
//    private void listProductsByType() {
//        ProductCategory[] categories = ProductCategory.values();
//
//        System.out.println("Choose a product category:");
//
//        for (int i = 0; i < categories.length; i++) {
//            System.out.printf("%d - %s%n", i + 1, categories[i].getDisplayName());
//        }
//
//        int choice = -1;
//        while (choice < 1 || choice > categories.length) {
//            System.out.print("Enter the number of the category: ");
//            if (input.hasNextInt()) {
//                choice = input.nextInt();
//                var category = categories[choice - 1];
//                List<Product> porductsByCategory =  repository.listProductsByCategory(category);
//                porductsByCategory.stream()
//                        .forEach(System.out::println);
//
//            } else {
//                input.nextLine();
//                System.out.println("Invalid input. Please enter a number.");
//            }
//        }
//        input.nextLine();
//
//    }
//
//    private void brandInfo() {
//        Optional<Brand> brand = findBrand();
//
//        if(brand.isPresent()){
//
//            System.out.println(brand.get().getSummary());
//        }
//    }
//}
