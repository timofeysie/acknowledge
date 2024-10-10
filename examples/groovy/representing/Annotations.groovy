// Java
public @interface FeatureRequest {
    String key();
    String summary();
    String assignee() default "[unassigned]";
    String status() default "[open]";
    String targetVersion() default "[unassigned]";
}

@FeatureRequest(
    key="GROOVY-9999",
    summary="Support Graphical Annotations",
    assignee="Pete",
    status="Open",
    targetVersion="5.0"
)
class SomeClassWhereFeatureCouldBeUsed {
   // ...
}
