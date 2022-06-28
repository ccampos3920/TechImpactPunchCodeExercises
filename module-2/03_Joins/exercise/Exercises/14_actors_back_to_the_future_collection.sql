-- 14. The names of actors who've appeared in the movies in the "Back to the Future Collection" (28 rows)
SELECT DISTINCT person_name FROM movie_actor
JOIN person ON person.person_id = movie_actor.actor_id
JOIN movie ON movie.movie_id = movie_actor.movie_id
WHERE collection_id = 264