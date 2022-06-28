-- 7. The genres of movies that Christopher Lloyd has appeared in (8 rows)
-- Hint: DISTINCT will prevent duplicate values in your query results.

SELECT DISTINCT genre_name
FROM movie
JOIN movie_actor ON movie.movie_id = movie_actor.movie_id
JOIN movie_genre ON movie_genre.movie_id = movie.movie_id
JOIN genre ON movie_genre.genre_id = genre.genre_id
WHERE actor_id = 1062;
