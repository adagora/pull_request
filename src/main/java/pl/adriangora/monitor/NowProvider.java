package pl.adriangora.monitor;

import java.time.ZonedDateTime;

public interface NowProvider {
    ZonedDateTime now();
}
