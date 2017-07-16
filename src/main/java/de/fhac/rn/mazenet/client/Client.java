package de.fhac.rn.mazenet.client;

import org.apache.commons.cli.CommandLine;
import org.apache.commons.cli.CommandLineParser;
import org.apache.commons.cli.DefaultParser;
import org.apache.commons.cli.Options;
import org.apache.commons.cli.ParseException;

/**
 * Teammitglieder: Person A, Person B, ...
 * 
 * TODO: Der Klassennamen muss zum Teamnamen refactort werden
 */
public class Client {

    // TODO
    private static final String TEAMNAME = "hier Teamnamen eintragen";
    private static String HOSTNAME = "localhost";
    private static int PORT = 5123;
    private static String TRUSTSTORE_PATH = "";
    private static String hostnameOptionShortName = "h";
    private static String portOptionsShortName = "p";
    private static String truststorePathShortOptionName = "tp";

    public static void main(String[] args) throws ParseException {
        System.out.println("----------");
        System.out.println("clientstub");
        System.out.println("----------");
        Options options = new Options();
        options.addOption(hostnameOptionShortName, true, "Host");
        options.addOption(portOptionsShortName, true, "Port");
        options.addOption(truststorePathShortOptionName, true, "Truststore path");
        CommandLineParser commandLineParser = new DefaultParser();
        CommandLine commandLine = commandLineParser.parse(options, args);
        if (commandLine.hasOption(hostnameOptionShortName))
            HOSTNAME = commandLine.getOptionValue(hostnameOptionShortName);
        if (commandLine.hasOption(portOptionsShortName))
            PORT = Integer.parseInt(commandLine.getOptionValue(portOptionsShortName));
        if (commandLine.hasOption(truststorePathShortOptionName))
            TRUSTSTORE_PATH = commandLine.getOptionValue(truststorePathShortOptionName);
    }

}
