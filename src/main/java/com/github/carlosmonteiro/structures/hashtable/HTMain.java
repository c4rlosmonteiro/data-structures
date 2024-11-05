package com.github.carlosmonteiro.structures.hashtable;

public class HTMain {

    public static void main(final String [] args) {
        final HashTable<String> htMain = new HashTable<>();

        htMain.set("Abacaxi", "Abacaxi");
        htMain.set("Carro", "Carro");
        htMain.set("Uva", "Uva");
        htMain.set("Amor", "Amor");
        htMain.set("Roma", "Roma");
        htMain.set("Casa", "Casa");
        htMain.set("Asa", "Asa");
        htMain.set("Bola", "Bola");
        htMain.set("Balde", "Balde");
        htMain.set("Aste", "Aste");
        htMain.set("Sate", "Sate");

        System.out.println(htMain.print());
    }
}
