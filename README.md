# Doma Domain Converters for Joda-Time

[Domain Converters](http://doma.seasar.org/reference/domain.html#%E5%A4%96%E9%83%A8%E3%83%89%E3%83%A1%E3%82%A4%E3%83%B3%E5%AE%9A%E7%BE%A9) of [Doma](http://doma.seasar.org/index.html) for [Joda-Time](http://joda-time.sourceforge.net/)

# Usage

1. Add converter classes into the `@DomainConverters` annotation parameter.
    for example
    
    ```java
    
    import jp.t2v.lab.doma.jodatime.DateTimeConverter;
    import jp.t2v.lab.doma.jodatime.LocalDateConverter;
    import jp.t2v.lab.doma.jodatime.LocalTimeConverter;
    import org.seasar.doma.DomainConverters;
    
    @DomainConverters({DateTimeConverter.class, LocalDateConverter.class, LocalTimeConverter.class})
    public class DomainConverterProvider {}
    ```

1. Add processor option of the Annotation Processing
    - the key is `domain.converters`
    - the value is the FQCN that is annotated by `@DomainConverters`


