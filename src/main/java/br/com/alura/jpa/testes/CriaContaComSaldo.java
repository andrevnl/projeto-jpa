package br.com.alura.jpa.testes;

import br.com.alura.jpa.modelo.Conta;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class CriaContaComSaldo {

    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("contas");
        EntityManager em = emf.createEntityManager();

        Conta conta = new Conta();
        conta.setTitular("Márcia");
        conta.setNumero(12345);
        conta.setAgencia(54321);
        conta.setSaldo(100.00);

        em.getTransaction().begin();

        em.persist(conta);

        em.getTransaction().commit();

        em.close();

        EntityManager em2 = emf.createEntityManager();
        System.out.println("Id da conta da Márcia: " + conta.getId());
        conta.setSaldo(500.0);

        em2.getTransaction().begin();
        em2.merge(conta);
        em2.getTransaction().commit();
    }
}
