package coolaid.nomorejumpscares;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public final class NoMoreJumpscares {

    public static final String MOD_ID = "nomorejumpscares";
    public static final Logger LOGGER = LoggerFactory.getLogger(MOD_ID);

    public static void init() {
        // Write common init code here.

        LOGGER.info("Successfully loaded NoMoreJumpscares!");
    }
}
