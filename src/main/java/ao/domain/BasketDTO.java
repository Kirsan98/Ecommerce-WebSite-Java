package main.java.ao.domain;

import java.util.HashMap;

import main.java.ao.domain.Reference;

public class BasketDTO {
    public final boolean isValidate;
    public final HashMap<Reference, CommandLine> commandLines;

    public BasketDTO(boolean isValidate, HashMap<Reference, CommandLine> commandLines) {
        this.isValidate = isValidate;
        this.commandLines = commandLines;
    }
}