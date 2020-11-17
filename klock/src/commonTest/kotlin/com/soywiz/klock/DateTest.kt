package com.soywiz.klock

import kotlin.test.Test
import kotlin.test.assertEquals

class DateTest {
	@Test
	fun test() {
		val date = Date(2019, Month.September, 18)
		val date2 = Date(2019, Month.September, 19)
		val time = Time(13, 9, 37, 150)

		assertEquals(DayOfWeek.Wednesday, date.dayOfWeek)
		assertEquals(DayOfWeek.Thursday, date2.dayOfWeek)
		assertEquals(4, date2.dayOfWeekInt)
		assertEquals(1, Date(2019, Month.January, 1).dayOfYear)
		assertEquals(262, date2.dayOfYear)
		assertEquals(2019, date2.year)
		assertEquals(Year(2019), date2.yearYear)

		assertEquals("2019-09-18", date.toString())
		assertEquals("13:09:37.150", time.toString())
		assertEquals("Wed, 18 Sep 2019 00:00:00 UTC", (date.dateTimeDayStart).toString())
		assertEquals("Wed, 18 Sep 2019 13:09:37 UTC", (date + time).toString())
		assertEquals("2019-10-01", (Date(2019, Month.September, 30) + 1.days).toString())
		assertEquals("2019-10-30", (Date(2019, Month.September, 30) + 1.months).toString())
        assertEquals("2019-09-30", (Date(2019, Month.October, 1) - 1.days).toString())
        assertEquals("2019-09-01", (Date(2019, Month.October, 1) - 1.months).toString())

        assertEquals("2019-10-31", (Date(2019, Month.September, 30) + DateTimeSpan(1.months, 1.days)).toString())
        assertEquals("2019-08-31", (Date(2019, Month.October, 1) - DateTimeSpan(1.months, 1.days)).toString())

		(Time(9, 0) .. Time(19, 30)).let { range ->
			assertEquals(true, range.contains(Time(11, 0)))
			assertEquals(false, range.contains(Time(8, 59, 59, 999)))
			assertEquals(false, range.contains(Time(19, 31)))
		}

		(Date(2019, 9, 18) .. Date(2019, 10, 2)).let { range ->
			assertEquals(true, range.contains(Date(2019, 9, 18)))
			assertEquals(true, range.contains(Date(2019, 10, 1)))
			assertEquals(false, range.contains(Date(2019, 9, 17)))
			assertEquals(false, range.contains(Date(2019, 10, 3)))
		}

		assertEquals("Wed, 18 Sep 2019 00:00:00 UTC", (Date(2019, Month.September, 17) + Time(24)).toString())
        assertEquals("Tue, 17 Sep 2019 00:00:00 UTC", (Date(2019, Month.September, 18) - Time(24)).toString())

        assertEquals("Wed, 18 Sep 2019 01:02:20 UTC", (Date(2019, Month.September, 18) + Time(hour = 1, minute = 1, second = 80)).toString())
        val format = "EEE, dd MMM YYYY HH:mm:ss.SSS"
        assertEquals("Wed, 18 Sep 2019 01:02:20.300", (Date(2019, Month.September, 18) + Time(hour = 1, minute = 1, second = 80, millisecond = 300)).format(format))
        assertEquals("Wed, 18 Sep 2019 01:02:21.300", (Date(2019, Month.September, 18) + Time(hour = 1, minute = 1, second = 80, millisecond = 1300)).format(format))
        assertEquals("Wed, 18 Sep 2019 23:58:39.700", (Date(2019, Month.September, 18) - Time(hour = 1, minute = 1, second = 80, millisecond = 300)).format(format))
        assertEquals("Wed, 18 Sep 2019 23:58:38.700", (Date(2019, Month.September, 18) - Time(hour = 1, minute = 1, second = 80, millisecond = 1300)).format(format))
	}
}
