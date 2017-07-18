package de.fhac.rn.mazenet.client;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.HelpFormatter;
import org.apache.commons.cli.Option;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

/**
 * TODO: Teammitglieder: Person A, Person B, ...
 * 
 * TODO: Der Klassennamen muss zum Teamnamen refactort werden (keine
 * Leerzeichen, Umlaute, ...)
 */
public class Client {

    private static final String TEAMNAME = Client.class.getSimpleName();
    private static final String OPTION_HOSTNAME = "host";
    private static final String OPTION_PORT = "port";
    private static final String OPTION_TRUSTSTORE_PATH = "truststore";
    private static final String OPTION_HELP = "help";

    private static String hostname = "localhost";
    private static int port = 5123;
    private static String truststorePath = "";
    private static Options options = new Options();
    private static HelpFormatter formatter = new HelpFormatter();

    static {
        String descriptionHost = "Festlegen zu welchem Host verbunden werden soll";
        String descriptionPort = "Festlegen auf welchen Port auf dem Zielsystem verbunden werden soll";
        String descriptionTruststore = "Bei Verwendung von SSL/TLS wird hier der Pfad zum Truststore angegeben";
        String descriptionHelp = "Anzeigen dieser Hilfe";
        
        options.addOption(
                Option.builder().longOpt(OPTION_HOSTNAME).desc(descriptionHost).hasArg().argName("hostname").build());
        options.addOption(Option.builder().longOpt(OPTION_PORT).desc(descriptionPort).hasArg().argName("port").build());
        options.addOption(Option.builder().longOpt(OPTION_TRUSTSTORE_PATH).desc(descriptionTruststore).hasArg()
                .argName("truststore-path").build());
        options.addOption(Option.builder().longOpt(OPTION_HELP).desc(descriptionHelp).build());
    }

    private static void parseArgs(String[] args) {
        CommandLineParser commandLineParser = new DefaultParser();
        CommandLine commandLine = null;
        try {
            commandLine = commandLineParser.parse(options, args);
        } catch (ParseException e) {
            System.err.println("Ungültige Parameter vorhanden -> Anzeigen der Hilfe");
            formatter.printHelp(TEAMNAME, options);
            System.exit(1);
        }
        if (commandLine.hasOption(OPTION_HELP)) {
            formatter.printHelp(TEAMNAME, options);
            System.exit(0);
        }
        if (commandLine.hasOption(OPTION_HOSTNAME))
            hostname = commandLine.getOptionValue(OPTION_HOSTNAME);
        if (commandLine.hasOption(OPTION_PORT))
            port = Integer.parseInt(commandLine.getOptionValue(OPTION_PORT));
        if (commandLine.hasOption(OPTION_TRUSTSTORE_PATH))
            truststorePath = commandLine.getOptionValue(OPTION_TRUSTSTORE_PATH);
    }

    public static void main(String[] args) throws ParseException {
        parseArgs(args);
        System.out.println("Team: " + TEAMNAME);
        System.out.println("Host: " + hostname);
        System.out.println("Port: " + port);
    }

}
