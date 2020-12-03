# CovidStats

Covid Stats is an application that scrapes website data on covid and displays it via and Android/IOS app.

The Application combines multiple technologies this being python, java and Ionic as a proof of concept.

## Environment Requirements

Java 1.8 (Minimum)

Python 3.7

beautifulsoup4

NPM

Ionic



## Running Application 

Database

Run the below scripts to create the Database and table.

```SQL
CREATE SCHEMA COVID;

CREATE TABLE `covoid_cases` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT,
  `active_cases` varchar(255) DEFAULT NULL,
  `country_other` varchar(255) DEFAULT NULL,
  `new_cases` varchar(255) DEFAULT NULL,
  `new_deaths` varchar(255) DEFAULT NULL,
  `serious_critical` varchar(255) DEFAULT NULL,
  `tot_cases1mpop` varchar(255) DEFAULT NULL,
  `total_cases` varchar(255) DEFAULT NULL,
  `total_deaths` varchar(255) DEFAULT NULL,
  `total_recovered` varchar(255) DEFAULT NULL,
  PRIMARY KEY (`id`)
) ENGINE=InnoDB AUTO_INCREMENT=1 DEFAULT CHARSET=latin1;
```


Application broken down into 3 components.


## covid

This is the Java backend, Currently written using spring boot & Spring JPA.

Import this into to your IDE

Update the application.properties with your local settings.

Run Application.java to get the REST services up

## corona

This is the Ionic App. 

run from terminal using 
```bash
ionic serve
```

## webscrape
 
 This is the python webscraping service.
 
 run this from your terminal using
 ```bash
 python3 webscrape.py
 ```

