package velox.api.layer1.data;

import java.util.List;

public interface SimpleLookupInfo extends LookupInfo {
    List<LookupSubscribeInfo> get(SubscribeInfo subscribeInfo);
}