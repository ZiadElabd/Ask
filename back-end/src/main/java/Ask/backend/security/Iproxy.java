package Ask.backend.security;

import org.bson.types.ObjectId;

public interface Iproxy {
    public ObjectId checkAcess(String id);
}
