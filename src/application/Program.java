package application;

import db.DB;
import model.dao.DaoFactory;
import model.dao.SellerDao;
import model.entities.Department;
import model.entities.Seller;

import java.sql.Connection;
import java.util.Date;
import java.util.List;

public class Program {
    public static void main(String[] args) {

        /*testing connection and classes from model.entities
        Connection conn = DB.getConnection();
       Department obj = new Department(1, "Books");
        Seller seller = new Seller(21, "Bob", "bob@gmail.com", new Date(), 3000.0, obj);

        SellerDao sellerDao = DaoFactory.createSellerDao();

        System.out.println(obj);
        System.out.println(seller);*/

        SellerDao sellerDao = DaoFactory.createSellerDao();

        System.out.println("=== TEST 1: seller findById ====");
        Seller seller = sellerDao.findById(3);
        System.out.println(seller);

        System.out.println("=== TEST 2: seller findByDepartment ====");
        Department department = new Department(2, null);
        List<Seller> list = sellerDao.findByDepartment(department);
        for (Seller obj : list) {
            //Para cada objeto tipo Seller na minha List list, eu vou mandar imprimir o objeto tipo Seller
            System.out.println(obj);

        }
        System.out.println("=== TEST 3: seller findByAll ====");
        list = sellerDao.findAll();
        for (Seller obj : list) {
            //Para cada objeto tipo Seller na minha List list, eu vou mandar imprimir o objeto tipo Seller
            System.out.println(obj);

        }

        System.out.println("=== TEST 4: seller insert ====");
        Seller newSeller = new Seller(null, "Greg", "greg@gmail.com", new Date(), 4000.0, department);
        sellerDao.insert(newSeller);
        System.out.println("Inserted! New id = " + newSeller.getId());


        System.out.println("=== TEST 5: seller update ====");
        seller = sellerDao.findById(1);
        seller.setName("Martha Updated");
        sellerDao.update(seller);
        System.out.println("Update completed" + seller);

        DB.closeConnection();
    }
}

