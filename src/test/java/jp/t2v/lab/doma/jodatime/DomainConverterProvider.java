package jp.t2v.lab.doma.jodatime;

import org.seasar.doma.DomainConverters;

@DomainConverters({DateTimeConverter.class, LocalDateConverter.class, LocalTimeConverter.class})
public class DomainConverterProvider {

}
