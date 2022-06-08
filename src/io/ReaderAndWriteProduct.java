package io;

import Model.Product;

import java.io.*;
import java.util.ArrayList;

public class ReaderAndWriteProduct {
    File file = new File("D:\\Module2\\qlsp\\src\\data\\poduct.csv");

    public void Write(ArrayList<Product> products) {
        try {
            FileWriter fileWriter = new FileWriter(file);
            BufferedWriter bufferedWriter = new BufferedWriter(fileWriter);
            bufferedWriter.write("id,name,amount,priceP,describeP");
            bufferedWriter.newLine();
            for (Product p : products) {
                bufferedWriter.write(p.write());
                bufferedWriter.newLine();
            }
            bufferedWriter.close();
            fileWriter.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public ArrayList<Product> reader() {
        ArrayList<Product> products = new ArrayList<>();
        try {
            FileReader fileReader = new FileReader(file);
            BufferedReader bufferedReader = new BufferedReader(fileReader);
            String str = bufferedReader.readLine();
            while ((str = bufferedReader.readLine()) != null) {
                String[] arr = str.split(",");
                int id = Integer.parseInt(arr[0]);
                String name = arr[1];
                int amount = Integer.parseInt(arr[2]);
                double priceP  =Double.parseDouble(arr[3]) ;
                String describeP = arr[4];


                products.add(new Product(id,name,amount,priceP,describeP));
            }

            bufferedReader.close();
            fileReader.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return products;
    }
}
