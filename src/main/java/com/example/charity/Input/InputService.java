package com.example.charity.Input;

import com.example.charity.product.ProductRepository;
import com.example.charity.product.ProductStockRepository;
import com.example.charity.product.ProductsStock;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.io.FileInputStream;
import java.io.IOException;

@Service
public class InputService {

    @Resource
    ProductRepository productRepository;
    @Resource
    ProductStockRepository productStockRepository;

    public void updateGoodsQuantity() throws IOException {
        StringBuilder sb = getTextFromFIle();
        String textFromFile = sb.toString();
        String[] arrayFromFile = textFromFile.split(",\r\n");
        for (String lineFromFile : arrayFromFile) {
            String[] lineArray = lineFromFile.split(" ");
            ProductsStock productsStock = new ProductsStock();
            productsStock.setId(productRepository.getProductIdByName(lineArray[0]));
            productsStock.setQuantity(Integer.parseInt(lineArray[1]));
            productStockRepository.setQuantities(productsStock);
        }
    }

    private static StringBuilder getTextFromFIle() throws IOException {
        String filename = "goods.txt";
        FileInputStream fileInputStream = new FileInputStream(filename);
        int i;
        StringBuilder sb = new StringBuilder();
        while ((i = fileInputStream.read()) != -1) {
            sb.append((char) i);
        }
        return sb;
    }

}
