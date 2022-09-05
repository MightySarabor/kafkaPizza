package myapps;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;

/**
 * An interface for registering types that can be de/serialized with {@link JSONSerde}.
 */
@SuppressWarnings("DefaultAnnotationParam") // being explicit for the example
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "_t")
@JsonSubTypes({
        //@JsonSubTypes.Type(value = PageView.class, name = "pv"),
        //@JsonSubTypes.Type(value = UserProfile.class, name = "up"),
        //@JsonSubTypes.Type(value = PageViewByRegion.class, name = "pvbr"),
        //@JsonSubTypes.Type(value = WindowedPageViewByRegion.class, name = "wpvbr"),
       //@JsonSubTypes.Type(value = RegionCount.class, name = "rc")
})
public interface JSONSerdeCompatible {

}
