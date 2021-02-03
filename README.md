# LIBRARY SYSTEM API

A simple REST application built on Spring Boot framework and PostgreSQL
It does not do much, it has the following request or endpoints 

## Endpoints
#### Books
|Description|HTTP Method|Endoint|
|:---:|:---:|:---:|
|Create| `POST`| `{{HOST}}/api/books`|
|Get All| `GET`| `{{HOST}}/api/books`|
|Get By Id| `GET`| `{{HOST}}/api/books/{{bookId}}`|
|Delete One| `DELETE`| `{{HOST}}/api/books/{{bookId}}`|
|Update One | `PUT` |`{{HOST}}/api/books/{{bookId}}`|
|Toggle Status| `PUT`| `{{HOST}}/api/books{{bookId}}`|

#### Authors
|Description|HTTP Method|Endoint|
|:---:|:---:|:---:|
|Create| `POST`| `{{HOST}}/api/authors`|
|Get All| `GET`| `{{HOST}}/api/authors`|
|Get By Id| `GET`| `{{HOST}}/api/authors/{{authorId}}`|
|Delete One| `DELETE`| `{{HOST}}/api/authors/{{authorId}}`|
|Update One | `PUT` |`{{HOST}}/api/authors/{{authorId}}`|
|Toggle Status| `PUT`| `{{HOST}}/api/authors{{authorId}}`|

#### Categories
|Description|HTTP Method|Endoint|
|:---:|:---:|:---:|
|Create| `POST`| `{{HOST}}/api/categories`|
|Get All| `GET`| `{{HOST}}/api/categories`|
|Get By Id| `GET`| `{{HOST}}/api/categories/{{categoryId}}`|
|Delete One| `DELETE`| `{{HOST}}/api/categories/{{categoryId}}`|
|Update One | `PUT` |`{{HOST}}/api/categories/{{categoryId}}`|


## How to run
I have already dockerised  the application.
To cut it short, just run the `main.sh` file in this current dir and it will take care of the rest.

You will need java 1.8, as I did not build the application the application before pushing this code.
You are more than welcome to do a PR to create and push the jar file.

Assuming that you have java installed,
Using your favourite linux machine terminal or using [git terminal](https://git-scm.com/downloads) (windows users) simply run `./main.sh`

If you're windows users and don't have [git terminal](https://git-scm.com/downloads) (might be the time to get git) 
run the `main.bat` file...., double click it or open this directory and run `main.bat` on `cmd`


## Consuming the REST service
I have added a Postman collection and a relevant ENV file, so grab those and fire-up your Postman app and make this API scream. 


## TODOS
 - [x] Dockerize
 - [x] Add Docker compose and seperate DB and app
 - [ ] Add front end - Maybe Vue JS
 - [ ] Deploy on Kubernetes cluster