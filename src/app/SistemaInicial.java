package app;

import entities.ContaBancaria;
import interfaces.Conta;

import java.util.ArrayList;

public class SistemaInicial {
    private ArrayList<Conta> contas;

    public SistemaInicial() {
        this.contas = new ArrayList<>();
        contas.add(new ContaBancaria("789456", "Mick Jagger", 1));
        contas.add(new ContaBancaria("321539", "Maik Tyson", 1));
        contas.add(new ContaBancaria("666666", "Angus Young", 1));
        contas.add(new ContaBancaria("147951", "Cindy Louper", 1));
        contas.add(new ContaBancaria("888488", "Mohamed Ali", 1));
    }

    public ArrayList<Conta> getContas() {
        return this.contas;
    }
}