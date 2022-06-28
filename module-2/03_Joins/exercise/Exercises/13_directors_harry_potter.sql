-- 13. The directors of the movies in the "Harry Potter Collection" (4 rows) 10965, collection id 1241
SELECT DISTINCT person_name FROM movie
JOIN person ON person.person_id = movie.director_id
WHERE collection_id = 1241