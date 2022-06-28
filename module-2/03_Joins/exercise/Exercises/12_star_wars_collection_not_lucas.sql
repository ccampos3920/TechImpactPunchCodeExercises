-- 12. The titles of the movies in the "Star Wars Collection" that weren't directed by George Lucas (5 rows)
SELECT movie.title FROM movie
WHERE director_id != 1 AND collection_id = 10