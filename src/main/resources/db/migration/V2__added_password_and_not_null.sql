ALTER TABLE em_passenger
    ADD password VARCHAR(255);

ALTER TABLE em_passenger
    ALTER COLUMN password SET NOT NULL;

ALTER TABLE em_passenger
    ALTER COLUMN email SET NOT NULL;

ALTER TABLE em_driver
    ALTER COLUMN first_name SET NOT NULL;

ALTER TABLE em_passenger
    ALTER COLUMN first_name SET NOT NULL;

ALTER TABLE em_user
    ALTER COLUMN first_name SET NOT NULL;

ALTER TABLE em_driver
    ALTER COLUMN last_name SET NOT NULL;

ALTER TABLE em_passenger
    ALTER COLUMN last_name SET NOT NULL;

ALTER TABLE em_user
    ALTER COLUMN last_name SET NOT NULL;

ALTER TABLE em_passenger
    ALTER COLUMN phone_number SET NOT NULL;