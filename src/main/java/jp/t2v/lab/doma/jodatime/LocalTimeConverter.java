package jp.t2v.lab.doma.jodatime;

import java.sql.Time;

import org.joda.time.LocalTime;
import org.seasar.doma.ExternalDomain;
import org.seasar.doma.jdbc.domain.DomainConverter;

@ExternalDomain
public class LocalTimeConverter implements DomainConverter<LocalTime, Time> {

	@Override
	public Time fromDomainToValue(final LocalTime time) {
		return new Time(time.toDateTimeToday().toDate().getTime());
	}

	@Override
	public LocalTime fromValueToDomain(final Time time) {
		return new LocalTime(time.getTime());
	}

}
