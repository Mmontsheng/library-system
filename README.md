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

Using your favourite linux machine terminal or using [git terminal](https://git-scm.com/downloads) (windows users) simply run `./main.sh`

If you're a windows user and don't have [git terminal](https://git-scm.com/downloads) (might be the time to get git)  :stuck_out_tongue_winking_eye:
run the `main.bat` file...., double click it or open this directory and run `main.bat` on `cmd`

## Consuming the REST service
#### Postman Collection
I have added a [Postman collection](https://github.com/Mmontsheng/library-system/tree/master/postman) and a relevant ENV file, so grab those and fire-up your [Postman app](https://www.postman.com/) and make this API scream. 

#### Swagger UI
To access the swagger UI, go to
`http://localhost:8080/swagger-ui/index.html?configUrl=/api-docs/swagger-config#/`

## Editing
I advice you to add [lombok](https://projectlombok.org/), be warned your IDE will most likely scream :ghost: at you for not adding lombok. 

## TODOS
 - [x] Dockerize
 - [x] Add Docker compose and seperate DB and app
 - [ ] Add front end - Maybe Vue JS
 - [ ] Deploy on Kubernetes cluster