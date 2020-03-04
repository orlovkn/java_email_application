package com.ehoteam.java_email_application;

import java.util.Scanner;

public class Email {

    private String firstName;
    private String lastName;
    private String password;
    private String department;
    private String email;
    private int mailboxCapacity = 500;
    private int defaultPasswordength = 9;
    private String alternateEmail;
    private String companySuffix = "ehoteam.com";

    // constructor to receive the first and the last name
    public Email(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;

//        System.out.println ("EMAIL CREATED " + firstName + " " + lastName);

        // call the method asking for the department and returning for the department
        this.department = setDepartment ();
//        System.out.println ("Department is: " + this.department);

        // call a method that returns a random password
        this.password = randomPassword (defaultPasswordength);
//        System.out.println ("Your password is: " + this.password);

        // combine elements to generate email
        email = firstName.toLowerCase () + "." + lastName.toLowerCase () + "@" + department + "." + companySuffix;
//        System.out.println ("Your mail is: " + email);
    }

    // ask for the department
    private String setDepartment() {
        System.out.print (firstName + ", enter a department code\n1. for Sales\n2. for Development\n3. for Accounting\n0. for none\nEnter department code: ");
        Scanner in = new Scanner (System.in);
        int depChoise = in.nextInt ();

        if (depChoise == 1) {
            return "sales";
        } else if (depChoise == 2) {
            return "dev";
        } else if (depChoise == 3) {
            return "acc";
        } else {
            return "";
        }
    }

    // generate a random password
    private String randomPassword(int length) {
        String passwordSet = "ABCDEFGHIJKLMNOPQRSTUVWXYZ!@#%$";
        char[] password = new char[length];
        for (int i = 0; i < length; i++) {
            int rand = (int) (Math.random () * passwordSet.length ());
            password[i] = passwordSet.charAt (rand);
        }
        return new String (password);
    }

    // set the mailbox capacity
    public void setMailboxCapacity(int capacity) {
        this.mailboxCapacity = capacity;
    }

    // set the alternate email
    public void setAlternateEmail(String altEmail) {
        this.alternateEmail = altEmail;
    }

    // change the password
    public void changePassword(String password) {
        this.password = password;
    }

    public String getPassword() {
        return password;
    }

    public int getMailboxCapacity() {
        return mailboxCapacity;
    }

    public String getAlternateEmail() {
        return alternateEmail;
    }

    public String showInfo() {
        return "DISPLAY NAME: " + firstName + " " + lastName +
                "\nCOMPANY EMAIL: " + email +
                "\nEMAIL PASSWORD: " + password +
                "\nMAILBOX CAPACITY: " + mailboxCapacity + " mb";
    }
}
