
  

# Spring Boot Application

  

Just a simple Spring Boot + H2 DB Backend to fool around. :)

  

# GET

*/books*

retrieves list of all books stored.


*/books/{id}*

* required: id of the book to be returned.

# POST

*/books*

allows to add new books to the endpoint and database.

example format:

```
{
"id": 0,
"author": "C. S. Lewis",
"isbn": "9780060276362",
"subtitle": null,
"title": "The Lion, the Witch and the Wardrobe",
"genre": "Fantasy"
}
```

# DELETE

*/books/{id}*

* required: id of the book to be deleted

# H2 DB

*/h2-console*

username: sa
password: 

persistent storage (book.h2.db.mv.db) used to view all the books in the database