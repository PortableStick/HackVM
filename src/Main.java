import com.gregoftheweb.HackMacros;
import com.gregoftheweb.Parser;
import com.gregoftheweb.Translator;
import com.gregoftheweb.Utils;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        boolean debug = false;

        if (args.length == 0) {
            System.out.print("Usage: hackvm <path to file or directory>");
            System.exit(1);
        }

        String inputName = args[0];
        String outputName = Utils.getOutputName(inputName);

        if(args.length >= 2) {
            switch(args[1]) {
                case "--debug":
                    System.out.println("Skipping bootstrap code");
                    debug = true;
                    break;
                default:
                    break;
            }
        }

        try (Stream<Path> paths = Files.walk(Paths.get(inputName))) {
            BufferedWriter bw = new BufferedWriter(new FileWriter(outputName));
            if(!debug) {
                bw.write(HackMacros.getBootstrap());
            }
            paths.filter(Files::isRegularFile)
                    .filter(f -> f.toString().toLowerCase().endsWith(".vm"))
                    .sorted((a, b) -> {
                        if(a.endsWith("Sys.vm")) {
                            return -1;
                        } else if(b.endsWith("Sys.vm")) {
                            return 1;
                        }
                        else return a.compareTo(b);
                    })
                    .flatMap(f -> {
                        List<List<String>> result = new ArrayList<>();
                        Parser parser = new Parser(f);
                        while(parser.hasMoreCommands()) {
                            result.add(parser.getNextCommand());
                        }
                        return result.stream();
                    })
                    .map(Translator::translateCommand)
                    .forEach(l -> {
//                        System.out.println(String.format("Now writing %s", l));
                        try {
                            bw.write(l);
                        } catch(IOException ioe) {
                            System.out.println("There was an issue");
                            ioe.printStackTrace();
                        }
                    });
            bw.close();

        } catch (IOException ioe) {
            System.out.println("There was an issue");
            ioe.printStackTrace();
        }
    }

}
