ALTER TABLE em_booking
DROP
COLUMN total_duration;

ALTER TABLE em_booking
    ADD total_duration NUMERIC;