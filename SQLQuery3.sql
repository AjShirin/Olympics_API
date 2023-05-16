USE OlympicsDB;

SELECT * FROM athlete_information;
SELECT * FROM event_information;
SELECT * FROM medal_standing;
SELECT * FROM result_information;

DELETE FROM event_information WHERE is_active = 1;  