# Spring Boot Validation
This project is a poc in order to understand how to make working the spring validation applied to rest controllers

## pre-requisites
Java

## How to try it
- call the endpoint /longCheck/{someValue}. If the value is greater than 100 you'll see a validation error
- call the endpoint /booleanCheck/{someValue}. If the value is false you'll see a validation error
- call the endpoint /booleanCheckWithBody. If the booleanValue field inside the request is null you'll see a validation error
