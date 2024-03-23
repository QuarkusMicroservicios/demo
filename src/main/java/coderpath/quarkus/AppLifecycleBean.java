package coderpath.quarkus;

import io.quarkus.runtime.ShutdownEvent;
import io.quarkus.runtime.StartupEvent;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.enterprise.event.Observes;

import java.util.logging.Logger;

@ApplicationScoped
public class AppLifecycleBean {

    private static final    Logger LOGGER  = Logger.getLogger("ListnerBean");

    void onStart(@Observes StartupEvent evt) {
        LOGGER.info("The application is starting ...");
    }

    void onStop(@Observes ShutdownEvent evt){

        LOGGER.info("The application is stopping ...");
    }


}
