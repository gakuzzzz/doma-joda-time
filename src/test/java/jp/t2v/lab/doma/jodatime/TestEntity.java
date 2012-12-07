package jp.t2v.lab.doma.jodatime;

import org.joda.time.DateTime;
import org.joda.time.LocalDate;
import org.joda.time.LocalTime;
import org.seasar.doma.Entity;
import org.seasar.doma.Table;
import org.seasar.doma.jdbc.entity.NamingType;

@Entity(naming = NamingType.SNAKE_UPPER_CASE)
@Table(name = "test")
public final class TestEntity implements Cloneable {

	private DateTime dateTime;
	private LocalDate localDate;
	private LocalTime localTime;
	
	public TestEntity() {
		
	}
	
	public TestEntity(final DateTime dateTime, final LocalDate localDate, final LocalTime localTime) {
		this.dateTime = dateTime;
		this.localDate = localDate;
		this.localTime = localTime;
	}

	public DateTime getDateTime() {
		return dateTime;
	}

	public LocalDate getLocalDate() {
		return localDate;
	}

	public LocalTime getLocalTime() {
		return localTime;
	}

	@Override
	public TestEntity clone() {
		try {
			return (TestEntity) super.clone();
		} catch (final CloneNotSupportedException ignore) {
			throw new AssertionError();
		}
	}
	
	public TestEntity withDateTime(final DateTime d) {
		final TestEntity result = clone();
		result.dateTime = d;
		return result;
	}

	public TestEntity withLocalDate(final LocalDate d) {
		final TestEntity result = clone();
		result.localDate = d;
		return result;
	}

	public TestEntity withLocalTime(final LocalTime t) {
		final TestEntity result = clone();
		result.localTime = t;
		return result;
	}

	@Override
	public String toString() {
		return "TestEntity [dateTime=" + dateTime + ", localDate=" + localDate + ", localTime=" + localTime + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((dateTime == null)  ? 0 : dateTime.hashCode());
		result = prime * result + ((localDate == null) ? 0 : localDate.hashCode());
		result = prime * result + ((localTime == null) ? 0 : localTime.hashCode());
		return result;
	}

	@Override
	public boolean equals(final Object obj) {
		if (this == obj) return true;
		if (obj == null) return false;
		if (getClass() != obj.getClass()) return false;
		final TestEntity other = (TestEntity) obj;
		if (dateTime == null) {
			if (other.dateTime != null) return false;
		} else if (!dateTime.equals(other.dateTime)) return false;
		if (localDate == null) {
			if (other.localDate != null) return false;
		} else if (!localDate.equals(other.localDate)) return false;
		if (localTime == null) {
			if (other.localTime != null) return false;
		} else if (!localTime.equals(other.localTime)) return false;
		return true;
	}
	
	
	
}
