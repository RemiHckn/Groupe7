/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package org.insset.server;

import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import org.insset.client.service.RomanConverterService;

/**
 *
 * @author user
 */
@SuppressWarnings("serial")
public class RomanConverterServiceImpl extends RemoteServiceServlet implements
        RomanConverterService {

    @Override
    public String convertDateYears(String nbr) throws IllegalArgumentException {
        //Implement your code
        return "XV/III/MX";
    }
    
    
    int value(char r) 
    { 
        if (r == 'I') 
            return 1; 
        if (r == 'V') 
            return 5; 
        if (r == 'X') 
            return 10; 
        if (r == 'L') 
            return 50; 
        if (r == 'C') 
            return 100; 
        if (r == 'D') 
            return 500; 
        if (r == 'M') 
            return 1000; 
        return -1; 
    } 
    
    @Override
    public Integer convertRomanToArabe(String nbr) throws IllegalArgumentException {
        //Implement your code
        ////////////////////////////////////////////////////////////////////////
        // Initialize result 
        int res = 0; 
  
        for (int i=0; i<nbr.length(); i++) 
        { 
            // Getting value of symbol s[i] 
            int s1 = value(nbr.charAt(i)); 
  
            // Getting value of symbol s[i+1] 
            if (i+1 <nbr.length()) 
            { 
                int s2 = value(nbr.charAt(i+1)); 
  
                // Comparing both values 
                if (s1 >= s2) 
                { 
                    // Value of current symbol is greater 
                    // or equalto the next symbol 
                    res = res + s1; 
                } 
                else
                { 
                    res = res + s2 - s1; 
                    i++; // Value of current symbol is 
                    // less than the next symbol 
                } 
            } 
            else
            { 
                res = res + s1; 
                i++; 
            } 
        } 
        
        return res; 
        ////////////////////////////////////////////////////////////////////////
    }

    @Override
    public String convertArabeToRoman(Integer nbr) throws IllegalArgumentException {
        //Implement your code
        ////////////////////////////////////////////////////////////////////////
        String roman="";
        int repeat;
       
 
        repeat=nbr/1000;
        for(int i=1; i<=repeat;i++){
            roman=roman+"M";
        }
        nbr=nbr%1000;
 
        repeat=nbr/900;
        for(int i=1; i<=repeat;i++){
            roman=roman+"CM";
        }
        nbr=nbr%900;
 
        repeat=nbr/500;
        for(int i=1; i<=repeat;i++){
            roman=roman+"D";
        }
        nbr=nbr%500;
 
        repeat=nbr/400;
        for(int i=1; i<=repeat;i++){
            roman=roman+"CD";
        }
        nbr=nbr%400;
 
        repeat=nbr/100;
        for(int i=1; i<=repeat;i++){
            roman=roman+"C";
        }
        nbr=nbr%100;
 
        repeat=nbr/90;
        for(int i=1; i<=repeat;i++){
            roman=roman+"XC";
        }
        nbr=nbr%90;
 
        repeat=nbr/50;
        for(int i=1; i<=repeat;i++){
            roman=roman+"L";
        }
        nbr=nbr%50;
 
        repeat=nbr/40;
        for(int i=1; i<=repeat;i++){
            roman=roman+"XL";
        }
        nbr=nbr%40;
 
        repeat=nbr/10;
        for(int i=1; i<=repeat;i++){
            roman=roman+"X";
        }
        nbr=nbr%10;
 
        repeat=nbr/9;
        for(int i=1; i<=repeat;i++){
            roman=roman+"IX";
        }
        nbr=nbr%9;
 
        repeat=nbr/5;
        for(int i=1; i<=repeat;i++){
            roman=roman+"V";
        }
        nbr=nbr%5;
 
        repeat=nbr/4; 
        for(int i=1; i<=repeat;i++){
            roman=roman+"IV";
        }
        nbr=nbr%4;
 
        repeat=nbr/1; // or simply repeat=n or i<=n in the condition part of the loop
        for(int i=1; i<=repeat;i++){
            roman=roman+"I";
        }
    
        return roman;
        ////////////////////////////////////////////////////////////////////////
    }

}
