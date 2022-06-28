-- 2. The names and birthdays of actors in "The Fifth Element" (15 rows)
SELECT person.person_name, person.birthday FROM movie_actor
JOIN person ON person.person_id = movie_actor.actor_id
WHERE movie_id = 18
ORDER BY person_name asc
