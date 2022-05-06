package Flight;
import Flight.FlightData;
import Flight.InputFile;
import java.io.IOException;


public interface validators {

    boolean validate(InputFile inputFile , FlightData dbInstance)throws IOException;

}
