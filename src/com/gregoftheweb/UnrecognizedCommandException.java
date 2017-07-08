package com.gregoftheweb;

import java.util.List;

public class UnrecognizedCommandException extends Exception {
    String command;

    public UnrecognizedCommandException(String command) {
        this.command = command;
    }

    public UnrecognizedCommandException(String[] command) {
        this.command = String.join(" ", command);
    }

    public UnrecognizedCommandException(List<String> command) {
        this.command = String.join(" ", command);
    }

    public void printMessage() {
        System.out.println(String.format("The command %s is not recognized", this.command));
    }
}
