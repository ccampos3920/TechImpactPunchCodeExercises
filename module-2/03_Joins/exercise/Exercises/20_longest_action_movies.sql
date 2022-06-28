-- 20. The titles, lengths, and release dates of the 5 longest movies in the "Action" genre.
--Order the movies by length (highest first), then by release date (latest first).
-- (5 rows, expected lengths around 180 - 200)

SELECT DISTINCT movie.title, movie.length_minutes, movie.release_date FROM movie_genre
JOIN movie ON movie.movie_id = movie_genre.movie_id
JOIN genre ON genre.genre_id = movie_genre.genre_id
WHERE genre_name = 'Action'
ORDER BY length_minutes DESC, length_minutes LIMIT 5
