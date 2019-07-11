# Organisational-API
This is a spark-java api that enables one dispay the data from a database in form of a json object;

## Author

- **Victor Muchui**



## Getting Started

Clone this repository to your local machine to get Started

Github: [organisational-API](https://github.com/vmuchui/Organisational-API.git)

### Prerequisites

You need the following installed on your machine

- java
- JDK - Java Development Kit
- Maven
- Gradle
- An IDE - Intellij
- Postman - for testing the api

To confirm run the following command on linux

```
$ java --version
$ mvn --version
$ gradle --version
```

## Installing

After cloning to your local machine navigate to the folder you cloned into and open it with intellij.

- Navigate into the `src/main/java/App.java` and open it in intellij idea or your favorite editor.
- Go to your browser and type `localhost:4567`

After this you will probably get a 500 error since we do not have a database yet.
```
* In psql

`#create database org_api`
* In bash

`$ psql org_api < create.sql`

## Running the App
Navigate to the project directory through your terminal and type gradle run.


Your code should look something like this replacing your_username with your actual username.

```

moringa@moringa-Lenovo-V110-15ISK:~/your_username/JAVA/wild$ gradle run

```

## Built With

- [Java](https://www.java.com/) - The language used
- [Intellij Idea](https://www.jetbrains.com/idea/) - Integrated development
- [Spark]() - Framework

## Contributing

If you want to put out a pull request you first have to send us the sample code that you want to add to our repository for cross-checking before we allow the pull.

## Versioning

We use [Github](https://github.com/) for versioning. This is the first version of this application

## License

This project is licensed under the MIT License.
Copyright (c) 2019 Victor Muchui

Permission is hereby granted, free of charge, to any person obtaining a copy
of this software and associated documentation files (the "Software"), to deal
in the Software without restriction, including without limitation the rights
to use, copy, modify, merge, publish, distribute, sublicense, and/or sell
copies of the Software, and to permit persons to whom the Software is
furnished to do so, subject to the following conditions:

The above copyright notice and this permission notice shall be included in all
copies or substantial portions of the Software.

THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR
IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY,
FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE
AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER
LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM,
OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE
SOFTWARE.
