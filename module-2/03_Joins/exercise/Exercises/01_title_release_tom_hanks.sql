-- 1. The titles and release dates of movies that Tom Hanks has appeared in (47 rows)
--Hanks person_id = 31
SELECT movie.title || ' '|| '('||movie.release_date||')' AS TOM_HANKS_MOVIES FROM movie_actor
JOIN movie ON movie.movie_id = movie_actor.movie_id
WHERE actor_id = 31
ORDER BY movie.release_date asc