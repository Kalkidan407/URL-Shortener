package com.urlshrtner.project.utility;

import java.util.Random;

public class ShortCodeGenerator {


     public String generate() {

      String characters = 
            "ABCDEFGHIJKLMNOPQRSTUVWXYZabcdefghijklmnopqrstuvwxyz0123456789";

      int length = 6;

     StringBuilder shortCode = new StringBuilder();

     Random random = new Random();

      for (int i=0; i<length; i++) {

        int index = random.nextInt(characters.length());

        shortCode.append(characters.charAt(index));
      }

     return shortCode.toString();
}


}
