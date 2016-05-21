/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.backend.run;

import com.backend.entities.Product;
import com.backend.services.ShopProductService;
import java.util.Date;

/**
 *
 * @author armen arzumanyan
 */
public class SaveToMongo {
    public static void main(String args[]){
        ShopProductService run = new ShopProductService();
        Product product = new Product();
        product.setCategoryId(1L);
        product.setName("ProdcutName");
        product.setPrice(50000l);
        product.setLastUpdate(new Date(System.currentTimeMillis()));
        
        run.save(product);
    }
}
