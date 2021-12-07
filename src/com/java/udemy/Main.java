package com.java.udemy;

import model.entities.Account;
import model.entities.exceptions.DomainException;

import java.util.Locale;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) throws DomainException {

        Locale.setDefault(Locale.US);
        Scanner tc = new Scanner(System.in);

        System.out.println("Enter account data: ");
        System.out.print("Number: ");
        int number = tc.nextInt();
        System.out.print("Holder: ");
        tc.nextLine();
        String holder = tc.nextLine();
        System.out.print("Initial balance: ");
        double balance = tc.nextDouble();
        System.out.print("Withdraw limit: ");
        double withdrawLimit = tc.nextDouble();
        Account acc = new Account(number, holder, balance, withdrawLimit);

        System.out.println();
        System.out.print("Enter amount for withdraw: ");
        double withdraw = tc.nextDouble();

        try {
            acc.withdraw(withdraw);
            System.out.println("New balance: " + String.format("%.2f", acc.getBalance()));
        }
        catch (DomainException e) {
            System.out.println("Withdraw Error: "+ e.getMessage());
        } catch (RuntimeException e) {
            System.out.println("Unexpected error! ");
        }

        tc.close();

    }
}
