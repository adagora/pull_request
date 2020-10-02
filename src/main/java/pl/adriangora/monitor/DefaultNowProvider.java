package pl.adriangora.monitor;

import java.time.ZonedDateTime;
import org.springframework.stereotype.Component;

@Component
public class DefaultNowProvider implements NowProvider {

    @Override
    public ZonedDateTime now() {
        return ZonedDateTime.now();
    }
}
