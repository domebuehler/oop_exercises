package ch.hslu.oop.sw11;

public class Main {

    public static void main(String[] args) {

        UseDataStreams dataStreams = new UseDataStreams();
        //dataStreams.writeStringInFile("*#||¢{}[]àé££");
        //dataStreams.writeIntInFile(18749);
        //dataStreams.printDataStream();
        dataStreams.writeSomeTypes(123938021, 'd', 2984734.443f);
        dataStreams.printReadSomeTypes();
    }
}
