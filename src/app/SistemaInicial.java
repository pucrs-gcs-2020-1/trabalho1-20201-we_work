package app;

import entities.ContaBancaria;
import interfaces.Conta;

import java.util.ArrayList;

public class SistemaInicial {
    private ArrayList<Conta> contas;

    public SistemaInicial() {
        this.contas = new ArrayList<>();
        Conta c1 = new ContaBancaria("789456", "Mick Jagger",200);
        Conta c2 = new ContaBancaria("321539", "Maik Tyson", 5000);
        Conta c3 = new ContaBancaria("666666", "Angus Young", 8000);
        Conta c4 = new ContaBancaria("147951", "Cindy Louper", 808);
        Conta c5 = new ContaBancaria("888488", "Mohamed Ali", 10);
        contas.add(c1);
        contas.add(c2);
        contas.add(c3);
        contas.add(c4);
        contas.add(c5);
    }

    public ArrayList<Conta> getContas(){
        return this.contas;
    }
}