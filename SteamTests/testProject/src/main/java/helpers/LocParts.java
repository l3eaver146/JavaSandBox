package helpers;

import lombok.AccessLevel;
import lombok.AllArgsConstructor;
import lombok.Getter;

import java.util.Arrays;

@Getter
@AllArgsConstructor(access = AccessLevel.PRIVATE)
public enum LocParts {
    DISCOUNT("discount_pct"),
    PRICE("discount_original_price"),
    FINAL_PRICE("discount_final_price"),
    NAME("tab_item_name");
    private final String title;

    public static LocParts getByName(String name) {
        return Arrays.stream(LocParts.values())
                .filter(element -> element.title.equalsIgnoreCase(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException((String.format("Unsupported type %s", name))));
    }
}
