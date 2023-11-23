package acorn.annotation.sample2;

import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;

@Retention( RetentionPolicy.RUNTIME)
public @interface WeekDaysAvail {
	WeekDay[] value();
}
