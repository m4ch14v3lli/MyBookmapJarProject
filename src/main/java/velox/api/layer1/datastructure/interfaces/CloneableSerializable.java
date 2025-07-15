package velox.api.layer1.datastructure.interfaces;

import java.io.Serializable;

public interface CloneableSerializable extends Cloneable, Serializable {
    Object clone();
}