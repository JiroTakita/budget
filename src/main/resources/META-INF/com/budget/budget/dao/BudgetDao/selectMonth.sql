select
	*
from
    Budget
where
	date >= /* @roundDownTimePart(start) */'2018-01-01 12:34:56'
	and
	date < /* @roundDownTimePart(end) */'2018-01-01 12:34:56'
	and
	valid = /* valid */true
order by
    date asc