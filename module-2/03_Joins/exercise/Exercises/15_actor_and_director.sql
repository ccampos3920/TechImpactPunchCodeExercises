-- 15. The title of the movie and the name of director for movies where the director was also an actor in the same movie (73 rows)
SELECT DISTINCT person_name, title FROM person
JOIN movie_actor ON actor_id = person_id
JOIN movie ON movie.movie_id = movie_actor.movie_id
WHERE director_id = person_id