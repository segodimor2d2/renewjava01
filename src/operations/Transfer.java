package operations;

import java.util.ArrayList;

public class Transfer {
    public void deposit(){

        // Criar ArrayList de objetos (nesse caso, supondo que seja uma lista de contas bancárias)
        ArrayList<Account> accountList = new ArrayList<>();

        // Adicionar algumas contas para fins de exemplo
        accountList.add(new Account(1, "Tiago"));
        accountList.add(new Account(2, "João"));
        accountList.add(new Account(3, "Maria"));

        // ID que estamos procurando
        int targetId = 2;

        // Procurar o elemento com o ID especificado
        Account foundAccount = null;
        for (Account account : accountList) {
            if (account.getId() == targetId) {
                foundAccount = account;
                break; // Achamos o elemento, podemos sair do loop
            }
        }

        // Verificar se encontramos o elemento
        if (foundAccount != null) {
            System.out.println("Conta encontrada: " + foundAccount);
        } else {
            System.out.println("Conta com o ID " + targetId + " não encontrada.");
        }
    }
}

// Classe de exemplo para representar uma conta bancária
class Account {
    private int id;
    private String owner;

    public Account(int id, String owner) {
        this.id = id;
        this.owner = owner;
    }

    public int getId() {
        return id;
    }

    public String getOwner() {
        return owner;
    }

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", owner='" + owner + '\'' +
                '}';
    }
}

