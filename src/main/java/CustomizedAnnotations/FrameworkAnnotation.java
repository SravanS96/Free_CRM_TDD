package CustomizedAnnotations;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.METHOD)
public @interface FrameworkAnnotation {
    public String[] addAuthors();
    public String[] addCategories();
}
/*
*
*
*    To get Author name and category type in Extent Reports,
*    We have to add "@FrameworkAnnotation()" to every test case.
*
*
*
*
 */
