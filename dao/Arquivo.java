/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package dao;
import estoque.*;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.text.DateFormat;
import java.text.FieldPosition;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.logging.Level;
import java.util.logging.Logger;
import org.json.simple.*;
import org.json.simple.parser.JSONParser;
import org.json.simple.parser.ParseException;

/**
 *
 * @author Hammsvietro
 */
public class Arquivo {
    private static Arquivo arquivo;
    
   public static Arquivo get() {
            if( arquivo == null )
                arquivo = new Arquivo();
            return arquivo;
    }
    public static void saveProdutos() throws IOException{
        
        JSONObject js = new JSONObject();
        File arquivo = new File("products.json");
        arquivo.delete();
        FileOutputStream out = new FileOutputStream(arquivo,false);
        out.write("".getBytes());
        out = new FileOutputStream(arquivo,false);
        ArrayList<Produto> products = Facade.getProdutos();
        for(Produto current : products){
            
            js.put("id", current.getId());
            js.put("nome", current.getNome());
            js.put("quantidade", current.getQuantidade());
            js.put("valor", current.getValor());
            
            
            
            try{
                System.out.println(js.toJSONString());
                out.write( (js.toJSONString()+"\n").getBytes() );
                
                
            } catch (IOException ex) {
                ex.printStackTrace();
            }

        }
        out.close();
        
    }
    
    public static void lerProdutos(){
        JSONObject jobj;
        JSONParser parser = new JSONParser();
        String line;
        
        try{
            FileReader file = new FileReader("products.json");
            BufferedReader buffer = new BufferedReader(file);
            while((line = buffer.readLine()) != null){
                jobj = (JSONObject) parser.parse(line);
                try{
                    Produto produto = new Produto();
                    produto.setId((long)jobj.get("id"));
                    produto.setQuantidade((long)jobj.get("quantidade"));
                    produto.setNome((String)jobj.get("nome"));
                    produto.setValor((double)jobj.get("valor"));
                    Facade.addProduto(produto);
                }
                catch(Exception q){
                    q.printStackTrace();
                }
                
                
                
            }
        } catch (FileNotFoundException ex) {
            ex.printStackTrace();
        } catch (IOException ex) {
            ex.printStackTrace();
        } catch (ParseException ex) {
            ex.printStackTrace();
        }
        System.err.println("Dados Salvos com sucesso!");
    }
  
}

