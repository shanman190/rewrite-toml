package org.openrewrite.toml.marker;

import lombok.Value;
import lombok.With;
import org.openrewrite.marker.Marker;

import java.util.UUID;

@Value
@With
public class InlineTable implements Marker {
    UUID id;
}
