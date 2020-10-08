package main.java.ao.infra;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import main.java.ao.domain.Basket;
import main.java.ao.domain.BasketDTO;
import main.java.ao.domain.Reference;
import main.java.ao.domain.BasketRepository;

public class BasketRepoJSON implements BasketRepository {
    @Override
    public void save(Basket basket) {
        BasketDTO basketDTO= basket.getDTO();
        StringBuffer jsonBuffer = new StringBuffer();
        BufferedWriter writer;

        jsonBuffer.append("{\n\tisValidate: " + basketDTO.isValidate + ";\n");
        jsonBuffer.append("\tcommandLines: [\n");
        for (Reference ref : basketDTO.commandLines.keySet()) {
            jsonBuffer.append("\t\t{\n");
            jsonBuffer.append("\t\t\t\"ref\": " + "\"" + ref.getid() +"\";\n");
            jsonBuffer.append("\t\t\t\"name\": \"" + ref.getName() + "\";\n");
            jsonBuffer.append("\t\t\t\"description\": \"" + ref.getDescription() + "\";\n");
            jsonBuffer.append("\t\t\t\"price\": \"" + ref.getPrice()+ "\";\n");
            jsonBuffer.append("\t\t\t\"quantity\": \"" + basketDTO.commandLines.get(ref) + "\";\n");
            jsonBuffer.append("\t\t},\n");
        }
        jsonBuffer.append("\t]\n");
        jsonBuffer.append("}\n");

        try {
            writer = new BufferedWriter(new FileWriter("./save.json"));
            writer.write(jsonBuffer.toString());
            writer.close();
        } catch (IOException e) {
            System.exit(0); // Pour renvoyer une exception faut modifier l'interface, moche ?
        }
    }

    @Override
    public Basket load() {
        return null;
    }

}