package jp.t2v.lab.doma.jodatime;

import java.sql.Timestamp;

import org.joda.time.DateTime;
import org.seasar.doma.jdbc.domain.DomainConverter;
import org.seasar.doma.ExternalDomain;

@ExternalDomain
public class DateTimeConverter implements DomainConverter<DateTime, Timestamp> {

	@Override
	public Timestamp fromDomainToValue(final DateTime dateTime) {
		return dateTime == null ? null : new Timestamp(dateTime.toDate().getTime());
	}

	@Override
	public DateTime fromValueToDomain(final Timestamp timestamp) {
		return timestamp == null ? null : new DateTime(timestamp.getTime());
	}

}
