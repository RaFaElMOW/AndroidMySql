//Data transfer object

package com.example.a3ainfo.mysql_livrob;

public class DtoLIvro {
    String nome, autor, genero;
    int id;

    public String toString(){
        return autor+": "+nome;
    }

}
