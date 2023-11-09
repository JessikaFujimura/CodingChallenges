///usr/bin/env jbang "$0" "$@" ; exit $?
//DEPS info.picocli:picocli:4.6.3


import picocli.CommandLine;
import picocli.CommandLine.Command;
import picocli.CommandLine.Parameters;

import java.util.concurrent.Callable;

@Command(name = "ccwc", mixinStandardHelpOptions = true, version = "ccwc 0.1",
        description = "ccwc made with jbang")
class ccwc implements Callable<Integer> {

    @Parameters(index = "0", description = "The greeting to print", defaultValue = "Jessika!")
    private String greeting;

    public static void main(String... args) {
        int exitCode = new CommandLine(new ccwc()).execute(args);
        System.exit(exitCode);
    }

    @Override
    public Integer call() throws Exception { // your business logic goes here...
        System.out.println("Hello " + greeting);
        return 0;
    }
}
