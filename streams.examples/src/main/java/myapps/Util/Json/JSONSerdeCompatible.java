package myapps.Util.Json;

import com.fasterxml.jackson.annotation.JsonSubTypes;
import com.fasterxml.jackson.annotation.JsonTypeInfo;
import myapps.pojos.OrderPOJO;
import myapps.pojos.PizzaPOJO;

/**
 * An interface for registering types that can be de/serialized with {@link JSONSerde}.
 */
@SuppressWarnings("DefaultAnnotationParam") // being explicit for the example
@JsonTypeInfo(use = JsonTypeInfo.Id.NAME, include = JsonTypeInfo.As.PROPERTY, property = "_t")
@JsonSubTypes({
        @JsonSubTypes.Type(value = OrderPOJO.class, name = "order"),
        @JsonSubTypes.Type(value = PizzaPOJO.class, name = "pizza"),
        //@JsonSubTypes.Type(value = PageViewByRegion.class, name = "pvbr"),
        //@JsonSubTypes.Type(value = WindowedPageViewByRegion.class, name = "wpvbr"),
       //@JsonSubTypes.Type(value = RegionCount.class, name = "rc")
})
public interface JSONSerdeCompatible {

}
