-- 5. The titles and release dates of all the movies that are in the Comedy genre. Order the results by release date, earliest to latest. (220 rows)
SELECT movie.title, movie.release_date FROM movie_genre
JOIN movie ON movie.movie_id = movie_genre.movie_id
WHERE genre_id = 35
ORDER BY release_date asc