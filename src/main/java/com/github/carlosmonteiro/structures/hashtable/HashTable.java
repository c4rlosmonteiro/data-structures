package com.github.carlosmonteiro.structures.hashtable;

import com.github.carlosmonteiro.structures.Node;

public class HashTable<T> {
    private int size = 7;
    private HTNode<T>[] dataMap;

    public HashTable() {
        this.dataMap = new HTNode[size];
    }

    public void set(final String key, final T value) {
        final int hash = hash(key);
        HTNode<T> node = dataMap[hash];
        final HTNode<T> newNode = new HTNode<>(key, value);

        if (node == null) {
            dataMap[hash] = newNode;
        } else {
            while (node.hasNext()) {
                node = node.getNext();
            }

            node.setNext(newNode);
        }
    }

    /**
     * The % part of the calculation
     * with made the returned value
     * always be something between
     * 0 and (size - 1), as it is the
     * rest of the division. This will
     * ensure the generate hash will be
     * one of the indexes of our hash table.
     */
    private int hash(final String key) {
        int hash = 0;
        char[] keyChars = key.toCharArray();

        for (final int asciiValue : keyChars) {
            hash = (hash + asciiValue * 23) % size;
        }

        return hash;
    }

    public String print() {
        final StringBuilder stringBuilder = new StringBuilder();

        for (HTNode<T> data : dataMap) {
            HTNode<T> aux = data;

            if (aux == null) {
                stringBuilder.append("{}");
            }

            while (aux != null) {
                stringBuilder.append("{k=");

                stringBuilder.append(aux.getKey());
                stringBuilder.append(",v=");
                stringBuilder.append(aux);
                aux = aux.getNext();

                stringBuilder.append("} ");
            }

            stringBuilder.append("\n");
        }

        stringBuilder.append("l=").append(size);
        return stringBuilder.toString();
    }
}
