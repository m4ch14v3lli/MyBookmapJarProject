package velox.api.layer0.credentialscomponents;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.apache.commons.lang3.tuple.Pair;

/**
 * Concrete implementation of CredentialsComponent for text field-type credentials.
 */
public class CredentialsTextField extends BaseCredentialsComponent {

    private final Map<String, CredentialsSerializationField> values = new HashMap<>();

    @Override
    public void addSettingsChangedListener(Runnable runnable) {
        // Logic for triggering UI or system listeners (backend signal handling).
    }

    @Override
    public Map<String, CredentialsSerializationField> getValues() {
        return values;
    }

    @Override
    public void setValues(Map<String, CredentialsSerializationField> values) {
        this.values.clear();
        this.values.putAll(values);
    }

    @Override
    public List<Pair<String, String>> getAliases() {
        return List.of(Pair.of("oldFieldName", "newFieldName"));
    }
}
