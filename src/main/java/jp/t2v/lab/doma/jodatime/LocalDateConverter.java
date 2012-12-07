package jp.t2v.lab.doma.jodatime;

import java.sql.Date;

import org.joda.time.LocalDate;
import org.seasar.doma.ExternalDomain;
import org.seasar.doma.jdbc.domain.DomainConverter;

@ExternalDomain
public class LocalDateConverter implements DomainConverter<LocalDate, Date> {

	@Override
	public Date fromDomainToValue(final LocalDate date) {
		return new Date(date.toDate().getTime());
	}

	@Override
	public LocalDate fromValueToDomain(final Date date) {
		return new LocalDate(date.getTime());
	}

}
