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

    private static final String TEAMNAME = Client.class.getSimpleName();
    private static final String hostnameOptionShortName = "h";
    private static final String portOptionsShortName = "p";
    private static final String truststorePathShortOptionName = "t";

    private static String hostname = "localhost";
    private static int port = 5123;
    private static String truststorePath = "";

    public static void main(String[] args) throws ParseException {
        Options options = new Options();
        options.addOption(hostnameOptionShortName, true, "Host");
        options.addOption(portOptionsShortName, true, "Port");
        options.addOption(truststorePathShortOptionName, true, "Truststore path");
        CommandLineParser commandLineParser = new DefaultParser();
        CommandLine commandLine = commandLineParser.parse(options, args);
        if (commandLine.hasOption(hostnameOptionShortName))
            hostname = commandLine.getOptionValue(hostnameOptionShortName);
        if (commandLine.hasOption(portOptionsShortName))
            port = Integer.parseInt(commandLine.getOptionValue(portOptionsShortName));
        if (commandLine.hasOption(truststorePathShortOptionName))
            truststorePath = commandLine.getOptionValue(truststorePathShortOptionName);
        System.out.println("Team: " + TEAMNAME);
        System.out.println("Host: " + hostname);
        System.out.println("Port: " + port);
    }

}
